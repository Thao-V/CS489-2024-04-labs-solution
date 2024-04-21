package cs489.lab.mockexam.service;

import cs489.lab.mockexam.dto.EmployeeRequest;
import cs489.lab.mockexam.dto.EmployeeResponse;
import cs489.lab.mockexam.dto.RetirementPlanResponse;
import cs489.lab.mockexam.model.Employee;
import cs489.lab.mockexam.model.RetirementPlan;
import cs489.lab.mockexam.repository.EmployeeRepository;
import cs489.lab.mockexam.repository.RetirementPlanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private RetirementPlanRepository retirementPlanRepository;

    public List<EmployeeResponse> getAllEmployees(){
        List<EmployeeResponse> response = employeeRepository.findAll().stream()
                .map( employee -> new EmployeeResponse(
                        employee.getEmployeeId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getYearlySalary(),
                        employee.getRetirementPlan() == null? null: new RetirementPlanResponse(
                                employee.getRetirementPlan().getPlanId(),
                                employee.getRetirementPlan().getReferenceNumber(),
                                employee.getRetirementPlan().getEnrollmentDate(),
                                employee.getRetirementPlan().getRetirementDate(),
                                employee.getRetirementPlan().getMonthlyContribution()
                        )
                        )
                )
                .sorted(Comparator.comparing(EmployeeResponse::lastName))
                .toList();
        //Collections.sort(response, Comparator.comparing(EmployeeResponse::lastName));
        return response;
    }
    public RetirementPlanResponse getRetirementPlanByEmployeeId(Long employeeId){
        return employeeRepository.findById(employeeId)
                .map(e -> e.getRetirementPlan() == null ? null: new RetirementPlanResponse(
                        e.getRetirementPlan().getPlanId(),
                        e.getRetirementPlan().getReferenceNumber(),
                        e.getRetirementPlan().getEnrollmentDate(),
                        e.getRetirementPlan().getRetirementDate(),
                        e.getRetirementPlan().getMonthlyContribution()
                )).orElse(null);
    }
    public List<EmployeeResponse> getEligibleRetireesNextMonth(){
        List<Employee> employeeList = employeeRepository.findAll();
        List<EmployeeResponse> response = new ArrayList<>();
        for(Employee employee: employeeList){
            if(employee.getRetirementPlan() != null && employee.getRetirementPlan().isEligibleToRetireNextMonth()) {
                response.add(new EmployeeResponse(
                        employee.getEmployeeId(),
                        employee.getFirstName(),
                        employee.getLastName(),
                        employee.getYearlySalary(),
                        new RetirementPlanResponse(
                                employee.getRetirementPlan().getPlanId(),
                                employee.getRetirementPlan().getReferenceNumber(),
                                employee.getRetirementPlan().getEnrollmentDate(),
                                employee.getRetirementPlan().getRetirementDate(),
                                employee.getRetirementPlan().getMonthlyContribution()
                        )
                ));
            }
        }
        response.sort(Comparator.comparing(e -> e.retirementPlanResponse().retirementDate()));
        return response;
    }
    public EmployeeResponse addRetirementPlan(EmployeeRequest employeeRequest){
        var retirementPlan = new RetirementPlan();
        retirementPlan.setReferenceNumber(employeeRequest.referenceNumber());
        retirementPlan.setEnrollmentDate(employeeRequest.enrollmentDate());
        retirementPlan.setRetirementDate(employeeRequest.retirementDate());
        retirementPlan.setMonthlyContribution(employeeRequest.monthlyContribution());
        var savedRetirementPlan = retirementPlanRepository.save(retirementPlan);

        var employee = new Employee();
        employee.setFirstName(employeeRequest.firstName());
        employee.setLastName(employeeRequest.lastName());
        employee.setYearlySalary(employeeRequest.yearlySalary());
        employee.setRetirementPlan(savedRetirementPlan);
        var savedEmployee = employeeRepository.save(employee);
        return new EmployeeResponse(
                savedEmployee.getEmployeeId(),
                savedEmployee.getFirstName(),
                savedEmployee.getLastName(),
                savedEmployee.getYearlySalary(),
                new RetirementPlanResponse(
                        savedEmployee.getRetirementPlan().getPlanId(),
                        savedEmployee.getRetirementPlan().getReferenceNumber(),
                        savedEmployee.getRetirementPlan().getEnrollmentDate(),
                        savedEmployee.getRetirementPlan().getRetirementDate(),
                        savedEmployee.getRetirementPlan().getMonthlyContribution()
                )
        );
    }
}
