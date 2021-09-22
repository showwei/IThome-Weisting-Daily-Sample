package sw.spring.injection.model;

import sw.spring.injection.enums.AreaEnum;

public class CityModel {

    public CityModel(String name, String specialLocalProduct, AreaEnum areaEnum) {
        this.name = name;
        this.specialLocalProduct = specialLocalProduct;
        this.areaEnum = areaEnum;
    }

    String name;

    String specialLocalProduct;

    AreaEnum areaEnum;

    public String getName() {
        return name;
    }

    public CityModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getSpecialLocalProduct() {
        return specialLocalProduct;
    }

    public CityModel setSpecialLocalProduct(String specialLocalProduct) {
        this.specialLocalProduct = specialLocalProduct;
        return this;
    }

    public AreaEnum getAreaEnum() {
        return areaEnum;
    }

    public CityModel setAreaEnum(AreaEnum areaEnum) {
        this.areaEnum = areaEnum;
        return this;
    }
}
