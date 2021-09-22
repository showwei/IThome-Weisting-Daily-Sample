package sw.spring.injection.components.impl;

import org.springframework.stereotype.Component;
import sw.spring.injection.components.ifs.AreaCityComponent;
import sw.spring.injection.enums.AreaEnum;
import sw.spring.injection.model.CityModel;

import java.util.Arrays;
import java.util.List;

@Component("East")
public class EastCityComponent implements AreaCityComponent {
    @Override
    public List<CityModel> getCityList() {
        CityModel hualienCity = new CityModel("Hualien City","", AreaEnum.EAST);
        CityModel taitungCounty = new CityModel("Taitung County","", AreaEnum.EAST);

        List<CityModel> cityModels = Arrays.asList(hualienCity,
                taitungCounty);
        return cityModels;
    }

}
