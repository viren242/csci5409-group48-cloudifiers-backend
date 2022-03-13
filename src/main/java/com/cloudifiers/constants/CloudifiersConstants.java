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
	}	
	
	public static class ControllerInfo {
		public static final String USER_MANAGEMENT_CONTROLLER_VALUE = "User Management Controller";
		public static final String USER_MANAGEMENT_CONTROLLER_DESC = "Performs save, update, and delete operations on user";
	}
	
	public static class DatabaseConstants {
		public static final String FETCH_USER_QUERY = "SELECT u FROM UserEntity u WHERE u.email = :email AND u.password = :password";
	}
	
	public static class ParameterConstants {
		public static final String EMAIL = "email";
		public static final String PASSWORD = "password";
	}
}
