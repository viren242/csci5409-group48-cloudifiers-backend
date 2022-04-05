package com.cloudifiers.service;

import java.util.List;

import com.cloudifiers.entity.PostEntity;

public interface ITimelineManagementService {

	public List<PostEntity> generateTimeline(Integer userId);

}
