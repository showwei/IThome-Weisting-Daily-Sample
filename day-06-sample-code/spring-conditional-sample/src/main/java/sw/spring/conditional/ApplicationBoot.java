package sw.spring.conditional;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.sql.DataSource;

@EnableMBeanExport
@SpringBootApplication
public class ApplicationBoot {

    public static void main(String[] args) {
        JndiObjectFactoryBean bean = new JndiObjectFactoryBean();
        bean.setJndiName("java:comp/env/jdbc/myJndiResource");

        DataSource object = (DataSource) bean.getObject();

        SpringApplication.run(ApplicationBoot.class,args);
    }

}
