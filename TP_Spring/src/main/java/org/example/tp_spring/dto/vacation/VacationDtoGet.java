package org.example.tp_spring.dto.vacation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_spring.dto.employee.EmployeeDtoGet;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VacationDtoGet {
    private int vacationId;
    private LocalDate startDate;
    private LocalDate endDate;
    private EmployeeDtoGet employee;
}
