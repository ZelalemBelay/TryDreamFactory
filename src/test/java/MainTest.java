import entity.TestEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import service.TestService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zelalem Belay on 2/3/2017.
 */

public class MainTest {

    @Mock
    @Autowired
    TestService testService;

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        assertEquals("testequal","testequal");
    }

    @Before
    public void setup()
    {
        testService = new TestService();
    }

//    @Test
//    public void createEquipmentType() throws Exception {
//        TestEntity testEntity = new TestEntity("demoEntity");
//        String  testResult = testService.insertTestEntity(testEntity);
//        assertEquals(testEntity.getName(), testResult);
//    }

}
