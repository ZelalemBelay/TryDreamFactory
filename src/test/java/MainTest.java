import entity.TestEntity;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import service.TestService;

import static org.junit.Assert.assertEquals;

/**
 * Created by Zelalem Belay on 2/3/2017.
 */

public class MainTest {

    @Autowired
    TestService testService;

    @Test
    public void testPrintMessage() {
        System.out.println("Inside testPrintMessage()");
        assertEquals("testequal","testequal");
    }

    @Test
    public void createEquipmentType() throws Exception {
        TestEntity testEntity = new TestEntity("demoEntity");
        String  testResult = testService.insertTest(testEntity);
        assertEquals(testEntity.getName(), testResult);
    }

}
