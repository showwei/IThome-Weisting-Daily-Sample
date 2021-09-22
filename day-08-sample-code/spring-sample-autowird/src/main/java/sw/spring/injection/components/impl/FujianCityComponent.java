package sw.spring.injection.components.impl;

import org.springframework.stereotype.Component;
import sw.spring.injection.components.ifs.AreaCityComponent;
import sw.spring.injection.enums.AreaEnum;
import sw.spring.injection.model.CityModel;

import java.util.Arrays;
import java.util.List;

@Component("Fujian")
public class FujianCityComponent implements AreaCityComponent {
    @Override
    public List<CityModel> getCityList() {
        CityModel kinmenCounty = new CityModel("Kinmen County","", AreaEnum.EAST);
        CityModel lianjiangCounty = new CityModel("Lianjiang County","", AreaEnum.EAST);

        List<CityModel> cityModels = Arrays.asList(kinmenCounty,
                lianjiangCounty);
        return cityModels;
    }
}
