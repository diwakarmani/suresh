
package com.actimize.eventhandlerservice.wsdl;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.actimize.eventhandlerservice.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _SendCMSRequest_QNAME = new QName("http://efe-7papps001.dev.mtb.com", "sendCMSRequest");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.actimize.eventhandlerservice.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link SendCMSRequestType }
     * 
     */
    public SendCMSRequestType createSendCMSRequestType() {
        return new SendCMSRequestType();
    }

    /**
     * Create an instance of {@link CMSRequestPartyAccount }
     * 
     */
    public CMSRequestPartyAccount createCMSRequestPartyAccount() {
        return new CMSRequestPartyAccount();
    }

    /**
     * Create an instance of {@link CMSData }
     * 
     */
    public CMSData createCMSData() {
        return new CMSData();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SendCMSRequestType }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SendCMSRequestType }{@code >}
     */
    @XmlElementDecl(namespace = "http://efe-7papps001.dev.mtb.com", name = "sendCMSRequest")
    public JAXBElement<SendCMSRequestType> createSendCMSRequest(SendCMSRequestType value) {
        return new JAXBElement<SendCMSRequestType>(_SendCMSRequest_QNAME, SendCMSRequestType.class, null, value);
    }

}
