package com.adrian.taskmanager.task;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.adrian.taskmanager.jpa.TaskRepository;
import com.adrian.taskmanager.jpa.UserRepository;
import com.adrian.taskmanager.user.User;
import com.adrian.taskmanager.user.UserNotFoundException;

@Service
public class TaskService {
	private TaskRepository taskRepository;
	private UserRepository userRepository;
	
	public TaskService(TaskRepository taskRepository, UserRepository userRepository) {
		this.taskRepository = taskRepository;
		this.userRepository = userRepository;
	}
	
	public List<Task> findAll() {
		return taskRepository.findAll();
	}
	
	public Task findById(int id) {
		Optional<Task> taskOptional = taskRepository.findById(id);
		if (taskOptional.isEmpty()) {
			throw new TaskNotFoundException("Task not found: " + id);
		}
		return taskOptional.get();
	}
	
	public Task createTask(Task task, int userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found: " + userId);
		} 
		
		task.setUser(user.get());
		return taskRepository.save(task);
	}
	
	public void delete(int id) {
		if (!taskRepository.existsById(id)) {
            throw new UserNotFoundException("Task not found: " + id);
        }
        taskRepository.deleteById(id);
	}
	
	public List<Task> findTasksByUserId(int userId) {
		Optional<User> user = userRepository.findById(userId);
		
		if (user.isEmpty()) {
			throw new UserNotFoundException("User not found: " + userId);
		}
		
		return user.get().getTasks();
	}
	
	public Task findTaskByIdAndUserId(int userId, int taskId) {
		Optional<Task> task = taskRepository.findByIdAndUserId(taskId, userId);
		
		if (task.isEmpty()) {
			throw new UserNotFoundException("Task not found: " + taskId + " for User: " + userId);
		} 
				
		return task.get();
	}
}
