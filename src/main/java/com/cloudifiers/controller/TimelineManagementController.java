package com.cloudifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.cloudifiers.service.ITimelineManagementService;

@RestController
public class TimelineManagementController {

	@Autowired
	private ITimelineManagementService timelineManagementService;
}
