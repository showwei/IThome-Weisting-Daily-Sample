package sw.spring.sample;

import junit.framework.TestCase;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
@ActiveProfiles({"dev", "native"})
public class ServiceTestBase extends TestCase {

}
