package sw.sample.spring;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sw.sample.spring.model.Chef;
import sw.sample.spring.service.ConfigService;

import static junit.framework.TestCase.assertTrue;

public class ConfigServiceSuite extends ServiceTestBase {

    @Autowired
    ConfigService configService;


    @Autowired
    Chef chef;

    @Test
    public void validateChefBRemark() {
        assertTrue(chef.getRemark().equalsIgnoreCase("Michelin-chef and dessert"));
        System.out.println("validate Chef B Remark success!");
    }

    @Test
    public void validateChefBName() {
        assertTrue(chef.getName().equalsIgnoreCase("Jyuh"));
        System.out.println("validate Chef B Remark success!");
    }

    @Test
    public void validateChefBSkills() {
        assertTrue(chef.getSpecialSkills().size()==3);
        System.out.println("validate Chef B Special Skills success!");
    }


    @Test
    public void validateChefSize() {
        assertTrue(configService.getAllChef().size() == 2);
        System.out.println("validate Chef size success!");
    }

    @Test
    public void validateIdExisted() {
        assertTrue(configService.getIdByChef("chef-A") != null);
        System.out.println("validate Id success ! ");
    }

    @Test
    public void validateNameExisted() {
        assertTrue(configService.getNameByChef("chef-A").equalsIgnoreCase("Weisting"));
        System.out.println("validate Name success!");
    }


    @Test
    public void validateRemarkExisted() {
        assertTrue(configService.getRemarkByChef("chef-A").equalsIgnoreCase("Michelin-chef and main meal chef."));
        System.out.println("validate Remark success!");
    }

    @Test
    public void validateSpecialSkillExisted() {
        assertTrue(configService.getSpecialSkillsByChef("chef-A").size() == 3);
        System.out.println("validate Special skill success!");
    }

}
