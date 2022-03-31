package com.cloudifiers.constants;

public class CloudifiersConstants {

	public static final String BASE_API_URL = "/v1/api";
	
	public static class ApiEndPoints {
		public static final String SAVE_USER_URL = "/user";
		public static final String SAVE_USER_DESC = "Create a new user if the userId field is null, otherwise update the existing user with id userId";
		
		public static final String FETCH_USER_URL = "/user/{userId}";
		public static final String FETCH_USER_DESC = "Fetches user with the given userId";
		
		public static final String LOGIN_URL = "/login";
		public static final String LOGIN_DESC = "Fetches user with the given email and password";
		
		public static final String ADD_FRIEND_URL = "/friend/add";
		public static final String ADD_FRIEND_DESC = "Add a friend into friend list";
		
		public static final String REMOVE_FRIEND_URL = "/friend/remove";
		public static final String REMOVE_FRIEND_DESC = "Remove a friend from friend list";
		
		public static final String GET_FRIENDS_URL = "/friend/list/{userId}";
		public static final String GET_FRIENDS_DESC = "Find list of friends of user userId";
	}	
	
	public static class ControllerInfo {
		public static final String USER_MANAGEMENT_CONTROLLER_VALUE = "User Management Controller";
		public static final String USER_MANAGEMENT_CONTROLLER_DESC = "Performs save, update, and delete operations on user";
	}
	
	public static class DatabaseConstants {
		public static final String FETCH_USER_QUERY = "SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password";
		public static final String FETCH_FRIENDS_QUERY = "SELECT u FROM FriendEntity f LEFT JOIN UserEntity u ON f.friendId.user2Id = u.userId WHERE f.friendId.user1Id = :userId";
	}
	
	public static class ParameterConstants {
		public static final String EMAIL = "email";
		public static final String PASSWORD = "password";
		public static final String USER_ID = "userId";
	}
}
