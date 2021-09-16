package sw.idv.romp.handler;

import sw.idv.romp.annotations.Prejump;
import sw.idv.romp.services.AnimalService;

public class AutowiredHandler {

    @Prejump(value = "test1" , name = "String")
    String test;

    @Prejump(value = "3" , name = "float")
    Integer abc;

    @Prejump(value = "3.14" , name = "float")
    float aFloat;

    @Prejump(value = "sw.idv.romp.services.AnimalServiceImpl" , name = "AnimalService")
    AnimalService animalService;

    @Prejump(value = "Sprint" , name = "do method")
    public String doPipeFunc() {
        String behavior = "pipe";
        System.out.println("test > " + test);
        return behavior;
    }

    public String getTest() {
        return test;
    }

    public void setTest(String test) {
        this.test = test;
    }

    public AnimalService getAnimalService() {
        return animalService;
    }

    public void setAnimalService(AnimalService animalService) {
        this.animalService = animalService;
    }

    public Integer getAbc() {
        return abc;
    }

    public void setAbc(Integer abc) {
        this.abc = abc;
    }

    public float getaFloat() {
        return aFloat;
    }

    public void setaFloat(float aFloat) {
        this.aFloat = aFloat;
    }
}
