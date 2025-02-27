package com.ecoroute.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional
public class RouteServiceImpl implements RouteService {

    private final RouteRepository routeRepository;
    private final UserService userService;

    @Override
    public Route createRoute(Long userId, RouteDto routeDto) {
        User user = userService.getUserById(userId);
        
        Route route = Route.builder()
                .name(routeDto.getName())
                .user(user)
                .scheduledStart(routeDto.getScheduledStart())
                .status(RouteStatus.PLANNED)
                .build();

        // Convert DTOs to entities and set the sequence
        List<RouteStop> stops = routeDto.getStops().stream()
                .map(stopDto -> RouteStop.builder()
                        .sequenceNumber(stopDto.getSequenceNumber())
                        .estimatedDuration(stopDto.getEstimatedDuration())
                        .notes(stopDto.getNotes())
                        .build())
                .collect(Collectors.toList());

        route.setStops(stops);
        
        return routeRepository.save(route);
    }

    @Override
    public Route updateRoute(Long id, RouteDto routeDto) {
        Route route = getRouteById(id);
        route.setName(routeDto.getName());
        route.setScheduledStart(routeDto.getScheduledStart());
        
        // Update stops
        route.getStops().clear();
        route.getStops().addAll(routeDto.getStops().stream()
                .map(stopDto -> RouteStop.builder()
                        .sequenceNumber(stopDto.getSequenceNumber())
                        .estimatedDuration(stopDto.getEstimatedDuration())
                        .notes(stopDto.getNotes())
                        .build())
                .collect(Collectors.toList()));

        return routeRepository.save(route);
    }

    @Override
    public void deleteRoute(Long id) {
        routeRepository.deleteById(id);
    }

    @Override
    @Transactional(readOnly = true)
    public Route getRouteById(Long id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Route not found"));
    }

    @Override
    @Transactional(readOnly = true)
    public List<Route> getRoutesByUser(Long userId) {
        return routeRepository.findByUserId(userId);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Route> getRoutesByUserAndStatus(Long userId, RouteStatus status) {
        return routeRepository.findByUserIdAndStatus(userId, status);
    }

    @Override
    public Route optimizeRoute(Long routeId) {
        Route route = getRouteById(routeId);
        // TODO: Implement route optimization algorithm
        return route;
    }

    @Override
    public Double calculateCO2Emissions(Long routeId) {
        Route route = getRouteById(routeId);
        // TODO: Implement CO2 emissions calculation
        return 0.0;
    }
} 