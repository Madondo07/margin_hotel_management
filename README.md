# Margin Hotel Management System

Backend for Margin Hotel — a capstone project (ADP372S) that digitises front-desk operations for a small hotel chain in South Africa.

## Project summary

This repository contains the complete backend (domain model → REST controllers). The public booking website and staff UI are out of scope.

## Tech stack

- Java 17
- Spring Boot 4.1.0
- Spring Data JPA / Hibernate
- MySQL (runtime)
- Maven (wrapper included)
- MapStruct, Lombok (annotation processors), Flyway

(See pom.xml for exact dependencies and versions.)


## API reference

Detailed controller routes and example requests are documented in API_ENDPOINTS.md in the repository root. Key base paths exposed by the controllers:

- /booking
- /guest
- /invoice
- /payment
- /staff

## Core business rules (high level)

- All domain attributes are mandatory except Name.middleName.
- Factories return null on validation failures (do not throw IllegalArgumentException).
- No null or empty-string values are persisted for required fields.
- Anti-double-booking enforced in the service layer (no overlapping bookings for same room).
- 1 Booking → 1 Invoice → 1 Payment (no partial payments supported).

## Security

Spring Security configuration and notes. Future tasks:
- Add authentication (JWT or session-based)
- Role-based access control (Manager vs Receptionist vs Public)
- Secure endpoints and document required scopes/roles
