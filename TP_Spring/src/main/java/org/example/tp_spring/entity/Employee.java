package org.example.tp_spring.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int employeeId;

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

    private LocalDate birthDate;
    private LocalDate contractStart;
    private LocalDate contractEnd;
    private String occupation;
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$", message = "Invalid Field")
    private String password;
    private boolean admin;
    private double salary;
    @Column(columnDefinition = "text")
    private String observation;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Absence> absences;

    @OneToMany(mappedBy = "employee")
    @JsonIgnore
    private List<Vacation> vacations;
}
