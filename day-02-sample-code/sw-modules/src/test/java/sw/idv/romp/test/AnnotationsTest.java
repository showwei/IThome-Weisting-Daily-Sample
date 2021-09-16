package sw.idv.romp.test;

import org.junit.Before;
import org.junit.Test;
import sw.idv.romp.Main;
import sw.idv.romp.handler.ApplicationBoot;
import sw.idv.romp.proxy.ObjectCloneHandler;
import sw.idv.romp.services.AnimalService;
import sw.idv.romp.services.AnimalServiceImpl;
import sw.idv.romp.services.MakePizzaService;
import sw.idv.romp.services.MakePizzaServiceImpl;

import static org.junit.Assert.assertEquals;

public class AnnotationsTest {
    private static final double DELTA = 1e-15;

    MakePizzaService makePizzaService;

    AnimalService animalService;
    @Before
    public void init() {
        ApplicationBoot.getInstance().run(Main.class);
        makePizzaService = (MakePizzaService) ObjectCloneHandler.getInstance().bind(new MakePizzaServiceImpl());
        animalService = (AnimalService) ObjectCloneHandler.getInstance().bind(new AnimalServiceImpl());
    }

    @Test
    public void testMakeDough() {
        animalService.dogBark();
        assertEquals(makePizzaService.makeDough(),"Cheese + pineapple + pizza dough");
        System.out.println("Make Dough test pass ! ");
    }

    @Test
    public void testMakeMeals() {
        assertEquals(makePizzaService.makeMeals(),"fork + carrot");
        System.out.println("Make Meal test pass ! ");
    }

    @Test
    public void testMakeCondiment() {
        assertEquals(makePizzaService.makeCondiment(),"pepper ! ");
        System.out.println("Make Condiment test pass ! ");
    }

    @Test
    public void testSellPizza() {
        assertEquals(makePizzaService.sellPizza(1), 170.0D,DELTA);
        System.out.println("Sell Pizza price test pass ! ");
    }

    @Test
    public void testShowMyCompany() {
        assertEquals(makePizzaService.showMyCompany(),"YO ! This is WEISTING COMPANY, We have 15.5 pizzas.");
        System.out.println("show my company test pass ! ");
    }
}
