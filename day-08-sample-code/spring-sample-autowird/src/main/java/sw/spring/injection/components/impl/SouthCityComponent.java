package sw.spring.injection.components.impl;

import org.graalvm.compiler.lir.CompositeValue;
import org.springframework.stereotype.Component;
import sw.spring.injection.components.ifs.AreaCityComponent;
import sw.spring.injection.enums.AreaEnum;
import sw.spring.injection.model.CityModel;

import java.util.Arrays;
import java.util.List;

@Component("South")
public class SouthCityComponent implements AreaCityComponent {
    @Override
    public List<CityModel> getCityList() {
        CityModel kaohsiungCity = new CityModel("Kaohsiung City","", AreaEnum.SOUTH);
        CityModel tainanCity = new CityModel("Tainan City","", AreaEnum.SOUTH);
        CityModel chiayiCity = new CityModel("Chiayi City","", AreaEnum.SOUTH);
        CityModel chiayiCounty = new CityModel("Chiayi County","", AreaEnum.SOUTH);
        CityModel pingtungCounty = new CityModel("Pingtung County","", AreaEnum.SOUTH);
        CityModel penghuCounty = new CityModel("Penghu County","", AreaEnum.SOUTH);

        List<CityModel> cityModels = Arrays.asList(kaohsiungCity,
                tainanCity,
                chiayiCity,
                chiayiCounty,
                pingtungCounty,
                penghuCounty);
        return cityModels;
    }
}
