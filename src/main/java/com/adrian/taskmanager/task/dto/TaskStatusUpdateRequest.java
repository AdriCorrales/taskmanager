package com.adrian.taskmanager.task.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@JsonIgnoreProperties(ignoreUnknown = false)
public class TaskStatusUpdateRequest {

    @JsonProperty("status")
    @JsonAlias({"STATUS"})
    @NotBlank(message = "Status is required")
    @Pattern(regexp = "PENDING|IN_PROGRESS|COMPLETED", message = "Status must be one of: PENDING, IN_PROGRESS, COMPLETED")
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
