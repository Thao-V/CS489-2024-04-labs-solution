package cs489.lab.mockexam.controller;

import cs489.lab.mockexam.dto.EmployeeRequest;
import cs489.lab.mockexam.dto.EmployeeResponse;
import cs489.lab.mockexam.dto.RetirementPlanResponse;
import cs489.lab.mockexam.repository.EmployeeRepository;
import cs489.lab.mockexam.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("")
    public ResponseEntity<List<EmployeeResponse>> getAllEmployees(){
        List<EmployeeResponse> employeeResponses = employeeService.getAllEmployees();
        return ResponseEntity.ok(employeeResponses);
    }
    @GetMapping("/{employeeId}/retirement-plan")
    public ResponseEntity<RetirementPlanResponse> getRequirementPlanByEmployeeId(@PathVariable Long employeeId){
        return new ResponseEntity<>(employeeService.getRetirementPlanByEmployeeId(employeeId), HttpStatus.OK);
    }
    @GetMapping("/get-all-retirees")
    public  ResponseEntity<List<EmployeeResponse>> getAllRetireesNextMonth(){
        return ResponseEntity.ok(employeeService.getEligibleRetireesNextMonth());
    }

    @PostMapping("/add-retirement-plan")
    public ResponseEntity<EmployeeResponse> addRetirementPlan(@RequestBody @Valid EmployeeRequest employeeRequest){
        System.out.println(employeeRequest.toString());
        return ResponseEntity.ok(employeeService.addRetirementPlan(employeeRequest));
    }
}
