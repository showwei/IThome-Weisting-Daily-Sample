package sw.spring.injection.components.impl;

import org.springframework.stereotype.Component;
import sw.spring.injection.components.ifs.AreaCityComponent;
import sw.spring.injection.enums.AreaEnum;
import sw.spring.injection.model.CityModel;

import java.util.Arrays;
import java.util.List;

@Component("Center")
public class CenterCityComponent implements AreaCityComponent {


    @Override
    public List<CityModel> getCityList() {
        CityModel taichungCity = new CityModel("Taichung City","", AreaEnum.CENTER);
        CityModel miaoliCounty = new CityModel("Miaoli County","", AreaEnum.CENTER);
        CityModel changhuaCounty = new CityModel("Changhua County","", AreaEnum.CENTER);
        CityModel nantouCounty = new CityModel("Nantou County","", AreaEnum.CENTER);
        CityModel yunlinCounty = new CityModel("Yunlin County","", AreaEnum.CENTER);

        List<CityModel> cityModels = Arrays.asList(taichungCity,
                miaoliCounty,
                changhuaCounty,
                nantouCounty,
                yunlinCounty);
        return cityModels;
    }

}
