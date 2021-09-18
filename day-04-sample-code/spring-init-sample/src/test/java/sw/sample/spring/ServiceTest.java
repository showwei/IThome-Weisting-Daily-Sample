package sw.sample.spring;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
@ActiveProfiles({"dev", "native"})
public class ServiceTest extends TestCase {

    @Test
    public void sampleTest() {
        assertEquals(1,1);
        System.out.println("Sample test pass!");
    }
}
