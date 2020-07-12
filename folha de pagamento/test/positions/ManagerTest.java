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
        double salario = manager.getSalary();
        assertTrue(4000.0 == salario);
    }

    @Test
    public void testCalculateOvertimeGratification(){
        manager.addOvertimeBonus(10);
        double valor = manager.calculateTotalGratificationsAmount();
        assertTrue(valor == 40.0);
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


}