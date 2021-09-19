package sw.sample.spring;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableMBeanExport;
import sw.sample.spring.config.AppConfig;
import sw.sample.spring.service.ConfigService;
import sw.sample.spring.service.ConfigServiceImpl;

import java.util.Map;

@SpringBootApplication
@EnableMBeanExport
public class ApplicationBoot {



    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class,args);
    }
}
