package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.UserDtls;



public interface UserRepository extends JpaRepository<UserDtls,Integer>{
	
	public UserDtls findByEmail(String email);

}