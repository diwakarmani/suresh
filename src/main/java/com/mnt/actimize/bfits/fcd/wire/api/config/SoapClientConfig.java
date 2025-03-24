package com.mnt.actimize.bfits.fcd.wire.api.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.cxf.configuration.jsse.TLSClientParameters;
import org.apache.cxf.frontend.ClientProxy;
import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.apache.cxf.transport.http.HTTPConduit;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SoapClientConfig {

	// HTTP Client Bean with connection pooling
	@Bean
	public CloseableHttpClient httpClient() {
		PoolingHttpClientConnectionManager poolingConnManager = new PoolingHttpClientConnectionManager();
		poolingConnManager.setMaxTotal(50); // Max total connections
		poolingConnManager.setDefaultMaxPerRoute(10); // Max connections per SOAP endpoint

		return HttpClients.custom().setConnectionManager(poolingConnManager).build();
	}

	// Factory method to create SOAP clients dynamically
	private <T> T createSoapClient(Class<T> serviceClass, String serviceUrl) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();
		factory.setServiceClass(serviceClass);
		factory.setAddress(serviceUrl);

		// Create the SOAP client proxy
		T service = (T) factory.create();

		// Configure the HTTP conduit (timeouts, TLS, etc.)
		HTTPConduit conduit = (HTTPConduit) ClientProxy.getClient(service).getConduit();
		conduit.getClient().setConnectionTimeout(60000); // Connection timeout
		conduit.getClient().setReceiveTimeout(60000); // Receive timeout

		// Optionally, set TLS parameters if required
		TLSClientParameters tlsParams = new TLSClientParameters();
		conduit.setTlsClientParameters(tlsParams);

		return service;
	}

	// Configuration property that lists all WSDL URLs (can come from
	// application.properties or YAML)
	@Value("#{'${soap.wsdl.urls}'.split(',')}")
	private List<String> wsdlUrls;

	@Value("#{'${soap.wsdl.classes}'.split(',')}")
	private List<String> wsdlClasses;

	// Create dynamic beans for all WSDLs defined in properties
	@Bean
	public Map<String, Object> dynamicSoapClients() {
		Map<String, Object> clients = new HashMap<>();

		if (wsdlUrls.size() == wsdlClasses.size()) {
			for (int i = 0; i < wsdlUrls.size(); i++) {
				try {
					String wsdlUrl = wsdlUrls.get(i);
					String className = wsdlClasses.get(i);
					Class<?> serviceClass = Class.forName(className);

					Object client = createSoapClient(serviceClass, wsdlUrl);
					clients.put(wsdlUrl, client); // Store the client in the map with URL as the key
				} catch (ClassNotFoundException e) {
					throw new RuntimeException("Error while creating client for WSDL: " + wsdlUrls.get(i), e);
				}
			}
		} else {
			throw new RuntimeException("Mismatch between WSDL URLs and service class definitions.");
		}

		return clients;
	}
}
