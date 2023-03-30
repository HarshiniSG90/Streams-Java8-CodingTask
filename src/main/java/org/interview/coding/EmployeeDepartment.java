package org.interview.coding;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class EmployeeDepartment {
    public static void main(String args[])
    {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"Harshini",9000,"dev"),
                new Employee(1,"Kishore",8000,"QA"),
                new Employee(1,"Manjula",19000,"dev"),
                new Employee(1,"Reshma",9900,"dev"),
                new Employee(1,"Suresh",5000,"QA"),
                new Employee(1,"Harika",2000,"HR")
        );
        Comparator<Employee> compareBySalary = Comparator.comparing(Employee::getSalary);
        Map<String, Optional<Employee>> collect = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept
                        , Collectors.reducing(BinaryOperator.maxBy(compareBySalary))));
       // System.out.println(collect);

        //2nd approach

        Map<String, Employee> collect1 = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(
                                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                                , Optional::get)));

        fetchMaxSalaryInEachDepartment();
    }

    private static void fetchMaxSalaryInEachDepartment() {
        List<Employee> employeeList = Arrays.asList(
                new Employee(1,"Harshini",9000,new Department("Dev",1)),
                new Employee(1,"Kishore",8000,new Department("QA",2)),
                new Employee(1,"Manjula",19000,new Department("Dev",1)),
                new Employee(1,"Reshma",9900,new Department("Dev",1)),
                new Employee(1,"Suresh",5000,new Department("QA",2)),
                new Employee(1,"Harika",2000,new Department("HR",3))
        );

        Map<Department, Employee> highestSalaryByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Employee::getSalary)),
                                Optional::get)));
        System.out.println(highestSalaryByDept);

    }
}
