package sw.project.sample;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
public class ServiceTestBase {

    @Before
    public void beforeTest() {
        System.out.println("========== Before Test ========== \r\n");
    }

    @After
    public void afterTest() {
        System.out.println("\r\n========== Finish Test ========== ");
    }
}
