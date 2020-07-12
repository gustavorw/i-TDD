package positions;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {
    Employee employee;

    @Before
    public void init(){
        employee = new Employee("Gustavo");
    }

    @Test
    public void testAddTwoGratuities(){
        employee.addOvertimeBonus(10);
        employee.addPerformanceBonus();
        assertEquals(2, employee.amountOfGratuities());
    }

    @Test
    public void testAnOvertimeGratification(){
        employee.addOvertimeBonus(10);
        double valor = employee.calculateTotalGratificationsAmount();
        assertTrue(25.0 == valor);
    }

    @Test
    public void testRemoveGratification(){
        employee.addOvertimeBonus(10);
        employee.addPerformanceBonus();
        employee.addPerformanceBonus();
        boolean status = employee.removeGratification(2);
        assertTrue(status);
    }

    @Test
    public void testRemoveGratificationError(){
        employee.addOvertimeBonus(10);
        employee.addPerformanceBonus();
        employee.addPerformanceBonus();
        boolean status = employee.removeGratification(10);
        assertFalse(status);
    }


}