import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import positions.EmployeeTest;
import positions.ManagerTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({MemoryTest.class, EmployeeTest.class, ManagerTest.class})
public class SuiteTest {

}
