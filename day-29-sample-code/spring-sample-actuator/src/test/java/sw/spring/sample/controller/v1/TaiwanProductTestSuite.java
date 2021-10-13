package sw.spring.sample.controller.v1;

import com.google.gson.Gson;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;
import org.junit.jupiter.api.Order;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import sw.spring.sample.controller.ControllerTestBase;
import sw.spring.sample.models.SeaFood;

import java.util.List;

public class TaiwanProductTestSuite extends ControllerTestBase {
    public TaiwanProductTestSuite() {}

    @Test
    @Order(1)
    public void listSeaFoodTask()  throws Exception{
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get("/v1/taiwan/list")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(200,status);
        String responseText = mvcResult.getResponse().getContentAsString();
        System.out.println("Response result : " + responseText);
        List<SeaFood> seaFoods = new Gson().fromJson(responseText,List.class);
        assertEquals(seaFoods.size(),3);
        System.out.println("[ TEST CASE ] - Verify [GET - TAIWAN] list sea food products SUCCESS.....!");
    }

    @Test
    @Order(2)
    public void findSeaFoodByIdTask()  throws Exception{
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.get("/v1/taiwan/find/{id}","C-0001")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(200,status);
        String responseText = mvcResult.getResponse().getContentAsString();
        System.out.println("Response result : " + responseText);
        SeaFood seaFood = new Gson().fromJson(responseText,SeaFood.class);
        assertEquals(seaFood.getName(),"King Crab");
        System.out.println("[ TEST CASE ] - Verify [GET - TAIWAN] sea food by C-0002 SUCCESS .....!");
    }

    @Test
    @Order(3)
    public void createSeaFoodTask() throws Exception {
        SeaFood seaFood = new SeaFood()
                .setId("F-0999")
                .setName("WEI WEI Crab")
                .setDescription("Opilio is the primary species referred to as china WEI WEI crab.")
                .setPrice(555);
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.post("/v1/taiwan/create")
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
        assertEquals(responseBody.getName(),"WEI WEI Crab");
        assertEquals(responseBody.getId(),"F-0999");
        assertEquals(responseBody.getDescription(),"Opilio is the primary species referred to as china WEI WEI crab.");
        assertEquals(responseBody.getPrice(),555);
        System.out.println("[ TEST CASE ] - Verify [CREATE - TAIWAN] sea food SUCCESS .....!");
    }

    @Test
    @Order(4)
    public void updateSeaFoodTask() throws Exception {
        SeaFood seaFood = new SeaFood()
                .setId("C-0002")
                .setName("Snow Crab")
                .setDescription("Opilio is the primary species referred to as snow crab.")
                .setPrice((int)(350*0.8));
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.put("/v1/taiwan/update")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(convertJsonRequestBody(seaFood))
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(200,status);
        String responseText = mvcResult.getResponse().getContentAsString();
        System.out.println("Response result : " + responseText);
        SeaFood responseBody = new Gson().fromJson(responseText,SeaFood.class);
        assertEquals(responseBody.getName(),"Snow Crab");
        assertEquals(responseBody.getId(),"C-0002");
        assertEquals(responseBody.getDescription(),"Opilio is the primary species referred to as snow crab.");
        assertEquals(responseBody.getPrice(),280);
        System.out.println("[ TEST CASE ] - Verify [UPDATE - TAIWAN] sea food SUCCESS .....!");
    }

    @Test
    @Order(5)
    public void deleteSeaFoodTask() throws Exception {
        MvcResult mvcResult = this.mvc.perform(MockMvcRequestBuilders.delete("/v1/taiwan/remove/{id}","F-0001")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        System.out.println("Http status code : " + status);
        assertEquals(200,status);
        Boolean isDelete = Boolean.valueOf(mvcResult.getResponse().getContentAsString());
        System.out.println("Response result : " + isDelete);
        assertTrue(isDelete);
        System.out.println("[ TEST CASE ] - Verify [DELETE - TAIWAN] sea food SUCCESS .....!");
    }
}
