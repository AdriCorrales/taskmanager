package com.adrian.taskmanager.user;

import java.time.LocalDateTime;
import java.util.List;

import com.adrian.taskmanager.task.Task;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Size;

@Entity(name = "user_details")
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	
	@Size(min = 1, message = "Name shouldn't be empty")
	private String username;
	
	@Size(min = 1, message = "Password shouldn't be empty")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String password;
	
	@Column(name = "created_at")
	private LocalDateTime createdAt;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	List<Task> tasks;
	
	public User() {
		
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
		this.createdAt = LocalDateTime.now();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + ", createdAt=" + createdAt + "]";
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}
	
	
}
