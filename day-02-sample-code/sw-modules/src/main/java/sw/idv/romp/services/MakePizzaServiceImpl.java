package sw.idv.romp.services;

import sw.idv.romp.annotations.Prejump;

public class MakePizzaServiceImpl implements MakePizzaService {

    @Prejump(value = "15.5" , name = "pizza archive ! ")
    double archiveNumber;

    @Prejump(value = "0.15", name="For sell discount")
    float discount;

    @Prejump(value = "WEISTING COMPANY", name = "Weisting Company")
    String companyName;

    @Prejump(value = "200", name = "pizza price")
    int price;

    @Override
    public String makeDough() {
        return "Cheese + pineapple + pizza dough";
    }

    @Override
    public String makeMeals() {
       return "fork + carrot";
    }

    @Override
    public String makeCondiment() {
       return "pepper ! ";
    }

    @Override
    public String showMyCompany() {
        return "YO ! This is " + companyName + ", We have " + archiveNumber + " pizzas.";
    }

    @Override
    public double sellPizza(int number) {
        return (price* (1-discount)) * number;
    }


}
