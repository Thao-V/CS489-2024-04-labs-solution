package edu.miu.cs489.lab1b;
import java.util.Arrays;

import edu.miu.cs489.lab1b.model.Employee;
import edu.miu.cs489.lab1b.model.PensionPlan;

import java.time.LocalDate;
import java.util.Comparator;

public class Main {
    public static void main(String [] args){
        System.out.println("hello");
        Employee e1 = new Employee(1000L, "Thao", "Vu", LocalDate.of(2018, 3, 20), 3000000.00, new PensionPlan("XY1001", LocalDate.of(2024, 3, 20), 1000.00));
        Employee e2 = new Employee(1001L, "Muhammad", "Arif", LocalDate.of(2024, 5, 20), 1000000.00, null);
        Employee e3 = new Employee(999L, "Daniel", "Agar", LocalDate.of(2019, 5, 1), 900000.00, null);
        Employee [] employees = {e1, e2, e3};
        //Print out all employees, sorting
        Arrays.sort(employees, Comparator.comparing(Employee::getLastName).thenComparing(Employee::getYearlySalary, Comparator.reverseOrder()));
        for(Employee e: employees){
            System.out.println(e);
        }
        //print out upcoming enrollees
        System.out.println("List of eligible employees for enrolling the pension plan.");
        for(Employee e: employees){
            if(e.isEligibleForPensionPlan()) {
                System.out.println(e);
            }
        }
    }
}
