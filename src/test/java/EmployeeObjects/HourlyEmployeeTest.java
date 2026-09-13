package EmployeeObjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class HourlyEmployeeTest {
    HourlyEmployee emp = new HourlyEmployee("Tony", "Stark", 5749,
            "Service", "Lead Service Manager", 32.85);

    @Test
    void testIncreaseHoursPositive(){
        emp.increaseHours(20);
        emp.increaseHours(-20);
        emp.increaseHours(5.5);
        assertEquals(25.5, emp.getHoursWorked(), 0.001);
    }

    @Test
    void testAnnualRaise(){
        emp.annualRaise();
        assertEquals(34.49, emp.getWage());
    }

    @Test
    void testCalculateWeeklyPayNoOvertime(){
        emp.increaseHours(35);
        assertEquals(1149.75, emp.calculateWeeklyPay(), 0.001);
    }

    @Test
    void testCalculateWeeklyPayOvertime(){
        emp.increaseHours(45);
        assertEquals(1560.38, emp.calculateWeeklyPay());
    }

}