package com.ecoroute.service;

import java.util.List;

public interface RouteService {
    Route createRoute(Long userId, RouteDto routeDto);
    Route updateRoute(Long id, RouteDto routeDto);
    void deleteRoute(Long id);
    Route getRouteById(Long id);
    List<Route> getRoutesByUser(Long userId);
    List<Route> getRoutesByUserAndStatus(Long userId, RouteStatus status);
    Route optimizeRoute(Long routeId);
    Double calculateCO2Emissions(Long routeId);
} 