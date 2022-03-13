package com.cloudifiers.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloudifiers.entity.UserEntity;
import com.cloudifiers.exception.NoUserFoundException;
import com.cloudifiers.model.LoginRequestModel;
import com.cloudifiers.repository.UserRepository;

@Service
public class UserManagementService implements IUserManagementService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserEntity fetchUser(Integer userId) throws Exception {
		return userRepository.findById(userId).orElseThrow(() -> new NoUserFoundException());
	}

	@Override
	public UserEntity fetchUser(LoginRequestModel loginRequestModel) throws Exception {
		return userRepository.fetchUser(loginRequestModel.getEmail(), loginRequestModel.getPassword())
				.orElseThrow(() -> new NoUserFoundException());
	}

	@Override
	public UserEntity saveUser(UserEntity userEntity) {
		return userRepository.save(userEntity);
	}
}
