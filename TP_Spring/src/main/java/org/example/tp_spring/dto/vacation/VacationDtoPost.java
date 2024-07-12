package org.example.tp_spring.dto.vacation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VacationDtoPost {
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String startDateStr;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String endDateStr;

    @NotBlank
    private String employeeName;
}
