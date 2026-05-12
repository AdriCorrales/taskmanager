package com.adrian.taskmanager.task.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = false)
public class TaskUpdateRequest {

    @Size(min = 1, message = "Title cannot be empty")
    private String title;

    private String description;

    @Pattern(regexp = "PENDING|IN_PROGRESS|COMPLETED", message = "Status must be one of: PENDING, IN_PROGRESS, COMPLETED")
    private String status;

    public TaskUpdateRequest() {
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
