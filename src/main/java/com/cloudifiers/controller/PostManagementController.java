package com.cloudifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cloudifiers.service.IPostManagementService;

@RestController
public class PostManagementController {

	@Autowired
	private IPostManagementService postManagementService;
}
