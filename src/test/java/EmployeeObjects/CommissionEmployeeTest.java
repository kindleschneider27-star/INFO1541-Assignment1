package EmployeeObjects;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CommissionEmployeeTest {
    CommissionEmployee emp = new CommissionEmployee("Clint", "Barton", 6847, "Sales", "Customer Representative", .0265);

    @Test
    void testIncreaseSalesPositive() {
        emp.increaseSales(10);
        emp.increaseSales(-5);
        assertEquals(10, emp.getSales());
    }

    @Test
    void testHolidayBonus() {
        assertEquals(0, emp.holidayBonus());

    }

    @Test
    void testAnnualRaise() {
        emp.annualRaise();
        emp.annualRaise();
        assertEquals(.0305, emp.getRate());
    }

}