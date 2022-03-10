package com.cloudifiers.service;

import org.springframework.stereotype.Service;

@Service
public class CloudifiersService implements ICloudifiersService {

	@Override
	public String isApplicationWorking() {
		return "It's working";
	}

}
