package com.mnt.actimize.bfits.fcd.wire.api.serviceImpl;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.actimize.eventhandlerservice.wsdl.CMSData;
import com.actimize.eventhandlerservice.wsdl.CMSPortType8082;
import com.actimize.eventhandlerservice.wsdl.CMSRequestPartyAccount;
import com.actimize.eventhandlerservice.wsdl.SendCMSRequestType;
import com.mnt.actimize.bfits.fcd.wire.api.entity.ErrorLogEntity;
import com.mnt.actimize.bfits.fcd.wire.api.repo.ErrorLogRepository;

@Service
public class SoapService {

	@Autowired
	private Map<String, Object> soapClients;

	@Autowired
	private ErrorLogRepository errorLogRepository;

	private static final int MAX_RETRIES = 3;
	private AtomicInteger incr = new AtomicInteger(0);

	@Async("taskExecutor")
	@Retryable(value = { Exception.class }, // Retry on any Exception
			maxAttempts = MAX_RETRIES, // Maximum retry attempts
			backoff = @Backoff(delay = 1000) // Retry delay of 1 second
	)
	public void sendSoapRequest(String accountNumber) {
		try {
			CMSRequestPartyAccount account = new CMSRequestPartyAccount();
			account.setACCOUNTNUMBER(accountNumber);

			CMSData cmsData = new CMSData();
			cmsData.setCARDMAINTAINCETYPES("Type1");
			cmsData.getCMSREQUESTPARTYACCOUNT().add(account);

			SendCMSRequestType request = new SendCMSRequestType();
			request.setCMSData(cmsData);

			CMSPortType8082 cmsPort = (CMSPortType8082) soapClients.get("http://localhost:8082/ws");
			// Call the SOAP service
			cmsPort.sendCMS(request);

		} catch (Exception e) {

			throw e;
		}
	}

	// @Recover method will be invoked if all retry attempts fail
	@Recover
	public void recover(Exception e, String accountNumber) {
		// Save the error details to the database
		ErrorLogEntity errorLog = new ErrorLogEntity();
		errorLog.setErrorCode("SOAP_FAILURE");
		errorLog.setRequestData(accountNumber);
		errorLog.setErrorMessage(e.getMessage());
		errorLog.setAttemptCount(MAX_RETRIES);
		errorLogRepository.save(errorLog);
	}
}
