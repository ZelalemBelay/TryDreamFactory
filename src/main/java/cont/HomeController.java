package cont;

import entity.TestEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
    public String sendPost(TestEntity testEntity, Model model)
    {

        testService.insertTestEntity(testEntity);

        model.addAttribute("data", "data");
        model.addAttribute("testEntities",  testService.getTests());

        return "test";
    }

    @RequestMapping(value = "/delete/{id}")
    public String deleteTest(@PathVariable("id") int id, Model model)
    {

        testService.deleteEntityWithId(id);

        model.addAttribute("data", "data");
        model.addAttribute("testEntities",  testService.getTests());

        return "redirect:/";
    }

    @RequestMapping(value = "/update/{id}")
    public String updateTest(@PathVariable("id") int id, @RequestParam("newValenc") String newVal, Model model)
    {
        System.out.println(id+"--"+newVal);

        testService.updateEntityWithId(id, newVal);

        model.addAttribute("data", "data");
        model.addAttribute("testEntities",  testService.getTests());

        return "redirect:/";
    }

}
