
import cont.HomeController;
import entity.TestEntity;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import service.TestService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


/**
 * Created by Zelalem Belay on 12/21/2016.
 */


public class DemoTester
{

    @Mock
    @Autowired
    private TestService testService;

    @InjectMocks
    private HomeController homeController;

    private MockMvc mockmvc;

    @Before
    public void setup()
    {
        MockitoAnnotations.initMocks(this);
        mockmvc = MockMvcBuilders.standaloneSetup(homeController).build();
    }


    @Test
    public void testTest() throws Exception {
        List<TestEntity> tests = new ArrayList<>();
        tests.add(new TestEntity());
        tests.add(new TestEntity());
        tests.add(new TestEntity());

        when(testService.getTests()).thenReturn(tests);

        mockmvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("test"))
                .andExpect(model().attribute("testEntities", hasSize(3)));
    }

}

