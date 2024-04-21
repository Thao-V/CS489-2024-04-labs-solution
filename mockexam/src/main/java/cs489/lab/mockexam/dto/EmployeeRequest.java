package cs489.lab.mockexam.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record EmployeeRequest(
        @NotBlank(message = "First Name is required.")
        String firstName,
        @NotBlank(message = "Last name is required")
        String lastName,
        Double yearlySalary,
        @NotBlank(message = "Reference Number is required")
        String referenceNumber,
        @NotNull(message = "Enrollment Date is required")
        LocalDate enrollmentDate,
        @NotNull(message = "Retirement Date is required")
        LocalDate retirementDate,
        Double monthlyContribution
) {
}
