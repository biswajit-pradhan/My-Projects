package com.feedbackservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.feedbackservice.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
