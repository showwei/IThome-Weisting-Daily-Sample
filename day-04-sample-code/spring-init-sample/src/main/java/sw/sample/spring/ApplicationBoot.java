package sw.sample.spring;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;

@SpringBootApplication
@EnableMBeanExport
public class ApplicationBoot {
    public static void main(String[] args) {
        org.springframework.boot.SpringApplication.run(ApplicationBoot.class,args);
    }
}
