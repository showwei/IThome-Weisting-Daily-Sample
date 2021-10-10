package sw.spring.sample.swagger;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
@EnableWebMvc
public class SwaggerWebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        //預設攔截路徑
        registry.addMapping("/**")
                //表示允许網域發發起哪些請求，這裡表示支援HEAD,GET,PUT,POST,DELETE,PATCH
                .allowedMethods("HEAD", "GET", "PUT", "POST", "DELETE", "PATCH");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //Swagger路徑映射配置
        registry.addRedirectViewController("/docApi/v2/api-docs", "/v2/api-docs");
        registry.addRedirectViewController("/docApi/swagger-resources/configuration/ui", "/swagger-resources/configuration/ui");
        registry.addRedirectViewController("/docApi/swagger-resources/configuration/security", "/swagger-resources/configuration/security");
        registry.addRedirectViewController("/docApi/swagger-resources", "/swagger-resources");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 新增Swagger對映路徑
        registry.addResourceHandler("/docApi/swagger-ui.html**").addResourceLocations("classpath:/META-INF/resources/swagger-ui.html");
        registry.addResourceHandler("/docApi/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
    }
}