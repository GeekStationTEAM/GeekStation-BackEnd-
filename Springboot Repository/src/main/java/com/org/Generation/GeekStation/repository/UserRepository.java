package com.org.Generation.GeekStation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.org.Generation.GeekStation.model.UserEntity;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

	//crear metodo query de jpa 
		@Query("SELECT u FROM UserEntity u WHERE u.email = ?1")
		UserEntity finByEmail(String email);
}
