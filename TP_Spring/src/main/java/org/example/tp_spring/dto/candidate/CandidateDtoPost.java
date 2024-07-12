package org.example.tp_spring.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CandidateDtoPost {
    @NotBlank
    @Size(max = 255)
    private String name;

    @NotBlank
    @Pattern(regexp = "^[a-zA-Z0-9]+$")
    private String identificationNumber;

    @NotBlank
    @Size(max = 255)
    private String address;

    @NotBlank
    @Pattern(regexp = "^\\+?[0-9. ()-]{7,25}$")
    private String phone;

    @NotBlank
    @Email
    @Size(max = 255)
    private String email;

    @NotNull
    @Past
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String birthDateStr;

    @NotNull
    @Min(0)
    @Max(10)
    private Integer rating;

    @Size(max = 255)
    private String observation;

    @NotBlank
    @Size(max = 255)
    private String skill;

    @NotBlank
    @Size(max = 255)
    private String technicalArea;

    @NotNull
    private String jobInterviewDateStr;
}
