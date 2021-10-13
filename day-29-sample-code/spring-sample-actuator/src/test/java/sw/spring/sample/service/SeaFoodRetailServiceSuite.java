package sw.spring.sample.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sw.spring.sample.ServiceTestBase;
import sw.spring.sample.services.SeaFoodRetailerService;

import static org.junit.Assert.assertEquals;

public class SeaFoodRetailServiceSuite extends ServiceTestBase {
    @Autowired
    SeaFoodRetailerService seaFoodRetailService;

    @Test
    public void listProducts() {
        assertEquals(seaFoodRetailService.listSeaFoodProducts().size(),3);
        System.out.println("Verify Products size success.");
    }
}
