package com.adrian.taskmanager.task;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class TaskController {
	private TaskService taskService;
	
	public TaskController(TaskService taskService) {
		this.taskService = taskService;
	}
	
	@GetMapping(path = "/tasks")
	public List<Task> getAllTasks() {
		return taskService.findAll();
	}
	
	@GetMapping(path = "/tasks/{id}")
	public Task getTaskById(@PathVariable int id) {
		return taskService.findById(id);
	}
	
	@PostMapping(path = "/users/{id}/tasks")
	public Task createTask(@PathVariable int id, @Valid @RequestBody Task task) {
		return taskService.createTask(task, id);
	}
	
	@DeleteMapping(path = "/tasks/{id}")
	public void deleteTaskById(@PathVariable int id) {
		taskService.delete(id);
	}
	
	@GetMapping(path = "/users/{id}/tasks")
	public List<Task> getTasksForUser(@PathVariable int id) {
		return taskService.findTasksByUserId(id);
	}
	
	@GetMapping(path = "/users/{userId}/tasks/{taskId}")
	public Task getTaskByIdForUser(@PathVariable int userId, @PathVariable int taskId) {
		return taskService.findTaskByIdAndUserId(userId, taskId);
	}
}
