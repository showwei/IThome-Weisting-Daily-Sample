package sw.spring.conditional;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import sw.spring.conditional.model.Animal;
import sw.spring.conditional.model.Dog;

@Ignore
public class MissingBeanServiceSuite extends ServiceTestBase {

    @Qualifier("malzis")
    @Autowired
    Dog dog;

    @Test
    public void validateConditionalOnMissingBean() {
        assertEquals(dog.getName(),"malzis");
        System.out.println("Validate conditional on missing bean success ! ");

    }


}
