package sw.spring.component;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class ComponentTestSuite extends ServiceTestBase {

    @Qualifier("Chapter-1")
    @Autowired
    ActorService actorService;


    @Autowired
    ActorService actorService2;

    @Qualifier("ComponentChapter1")
    @Autowired
    ActorService actorService1;

    @Test
    public void validateBaseLogical() {
        assertEquals(-1,-1);
        System.out.println("Base Logical test success ! ");
    }

    @Test
    public void validateChapter1() {
        assertEquals(actorService.getJohnWickMainActor().getName(),"John Wick2222");
        System.out.println("Validate ActorServiceImpl Chapter 1 from Bean success ! ");
    }

    @Test
    public void validateHotelCEOByChapter1() {
        assertEquals(actorService1.getJohnWickHotelCEOActor().getName(),"Winston");
        System.out.println("Validate ActorServiceImpl Chapter 1 from Component success ! ");
    }

    @Test
    public void validateChapter2() {
        assertEquals(actorService2.getJohnWickMainActor().getName(),"John Weisting");
        System.out.println("Validate ActorServiceImpl Chapter 2 from Component success !");
    }
}
