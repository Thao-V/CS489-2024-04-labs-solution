package cs489.lab.mockexam.repository;

import cs489.lab.mockexam.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
