package com.ecoroute.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class RouteStopDto {
    @NotNull(message = "Location ID is required")
    private Long locationId;
    
    @NotNull(message = "Sequence number is required")
    private Integer sequenceNumber;
    
    private Integer estimatedDuration;
    private String notes;
} 