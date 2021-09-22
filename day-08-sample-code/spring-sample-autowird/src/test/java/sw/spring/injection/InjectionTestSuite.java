package sw.spring.injection;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import sw.spring.injection.components.ifs.AreaCityComponent;
import sw.spring.injection.model.CityModel;

import java.util.List;

public class InjectionTestSuite extends ServiceTestBase {

    @Autowired
    AreaCityComponent primaryComponent;

    @Qualifier("Center")
    @Autowired
    AreaCityComponent qualifierWithCenterAreaComponent;

    @Qualifier("SouthBean")
    @Autowired
    AreaCityComponent overrideWithSouthBeanComponent;

    AreaCityComponent eastCityComponent;


    AreaCityComponent fujianCityComponent;

    @Qualifier("Weisting")
    @Autowired(required = false)
    AreaCityComponent weistingCityComponent;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    BeanFactory beanFactory;

    @Before
    public void init() {
        eastCityComponent =  applicationContext.getBean("East",AreaCityComponent.class);
        fujianCityComponent = beanFactory.getBean("Fujian",AreaCityComponent.class);
    }

    @Test
    public void testAutoGetPrimaryComponent() {
        List<CityModel> cityModels = primaryComponent.getCityList();
        assertEquals(cityModels.size(),7);
        System.out.println(">>  Validate get primary component from Autowird success.");
    }


    @Test
    public void testAutoGetQualifierComponent() {
        List<CityModel> cityModels = qualifierWithCenterAreaComponent.getCityList();
        assertEquals(cityModels.size(),5);
        System.out.println(">>  Validate get component from Autowired with Qualifier success.");
    }

    @Test
    public void testAutoGetQualifieFromBean() {
        List<CityModel> cityModels = overrideWithSouthBeanComponent.getCityList();
        CityModel cityModel = cityModels
                .stream()
                .filter(cityModel1 -> cityModel1.getName().equalsIgnoreCase("Penghu County"))
                .findFirst()
                .orElse(null);
        assertEquals(cityModels.size(),6);

        System.out.println(">>  Validate get component from  Qualifier's Bean size correct ! ");
        assertEquals(cityModel.getSpecialLocalProduct(),"Brown Sugar Steamed Cake");
        System.out.println(">>  Validate override bean's specialLocalProduct method is correct ! ");
    }


    @Test
    public void testGetComponentFromApplicationContext() {
        List<CityModel> cityModels = eastCityComponent.getCityList();
        assertEquals(cityModels.size(),2);
        System.out.println(">>  Validate get component from application context success.");
    }

    @Test
    public void testGetComponentFromBeanFactory() {
        List<CityModel> cityModels = fujianCityComponent.getCityList();
        assertEquals(cityModels.size(),2);
        System.out.println(">>  Validate get component from Bean Factory success.");
    }


    @Test
    public void testNotExistedComponentFromAutowired() {
        assertEquals(weistingCityComponent,null);
        System.out.println(">>  Validate get has no existed component from Autowired success.");
    }
}
