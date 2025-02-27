package com.ecoroute.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Route extends BaseEntity {

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String startLocation;

    @Column(nullable = false)
    private String endLocation;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    private Double distance;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "route_id")
    @Builder.Default
    private List<RouteStop> stops = new ArrayList<>();

    private LocalDateTime scheduledStart;
    
    private Double totalDistance;
    
    private Double estimatedCO2Emission;
    
    @Enumerated(EnumType.STRING)
    private RouteStatus status;
} 