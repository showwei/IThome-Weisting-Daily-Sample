package sw.spring.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

@EnableMBeanExport
@SpringBootApplication
public class ApplicationBoot {
    public static void main(String[] args) {
        SpringApplication.run(ApplicationBoot.class,args);
    }
}
