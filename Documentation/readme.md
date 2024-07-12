src/main/java/com/example/gestionrh/
├── controller
│   ├── EmployeeController.java
│   ├── CandidateController.java
│   ├── AbsenceController.java
│   ├── VacationController.java
│   └── TransformationController.java
├── dto
│   ├── employee
│   │   ├── EmployeeDtoGet.java
│   │   └── EmployeeDtoPost.java
│   ├── candidate
│   │   ├── CandidateDtoGet.java
│   │   └── CandidateDtoPost.java
│   ├── absence
│   │   ├── AbsenceDtoGet.java
│   │   └── AbsenceDtoPost.java
│   └── vacation
│       ├── VacationDtoGet.java
│       └── VacationDtoPost.java
├── entity
│   ├── Employee.java
│   ├── Candidate.java
│   ├── Absence.java
│   └── Vacation.java
├── exception
│   ├── GeneralExceptionHandler.java
│   └── NotFoundException.java
├── repository
│   ├── EmployeeRepository.java
│   ├── CandidateRepository.java
│   ├── AbsenceRepository.java
│   └── VacationRepository.java
├── service
│   ├── BaseService.java
│   ├── EmployeeService.java
│   ├── CandidateService.java
│   ├── AbsenceService.java
│   ├── VacationService.java
│   └── TransformationService.java
└── util
    └── Role.java
