package com.cloudifiers.model;

import com.cloudifiers.entity.UserEntity;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class UserEntityResponse {

	@JsonProperty("success")
	private Boolean success;
	
	@JsonProperty("errorCode")
	private String errorCode;

	@JsonProperty("user")
	private UserEntity userEntity;
	
	public UserEntityResponse(Boolean success, String errorCode, UserEntity userEntity) {
		this.success = success;
		this.errorCode = errorCode;
		this.userEntity = userEntity;
	}
}
