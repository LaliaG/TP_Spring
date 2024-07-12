package org.example.tp_spring.dto.absence;

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
public class AbsenceDtoPost {
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String absenceDateStr;

    @NotBlank
    private String employeeName;
}
