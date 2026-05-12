package com.adrian.taskmanager.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = false)
public class TaskCreationRequest {

    @NotBlank(message = "Title is required")
    @Size(min = 1, message = "Title cannot be null")
    private String title;

    private String description;

    public TaskCreationRequest() {
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
}
