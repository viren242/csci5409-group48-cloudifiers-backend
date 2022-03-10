package com.cloudifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudifiers.service.ICloudifiersService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "Cloudifiers Controller", description = "It contains APIs to check whether the service is working or not!")
@RestController
public class CloudifiersController {

	@Autowired
	private ICloudifiersService cloudifiersService;

	@ApiOperation(value = "Check whether the application is working or not", response = String.class)
	@GetMapping("/test")
	private ResponseEntity<String> isApplicationWorking() {
		return new ResponseEntity<String>(cloudifiersService.isApplicationWorking(), HttpStatus.OK);
	}
}
