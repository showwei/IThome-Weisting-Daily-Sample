package sw.sample.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import sw.sample.spring.model.Chef;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class AppConfig {

    @Bean(name= "chef-A")
    public Chef initChefA() {
        Chef chef = new Chef();
        long generatedLong = 500000L + (long) (Math.random() * (1000000L - 500000L));
        chef.setId(generatedLong);
        chef.setName("Weisting");
        chef.setRemark("Michelin-chef and main meal chef.");
        List<String> specialSkills = new ArrayList<String>();
        specialSkills.add("Gold chicken");
        specialSkills.add("Assorted fried noodles");
        specialSkills.add("Crab Fragrant Huangbao");
        chef.setSpecialSkills(specialSkills);
        return chef;
    }
    @Primary
    @Bean(name= "chef-B")
    public Chef initChefB() {
        Chef chef = new Chef();
        long generatedLong = 500000L + (long) (Math.random() * (1000000L - 500000L));
        chef.setId(generatedLong);
        chef.setName("Jyuh");
        chef.setRemark("Michelin-chef and dessert");
        List<String> specialSkills = new ArrayList<String>();
        specialSkills.add("Gold cake");
        specialSkills.add("noodle pie");
        specialSkills.add("chocolate pie");
        chef.setSpecialSkills(specialSkills);
        return chef;
    }
}
