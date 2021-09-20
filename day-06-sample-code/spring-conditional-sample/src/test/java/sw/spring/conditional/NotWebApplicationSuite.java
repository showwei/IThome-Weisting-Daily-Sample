package sw.spring.conditional;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sw.spring.conditional.model.Dog;

import static org.junit.Assert.assertEquals;


@Ignore
public class NotWebApplicationSuite {

    @Qualifier("ghost")
    @Autowired
    Dog ghost;


    @Test
    public void validateConditionalOnNotWebApplication() {
        assertEquals(ghost.getName(),"ghost");
        System.out.println(" | >> Validate Conditional On Not WebApplication Success! ");

    }
}
