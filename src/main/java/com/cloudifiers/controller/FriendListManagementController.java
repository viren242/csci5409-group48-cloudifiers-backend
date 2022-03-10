package com.cloudifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cloudifiers.service.IFriendListManagementService;

@RestController
public class FriendListManagementController {

	@Autowired
	private IFriendListManagementService friendListManagementService;
	
}
