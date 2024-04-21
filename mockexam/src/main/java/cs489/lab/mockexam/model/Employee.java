package cs489.lab.mockexam.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long employeeId;
    @NotBlank(message = "First Name is required.")
    private String firstName;
    @NotBlank(message = "Last name is required")
    private String lastName;
    private Double yearlySalary;

    @OneToOne
    @JoinColumn(name = "retirement_plan_id")
    private RetirementPlan retirementPlan;
}
