package org.interview;

import java.util.*;
import java.util.stream.Collectors;

public class ObjectStreamExercise {

    public static void main(String args[])
    {
        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee(1,"harshini",1900,new City("kakow",1234)));
        list.add(new Employee(2,"Kishore",2300,new City("gadansk",1235)));
        list.add(new Employee(3,"Manjula",2000,new City("kakow",1234)));
        list.add(new Employee(4,"Reshma",100,new City("kakow",1234)));
        list.add(new Employee(5,"Swetha",90000,new City("bang",1122)));
        list.add(new Employee(6,"Swetha",90000,new City("bang",1122)));

        groupByEmployee(list);
        sortEmployee(list);
        FInterface functionalInterface = (a,b)->a*b;
         //System.out.println(functionalInterface.multiply(6,2));
    }

    public static void sortEmployee(List<Employee> list)
    {
        //String sorting
        List<Employee> nameList =  list.stream().sorted((x1,y)->{return x1.getName().toLowerCase().compareTo(y.getName().toLowerCase());}).collect(Collectors.toList());
        //Integer sorting
        List<Employee> salList = list.stream().sorted((x1,y)->(int)(y.salary-x1.salary)).skip(3).collect(Collectors.toList());
        salList.forEach(System.out::println);
    }

    public static void groupByEmployee(List<Employee> list)
    {
        Map<Object,List<Employee>> map =  list.stream().collect(Collectors.groupingBy(emp->emp.getCity().zipcode,TreeMap::new,Collectors.toList()));
        map.entrySet().stream().forEach(x->{System.out.println(x.getKey()+" =="+ x.getValue());});

    }
}
