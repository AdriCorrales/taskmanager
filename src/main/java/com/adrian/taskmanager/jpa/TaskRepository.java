package com.adrian.taskmanager.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adrian.taskmanager.task.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
	Optional<Task> findByIdAndUserId(int taskId, int userId);
}
