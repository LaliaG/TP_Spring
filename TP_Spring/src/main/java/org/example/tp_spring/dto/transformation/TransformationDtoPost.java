package org.example.tp_spring.dto.transformation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TransformationDtoPost {
    @NotBlank
    private String candidateName;

    @NotBlank
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String phone;

    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String birthDate;

    @NotBlank
    private String occupation;

    @NotBlank
    private String password;

    private boolean admin;

    private double salary;

    @NotBlank
    private String observation;
}
