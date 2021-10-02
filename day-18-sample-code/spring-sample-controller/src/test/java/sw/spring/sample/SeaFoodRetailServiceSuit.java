package sw.spring.sample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sw.spring.sample.services.SeaFoodRetailService;

import static org.junit.Assert.assertEquals;

public class SeaFoodRetailServiceSuit extends ServiceTestBase{
    @Autowired
    SeaFoodRetailService seaFoodRetailService;

    @Test
    public void listProducts() {
        assertEquals(seaFoodRetailService.listSeaFoodProducts().size(),3);
        System.out.println("Verify Products size success.");
    }
}
