import org.junit.Before;
import org.junit.Test;
import positions.Employee;
import positions.Manager;
import positions.Worker;

import static org.junit.Assert.*;

public class MemoryTest {
    Memory memory;

    @Before
    public void init(){
        memory = new Memory();
    }

    @Test
    public void testAddWorkerManager(){
        memory.addManager(new Manager("Gustavo"));
        assertEquals(1, memory.sizedWorkers());
    }

    @Test
    public void testAddWorkerEmployee(){
        memory.addEmployee(new Employee("Gabriel"));
        assertEquals(1, memory.sizedWorkers());
    }

    @Test
    public void testSearchWorker(){
        memory.addEmployee(new Employee("Gustavo"));
        memory.addEmployee(new Employee("Gabriel"));
        memory.addManager(new Manager("Eduarda"));
        Worker worker = memory.searchWorker("Gabriel");
        assertTrue(null != worker);
    }

    @Test
    public void testNotFoundWorker(){
        memory.addEmployee(new Employee("Gustavo"));
        memory.addEmployee(new Employee("Gabriel"));
        memory.addManager(new Manager("Eduarda"));
        Worker worker = memory.searchWorker("helena");
        assertTrue(null == worker);

    }

    @Test
    public void testDeleteWorker(){
        memory.addEmployee(new Employee("Gustavo"));
        memory.addEmployee(new Employee("Gabriel"));
        memory.addManager(new Manager("Eduarda"));

        boolean status = memory.deleteWorker("eduarda");

        assertTrue(status);
    }

    @Test
    public void testDeleteNotFoundWorker(){
        memory.addEmployee(new Employee("Gustavo"));
        memory.addEmployee(new Employee("Gabriel"));
        memory.addManager(new Manager("Eduarda"));
        boolean status = memory.deleteWorker("helena");
        assertFalse(status);
    }


}