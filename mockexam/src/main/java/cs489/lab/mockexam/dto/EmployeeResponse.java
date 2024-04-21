package cs489.lab.mockexam.dto;

import cs489.lab.mockexam.model.RetirementPlan;
import jakarta.validation.constraints.NotBlank;

public record EmployeeResponse(
        Long employeeId,
        String firstName,
        String lastName,
        Double yearlySalary,
        RetirementPlanResponse retirementPlanResponse
) {
}
