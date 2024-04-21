package cs489.lab.mockexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.dialect.function.NvlCoalesceEmulation;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "retirement_plans")
public class RetirementPlan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long planId;
    @NotBlank(message = "Reference Number is required")
    private String referenceNumber;
    @NotNull (message = "Enrollment Date is required")
    private LocalDate enrollmentDate;
    @NotNull(message = "Retirement Date is required")
    private LocalDate retirementDate;
    private Double monthlyContribution;
    @OneToOne(mappedBy = "retirementPlan")
    private Employee employee;

    public Boolean isEligibleToRetireNextMonth(){
        LocalDate now = LocalDate.now();
        LocalDate startDateOfNextMonth = now.plusMonths(1).withDayOfMonth(1);
        LocalDate endDateOfNextMonth = startDateOfNextMonth.plusMonths(1).minusDays(1);
        return !retirementDate.isBefore(startDateOfNextMonth) && !retirementDate.isAfter(endDateOfNextMonth);
    }
}
