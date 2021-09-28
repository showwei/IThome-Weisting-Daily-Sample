package sw.project.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Order(300)
@Configuration
public class AppConfig {


    @Bean(name = "DevC",initMethod = "init",destroyMethod = "destroy")
    @Order(200)
    public IDEBeanEntity getDevCPlusIDE() {
        IDEBeanEntity ideBeanEntity = new IDEBeanEntity()
                .setId("ID-001")
                .setName("DEV-C++")
                .setDescription("是一套用於開發C/C++的自由的整合式開發環境，並以GPL作為散布許可。使用MinGW及GDB作為編譯系統與除錯系統。");
        return ideBeanEntity;
    }


    @Bean(name = "DevC2",initMethod = "init",destroyMethod = "destroy")
    @Order(100)
    public IDEBeanEntity getDevCPlusIDE2() {
        IDEBeanEntity ideBeanEntity = new IDEBeanEntity()
                .setId("ID-002")
                .setName("DEV-C")
                .setDescription("是一套用於開發C/C++的自由的整合式開發環境，並以GPL作為散布許可。使用MinGW及GDB作為編譯系統與除錯系統。");
        return ideBeanEntity;
    }
}
