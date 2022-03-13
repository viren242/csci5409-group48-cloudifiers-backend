package com.cloudifiers.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cloudifiers.constants.CloudifiersConstants.DatabaseConstants;
import com.cloudifiers.constants.CloudifiersConstants.ParameterConstants;
import com.cloudifiers.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer> {

	@Query(value = DatabaseConstants.FETCH_USER_QUERY)
	public Optional<UserEntity> fetchUser(@Param(ParameterConstants.EMAIL) String email,
			@Param(ParameterConstants.PASSWORD) String password);

}
