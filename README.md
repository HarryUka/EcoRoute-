# EcoRoute+ API

A simple Spring Boot application demonstrating a complete SDLC with AWS integration.

## Features
- User management (register/login)
- Basic route tracking
- AWS integration
- CI/CD with GitHub Actions

## Tech Stack
- Java 17
- Spring Boot 3.x
- PostgreSQL
- AWS (ECS, RDS)
- GitHub Actions

## Local Development
1. Prerequisites:
   - Java 17
   - Maven
   - Docker
   - PostgreSQL

2. Setup:
   ```bash
   git clone <repository-url>
   cd ecoroute-plus
   mvn clean install
   ```

3. Run:
   ```bash
   mvn spring-boot:run
   ```

## API Endpoints
- POST /api/users - Register user
- POST /api/auth/login - Login
- GET /api/routes - List routes
- POST /api/routes - Create route

## Deployment
The application is automatically deployed to AWS using GitHub Actions when pushing to main branch.
