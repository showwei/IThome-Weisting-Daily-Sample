package sw.spring.sample.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;

@Configuration
public class SeaFooConfig {

    @Autowired
    Environment env;

    Logger logger = LoggerFactory.getLogger(SeaFooConfig.class);

    @PostConstruct
    public void init() {
        logger.info("*******************************************************");
        logger.info("*** Sync boot profile : [{}] ***",env.getProperty("sea.food.system.environment"));
        logger.info("*******************************************************");
    }
}
