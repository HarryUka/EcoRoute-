package com.ecoroute.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface RouteRepository extends JpaRepository<Route, Long> {
    List<Route> findByUserId(Long userId);
    List<Route> findByUserIdAndStatus(Long userId, RouteStatus status);
} 