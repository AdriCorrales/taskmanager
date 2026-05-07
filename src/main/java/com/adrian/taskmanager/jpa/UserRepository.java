package com.adrian.taskmanager.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.taskmanager.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
