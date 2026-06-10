# E-RANK System Architecture

## Overview

The E-RANK system is a digital taxi rank management and passenger safety system. It enables:
- Digital queue management for drivers
- Electronic passenger registration for long-distance trips
- Real-time fleet monitoring for taxi owners
- Ride verification and fare tracking

## Complete Architecture Documentation

The full System Requirements Specification (Phase 2) containing all architecture diagrams, functional requirements, and non-functional requirements is available here:

**[Download Phase 2 SRS Document](../phase2-srs.pdf)**

> *This document includes:*
> - Activity diagrams for all 5 business processes
> - Use case diagram
> - Context diagram  
> - State diagram
> - Sequence diagram
> - Class diagram
> - Full functional and non-functional requirements
> - Project WBS and Gantt chart

## Key Diagrams Quick Reference

| Diagram | Location in PDF |
|:--------|:----------------|
| Driver Registers for Queue | Figure 1.1 |
| Passenger Registration | Figure 1.2 |
| Marshal Manages Queue | Figure 1.3 |
| Driver Verifies Ride Completion | Figure 1.4 |
| Owner Monitors Fleet | Figure 1.5 |
| Use Case Diagram | Figure 5.1 |
| Context Diagram | Figure 5.2 |
| State Diagram | Figure 5.3 |
| Sequence Diagram | Figure 5.4 |
| Class Diagram | Figure 5.5 |
| WBS | Figure 6.1 |
| Gantt Chart | Figure 6.2 |

## Technology Stack

| Component | Technology |
|:----------|:-----------|
| Backend | Java (to be decided) |
| Marshal Tablet App | Android 11+ / iPadOS 15+ |
| Driver Mobile App | Android 9+ / iOS 14+ |
| Owner Dashboard | Web-based |
| Database | Cloud (AWS/Azure/GCP) |
| Encryption | AES-256 |

## Key Non-Functional Requirements

| Category | Target |
|:---------|:-------|
| Queue Accuracy | 99.9% |
| Availability | 98% (5 AM - 9 PM) |
| QR Scan Response | < 3 seconds |
| Dashboard Load | < 5 seconds |
| Concurrent Users | 100+ |
