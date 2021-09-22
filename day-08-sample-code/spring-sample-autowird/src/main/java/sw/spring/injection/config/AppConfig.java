package sw.spring.injection.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sw.spring.injection.components.impl.*;
import sw.spring.injection.enums.AreaEnum;
import sw.spring.injection.model.CityModel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class AppConfig {

    @Qualifier("South")
    @Autowired
    SouthCityComponent southCityComponent;


    @Bean("NorthBean")
    public NorthCityComponent getNorthCityComponent() {
        return new NorthCityComponent();
    }

    @Bean("SouthBean")
    public SouthCityComponent getSouthCityComponent() {
        return new SouthCityComponent() {
            @Override
            public List<CityModel> getCityList() {
                List<CityModel> cityModels = southCityComponent.getCityList();

                cityModels = cityModels.stream().map(cityModel -> {
                    if (cityModel.getName().equalsIgnoreCase("Penghu County")) {
                        cityModel.setSpecialLocalProduct("Brown Sugar Steamed Cake");
                    }
                    return cityModel;
                }).collect(Collectors.toList());
                return cityModels;
            }
        };
    }

    @Bean("CenterBean")
    public CenterCityComponent getCenterCityComponent() {
        return new CenterCityComponent();
    }

    @Bean("EastBean")
    public EastCityComponent getEastCityComponent() {
        return new EastCityComponent();
    }

    @Bean("FujianBean")
    public FujianCityComponent getFujianCityComponent() {
        return new FujianCityComponent();
    }
}


