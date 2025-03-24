package com.mnt.actimize.bfits.fcd.wire.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mnt.actimize.bfits.fcd.wire.api.serviceImpl.SoapService;

@RestController
@RequestMapping("/api/soap")
public class SoapController {

	@Autowired
	private SoapService soapService;

	@PostMapping("/sendRequest")
	public void sendRequest(@RequestBody String accountNumber) {
		soapService.sendSoapRequest(accountNumber);
	}
}
