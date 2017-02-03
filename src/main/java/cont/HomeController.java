package cont;

import entity.Test;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Zelalem Belay on 1/26/2017.
 */
@Controller
public class HomeController
{
    @RequestMapping(value={"/", "/test"})
    public String testGet(Model model)
    {
        model.addAttribute("data", "Data");
        model.addAttribute("tests", getTest());

        return "test";
    }



    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public String sendPost(Model model)
    {
        model.addAttribute("data", "data");
        model.addAttribute("tests",  getTest());

        return "test";
    }



    public List<Test> getTest()
    {
        final String uri = "http://localhost/api/v2/mysql/_table/test";

        RestTemplate restTemplate = new RestTemplate();
//        String result = restTemplate.getForObject(uri, String.class);

        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(new MediaType[]{MediaType.APPLICATION_JSON}));
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("X-DreamFactory-Api-Key","36fda24fe5588fa4285ac6c6c2fdfbdb6b6bc9834699774c9bf777f706d05a88");
        headers.set("Authorization","Basic emVsYWxlbS5iZWxheUBhMi1nLmNvbTp6b2xhZ2V0bmV0");
        headers.set("X-DreamFactory-Session-Token","eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJzdWIiOjEsInVzZXJfaWQiOjEsImVtYWlsIjoiWmVsYWxlbS5CZWxheUBhMi1nLmNvbSIsImZvcmV2ZXIiOmZhbHNlLCJpc3MiOiJodHRwOlwvXC9sb2NhbGhvc3RcL2FwaVwvdjJcL3N5c3RlbVwvYWRtaW5cL3Nlc3Npb24iLCJpYXQiOjE0ODU0NzIxODYsImV4cCI6MTQ4NTQ3NTc4NiwibmJmIjoxNDg1NDcyMTg2LCJqdGkiOiJiMmQyZDE3ZThhNDk0NjQ4Mzk5NGE3YWU4OTdlMDA0YSJ9.xNYQ8z1u4Pk34M7XL0nmsIQo_61ssM1ihdbeNf5wWDM");

        HttpEntity<String> entity = new HttpEntity<>("parameters", headers);

        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);

        System.out.println(result.getBody());
        JSONObject jsonObject = new JSONObject(result.getBody());
        JSONArray ja = new JSONArray(jsonObject.get("resource").toString());

        ArrayList<Test> tests = new ArrayList<>();

        for(int i = 0; i < ja.length(); i++)
        {
            JSONObject object3 = ja.getJSONObject(i);

//            String id = object3.getString("id");
            ObjectMapper mapper = new ObjectMapper();
            try {

                mapper.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                Test test = mapper.readValue(object3.toString(), Test.class);
                tests.add(test);
                System.out.println(test.getName());
            }
            catch (JsonGenerationException e) {
                e.printStackTrace();
            } catch (JsonMappingException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        return tests;
    }


}
