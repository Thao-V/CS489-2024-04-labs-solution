package cs489.lab.mockexam.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public record RetirementPlanResponse(
        Long planId,
        String referenceNumber,
        LocalDate enrollmentDate,
        LocalDate retirementDate,
        Double monthlyContribution
) {
}
