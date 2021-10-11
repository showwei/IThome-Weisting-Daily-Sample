package sw.spring.sample.swagger;

import com.google.common.collect.Sets;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.paths.RelativePathProvider;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@Configuration
@EnableSwagger2
@EnableWebMvc
@Component
public class SwaggerConfig {

    @Value("${server.servlet.context-path}")
    String serviceBasePath;

    @Bean
    public Docket apiDefault() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("sw.spring.sample.soa"))
                .paths(PathSelectors.any())
                .build()
                .enable(true)
                .consumes(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE))
                .produces(Sets.newHashSet(MediaType.APPLICATION_JSON_VALUE));
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("WEISTING's Seafood RESTful API Information")
                .description("Definition of the Asia area Seafood product Retailer from Taiwan and China.")
                .license("Darius Weisting")
                .version("1.0")
                .contact(new Contact("Darius Weisting",null,"showwei0217@gmail.com"))
                .build();
    }
}
