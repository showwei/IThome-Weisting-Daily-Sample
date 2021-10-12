package sw.spring.sample.controller.v1;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.jupiter.api.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sw.spring.sample.controller.ControllerTestBase;
import sw.spring.sample.models.SeaFood;

import java.sql.Date;
import java.time.Instant;
import java.util.Map;

public class SystemInformationTestSuite extends ControllerTestBase {
    @Test
    public void seaFoodVersionTask()  throws Exception{
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get("/v1/about")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(200,status);
        String responseText = mvcResult.getResponse().getContentAsString();
        System.out.println("Response result : " + responseText);
        Map<String,Object> seaFoodAbout = new Gson().fromJson(responseText,Map.class);
        assertEquals(seaFoodAbout.get("version"),"v1.0.1");
        assertEquals(seaFoodAbout.get("name"),"Weisting SEA Food Retailer");
        assertEquals(seaFoodAbout.get("ceo"),"Darius Weisting");
        assertEquals(String.valueOf(seaFoodAbout.get("capital")),"6000000.0");
        assertEquals(seaFoodAbout.get("address"),"No. 88, Ln. 888, Sec. 5, Minzu Rd., Yangmei Dist., Taoyuan City 326002 , Taiwan (R.O.C.)");
        assertEquals(seaFoodAbout.get("uniformNumber"),"86633399");
        System.out.println("[ TEST CASE ] - Verify [GET - SEAFOOD Version] sea food SUCCESS .....!");
    }

}
