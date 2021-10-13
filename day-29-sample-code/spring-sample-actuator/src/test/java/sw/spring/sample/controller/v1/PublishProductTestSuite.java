package sw.spring.sample.controller.v1;

import com.google.gson.Gson;
import io.netty.util.internal.ObjectUtil;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.util.ObjectUtils;
import sw.spring.sample.controller.ControllerTestBase;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.Map;

public class PublishProductTestSuite extends ControllerTestBase {
    public PublishProductTestSuite() {};

    @Test
    public void createSeaFoodIntoAllAreaTask() throws Exception {
        SeaFood seaFood = new SeaFood()
                .setId("F-0999")
                .setName("WEI DE Crab")
                .setDescription("Opilio is the primary species referred to as china WEI DE crab.")
                .setPrice(555);
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post("/v1/all/create")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(convertJsonRequestBody(seaFood))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(201,status);
        String responseText = mvcResult.getResponse().getContentAsString();
        System.out.println("Response result : " + responseText);
        SeaFood responseBody = new Gson().fromJson(responseText,SeaFood.class);
        assertEquals(responseBody.getName(),"WEI DE Crab");
        assertEquals(responseBody.getId(),"F-0999");
        assertEquals(responseBody.getDescription(),"Opilio is the primary species referred to as china WEI DE crab.");
        assertEquals(responseBody.getPrice(),555);
        System.out.println("[ TEST CASE ] - Verify [CREATE - Asia Area] sea food SUCCESS .....!");
    }

    @Test
    public void orderBookSeaFoodTask() throws Exception {
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get("/v1/orderbook/all")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(200,status);
        String responseText = mvcResult.getResponse().getContentAsString();
        System.out.println("Response result : " + responseText);
        Map<String, List<SeaFood>> seaFoodOrderBook = new Gson().fromJson(responseText,Map.class);
        assertEquals(seaFoodOrderBook.size(),2);
        assertFalse(ObjectUtils.isEmpty(seaFoodOrderBook.get("TW") ));
        assertFalse(ObjectUtils.isEmpty(seaFoodOrderBook.get("CN") ));
        assertEquals(((List<SeaFood>)seaFoodOrderBook.get("TW")).size(),3);
        assertEquals(((List<SeaFood>)seaFoodOrderBook.get("CN")).size(),3);
        System.out.println("[ TEST CASE ] - Verify [GET - ORDERBOOK] list sea food products SUCCESS.....!");
    }
}
