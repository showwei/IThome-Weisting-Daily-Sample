package sw.spring.injection.components.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import sw.spring.injection.components.ifs.AreaCityComponent;
import sw.spring.injection.enums.AreaEnum;
import sw.spring.injection.model.CityModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Primary
@Component("North")
public class NorthCityComponent implements AreaCityComponent {


    @Override
    public List<CityModel> getCityList() {
        CityModel taipei = new CityModel("Taipei","", AreaEnum.NORTH);
        CityModel newTaipei = new CityModel("New Taipei","", AreaEnum.NORTH);
        CityModel keelung = new CityModel("Keelung","", AreaEnum.NORTH);
        CityModel hsinchuCity = new CityModel("Hsinchu City","", AreaEnum.NORTH);
        CityModel taoyuan = new CityModel("Taoyuan","", AreaEnum.NORTH);
        CityModel hsinchuCounty = new CityModel("Hsinchu County","", AreaEnum.NORTH);
        CityModel yilanCounty = new CityModel("Yilan County","", AreaEnum.NORTH);

        List<CityModel> cityModels = Arrays.asList(taipei,
                newTaipei,
                keelung,
                hsinchuCity,
                taoyuan,
                hsinchuCounty,
                yilanCounty);
        return cityModels;
    }
}
