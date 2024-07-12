package org.example.tp_spring.dto.candidate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CandidateDtoGet {
    private int candidateId;
    private String name;
    private String identificationNumber;
    private String address;
    private String phone;
    private String email;
    private LocalDate birthDate;
    private double rating;
    private String observation;
    private String skill;
    private String technicalArea;
    private LocalDate jobInterviewDate;
}

