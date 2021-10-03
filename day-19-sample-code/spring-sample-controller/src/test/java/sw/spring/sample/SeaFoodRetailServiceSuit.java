package sw.spring.sample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sw.spring.sample.services.SeaFoodRetailerService;

import static org.junit.Assert.assertEquals;

public class SeaFoodRetailServiceSuit extends ServiceTestBase{
    @Autowired
    SeaFoodRetailerService seaFoodRetailService;

    @Test
    public void listProducts() {
        assertEquals(seaFoodRetailService.listSeaFoodProducts().size(),3);
        System.out.println("Verify Products size success.");
    }
}
