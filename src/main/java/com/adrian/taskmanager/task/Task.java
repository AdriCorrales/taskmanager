package com.adrian.taskmanager.task;

import java.time.LocalDateTime;

import com.adrian.taskmanager.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Size;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private int id;
	
	@Size(min = 1, message = "Title cannot be null")
	private String title;
	
	private String description;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@Enumerated(EnumType.STRING)
	private TaskStatus status;
	
	@ManyToOne
	@JsonIgnore
	private User user;

	public Task() {
		
	}
	
	public Task(String title, String description) {
		super();
		this.title = title;
		this.description = description;
		this.createdAt = LocalDateTime.now();
		this.status = TaskStatus.PENDING;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public TaskStatus getStatus() {
		return status;
	}

	public void setStatus(TaskStatus status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
