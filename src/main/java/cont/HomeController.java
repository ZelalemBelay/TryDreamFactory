package cont;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import service.TestService;

/**
 * Created by Zelalem Belay on 1/26/2017.
 */
@Controller
public class HomeController
{
    @Autowired
    TestService testService;

    @RequestMapping(value={"/", "/test"})
    public String testGet(Model model)
    {
        model.addAttribute("data", "Data");
        model.addAttribute("testEntities", testService.getTests());

        return "test";
    }


    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String sendPost(Model model)
    {
        model.addAttribute("data", "data");
        model.addAttribute("testEntities",  testService.getTests());
        return "test";
    }

}
