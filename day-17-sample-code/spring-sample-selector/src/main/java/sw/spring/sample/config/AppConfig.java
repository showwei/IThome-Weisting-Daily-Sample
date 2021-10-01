package sw.spring.sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sw.spring.sample.model.MarketMdl;

@Configuration
public class AppConfig {

    @Bean("WeistingMarket")
    public MarketMdl getWeistingMarket() {
        return new MarketMdl().setName("Weisting Market")
                            .setDescription("Created by Weisting.");
    }

    @Bean("JyunMarket")
    public MarketMdl getJyunMarket() {
        return new MarketMdl().setName("Jyun Market")
                .setDescription("Created by Jyun.");
    }

}
