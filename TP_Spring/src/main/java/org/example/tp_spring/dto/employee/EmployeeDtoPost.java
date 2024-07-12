package org.example.tp_spring.dto.employee;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class EmployeeDtoPost {
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
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
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String birthDateStr;

    @NotNull
    @Past
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String contractStartStr;

    @NotNull
    @Past
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)")
    @NotBlank
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private String contractEndStr;

    @NotBlank
    @Size(max = 255)
    private String occupation;

    @NotBlank
    @Size(min = 8, max = 255)
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{12,}$", message = "Invalid Field")
    private String password;
    @NotNull
    private Double salary;

    @Size(max = 255)
    private String observation;

    public boolean isAdmin() {
        return true;
    }

    //public void setAdmin(boolean admin) {
       // this.admin = admin;
   // }
}
