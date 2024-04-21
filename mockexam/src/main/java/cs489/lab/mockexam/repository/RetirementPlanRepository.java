package cs489.lab.mockexam.repository;

import cs489.lab.mockexam.model.RetirementPlan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RetirementPlanRepository extends JpaRepository<RetirementPlan, Long> {
}
