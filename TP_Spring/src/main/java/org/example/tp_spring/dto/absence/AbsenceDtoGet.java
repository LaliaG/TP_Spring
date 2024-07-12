package org.example.tp_spring.dto.absence;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.tp_spring.dto.employee.EmployeeDtoGet;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AbsenceDtoGet {
    private int absenceIdd;
    private LocalDate absenceDate;
    private EmployeeDtoGet employee;
}
