package positions;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ManagerTest {
    Manager manager;

    @Before
    public void init(){
        manager = new Manager("Gustavo");
    }


    @Test
    public void testSalary(){
        double salary = manager.getSalary();
        assertTrue(4000.0 == salary);
    }

    @Test
    public void testCalculateOvertimeGratification(){
        manager.addOvertimeBonus(10);
        double value = manager.calculateTotalGratificationsAmount();
        assertTrue(value == 40.0);
    }

    @Test
    public void testCalculatePerformanceBonus(){

        manager.addPerformanceBonus();
        double valor = manager.calculateTotalGratificationsAmount();
        assertTrue(valor == 200.0);
    }

    @Test
    public void testCalculateWithTwoDifferentGratuities(){

        manager.addPerformanceBonus();
        manager.addOvertimeBonus(10);
        double valor = manager.calculateTotalGratificationsAmount();

        assertTrue(valor == 240.0);
    }

    @Test
    public void testCalculateGratificationWithoutGratification(){
        double valor = manager.calculateTotalGratificationsAmount();
        assertTrue(valor == 0.0);
    }


    @Test
    public void testRemoveGratification(){
        manager.addOvertimeBonus(10);
        manager.addPerformanceBonus();
        manager.addPerformanceBonus();
        boolean status = manager.removeGratification(2);
        assertTrue(status);
    }

    @Test
    public void testRemoveGratificationError(){
        manager.addOvertimeBonus(10);
        manager.addPerformanceBonus();
        manager.addPerformanceBonus();
        boolean status = manager.removeGratification(10);
        assertFalse(status);
    }

}