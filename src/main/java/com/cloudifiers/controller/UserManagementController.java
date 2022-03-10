package com.cloudifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cloudifiers.service.IUserManagementService;

@RestController
public class UserManagementController {

	@Autowired
	private IUserManagementService userManagementService;
}
