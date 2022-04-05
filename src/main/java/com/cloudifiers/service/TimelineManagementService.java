package com.cloudifiers.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudifiers.entity.PostEntity;
import com.cloudifiers.repository.PostRepository;

@Service
public class TimelineManagementService implements ITimelineManagementService {

	@Autowired
	private PostRepository postRepository;

	@Override
	public List<PostEntity> generateTimeline(Integer userId) {
		return postRepository.getTimeline(userId);
	}

}
