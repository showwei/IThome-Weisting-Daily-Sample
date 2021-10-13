package sw.spring.sample.controller;

import com.google.gson.Gson;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import sw.spring.sample.ApplicationBoot;

@Ignore
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ApplicationBoot.class)
@ActiveProfiles({"stag","native"})
public class ControllerTestBase extends TestCase {

    protected MockMvc mvc;

    @Autowired
    private WebApplicationContext webApplicationContext;

    public ControllerTestBase() {}

    Logger logger = LoggerFactory.getLogger(ControllerTestBase.class);

    @Before
    public void init() {
        logger.info(this.getClass().getName());
        logger.info("------- init test mock API WebApplicationContext -------");
        this.mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        logger.info("------- init finished test mock API WebApplicationContext --------");
        logger.info("***** API Mock Start *****");


    }

    public String convertJsonRequestBody(Object requestEntity) {
        return new Gson().toJson(requestEntity);
    }

    @After
    public void finish() {
        logger.info("***** API Mock End *****");


    }
}
