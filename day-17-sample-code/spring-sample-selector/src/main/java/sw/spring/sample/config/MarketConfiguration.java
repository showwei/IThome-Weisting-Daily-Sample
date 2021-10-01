package sw.spring.sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import sw.spring.sample.selector.MarketImportSelector;

@Configuration
@Import({MarketImportSelector.class,AppConfig.class})
public class MarketConfiguration {
}
