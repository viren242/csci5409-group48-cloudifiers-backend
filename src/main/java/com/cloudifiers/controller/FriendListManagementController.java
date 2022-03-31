package com.cloudifiers.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloudifiers.constants.CloudifiersConstants;
import com.cloudifiers.constants.CloudifiersConstants.ApiEndPoints;
import com.cloudifiers.entity.FriendEntity.FriendId;
import com.cloudifiers.model.Error;
import com.cloudifiers.model.FriendListResponse;
import com.cloudifiers.model.ResponseStatus;
import com.cloudifiers.service.IFriendListManagementService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(CloudifiersConstants.BASE_API_URL)
public class FriendListManagementController {

	@Autowired
	private IFriendListManagementService friendListManagementService;

	@ApiOperation(value = ApiEndPoints.ADD_FRIEND_DESC, response = ResponseStatus.class)
	@PostMapping(ApiEndPoints.ADD_FRIEND_URL)
	public ResponseEntity<ResponseStatus> addFriend(@RequestBody FriendId friendId) {
		friendListManagementService.addFriend(friendId);
		return new ResponseEntity<ResponseStatus>(new ResponseStatus(Boolean.TRUE, Error.NO_ERROR.getErrorCode()),
				HttpStatus.OK);
	}

	@ApiOperation(value = ApiEndPoints.REMOVE_FRIEND_DESC, response = ResponseStatus.class)
	@PostMapping(ApiEndPoints.REMOVE_FRIEND_URL)
	public ResponseEntity<ResponseStatus> removeFriend(@RequestBody FriendId friendId) {
		friendListManagementService.removeFriend(friendId);
		return new ResponseEntity<ResponseStatus>(new ResponseStatus(Boolean.TRUE, Error.NO_ERROR.getErrorCode()),
				HttpStatus.OK);
	}

	@ApiOperation(value = ApiEndPoints.GET_FRIENDS_DESC, response = FriendListResponse.class)
	@GetMapping(ApiEndPoints.GET_FRIENDS_URL)
	public ResponseEntity<FriendListResponse> getFriends(@PathVariable("userId") Integer userId) {
		return new ResponseEntity<FriendListResponse>(new FriendListResponse(Boolean.TRUE,
				Error.NO_ERROR.getErrorCode(), friendListManagementService.getFriends(userId)), HttpStatus.OK);
	}
}
