package com.adrian.taskmanager.task.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class TaskStatusUpdateRequest {

    @JsonProperty("status")
    @JsonAlias({"STATUS"})
    @NotBlank(message = "Status is required")
    private String status;

    public TaskStatusUpdateRequest() {
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
