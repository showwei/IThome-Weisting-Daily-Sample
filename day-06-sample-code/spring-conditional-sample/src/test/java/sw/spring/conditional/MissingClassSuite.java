package sw.spring.conditional;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sw.spring.conditional.model.Dog;

import static org.junit.Assert.assertEquals;


@Ignore
public class MissingClassSuite extends ServiceTestBase {

    @Qualifier("lucky")
    @Autowired
    Dog dog;

    @Test
    public void validateConditionalOnMissingClass() {
        assertEquals(dog.getName(),"lucky");
        System.out.println("Validate conditional on missing class success ! ");

    }
}
