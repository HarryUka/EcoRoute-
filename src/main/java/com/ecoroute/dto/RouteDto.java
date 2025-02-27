package com.ecoroute.dto;

import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RouteDto {
    @NotBlank(message = "Route name is required")
    private String name;
    
    @NotNull(message = "Scheduled start time is required")
    private LocalDateTime scheduledStart;
    
    @NotNull(message = "At least one stop is required")
    private List<RouteStopDto> stops;
} 