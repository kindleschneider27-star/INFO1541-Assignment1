/*
 * Author: Kindle Schneider
 * Date: September 12, 2026
 * Class: INFO 1541 WA
 * Assignment: 1 - Employee Unit Tests & Annotations
 *
 * AI Assistance: Portions of this work received assistance from Claude,
 * an AI assistant by Anthropic (https://claude.ai), including debugging
 * help, explanations of JUnit and reflection concepts, and code review.
 * All code was written and verified by the author.
 */

package EmployeeObjects;

import EmployeeBlueprints.Employee;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestingAnnotations {

    public static void main (String[] args) throws IllegalAccessException, InvocationTargetException {
        HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749, "Service", "Lead Service Manager", 32.85);
        SalaryEmployee emp2 = new SalaryEmployee("Steve", "Rodgers", 3781, "Sales", "Manager", 64325);
        CommissionEmployee emp3 = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

        int numberEmployeeTypes = 0;
        if (emp.getClass().isAnnotationPresent(EmployeeType.class)) {
            ++numberEmployeeTypes;

        }
        if (emp2.getClass().isAnnotationPresent(EmployeeType.class)) {
            ++numberEmployeeTypes;

        }
        if (emp3.getClass().isAnnotationPresent(EmployeeType.class)) {
            ++numberEmployeeTypes;

        }
        System.out.println("You have " + numberEmployeeTypes + " employee types");

        Employee[] employees = {emp, emp2, emp3};
        for (Employee em : employees) {
        Field[] fields =em.getClass().getDeclaredFields();
        for (Field f : fields) {
            if(f.isAnnotationPresent(PayRate.class)) {
                f.setAccessible(true);
                double rate = (double) f.get(em);
                System.out.println(em.getFirstName() + " " + em.getLastName() + "\nEmployee pay rate: $" + rate);
            }
        }
        Method[] methods = em.getClass().getDeclaredMethods();
        for (Method m : methods) {
            if(m.isAnnotationPresent(WeeklyPayCalculator.class)) {
                double pay = (double) m.invoke(em);
                System.out.println("Weekly pay: $" + pay);
            }
        }
        }



    }
}