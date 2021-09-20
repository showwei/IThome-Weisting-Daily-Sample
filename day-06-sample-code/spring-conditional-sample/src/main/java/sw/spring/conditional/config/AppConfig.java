package sw.spring.conditional.config;

import org.springframework.boot.autoconfigure.condition.*;
import org.springframework.boot.autoconfigure.data.ConditionalOnRepositoryType;
import org.springframework.boot.autoconfigure.data.RepositoryType;
import org.springframework.boot.autoconfigure.security.ConditionalOnDefaultWebSecurity;
import org.springframework.boot.autoconfigure.web.ConditionalOnEnabledResourceChain;
import org.springframework.boot.autoconfigure.web.servlet.ConditionalOnMissingFilterBean;
import org.springframework.boot.cloud.CloudPlatform;
import org.springframework.boot.system.JavaVersion;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.ForwardedHeaderFilter;
import org.springframework.web.servlet.resource.ResourceUrlEncodingFilter;
import sw.spring.conditional.ApplicationBoot;
import sw.spring.conditional.conditions.MacCondition;
import sw.spring.conditional.model.Animal;
import sw.spring.conditional.model.Cat;
import sw.spring.conditional.model.Dog;
import sw.spring.conditional.model.Turtle;

@Configuration
public class AppConfig {

    @Bean("Weisting")
    public Animal getAnimalOfPeople() {
        Animal animal = new Animal();
        animal.setName("Weisting");
        animal.setType("Men-Person");
        return animal;
    }

    @Bean("machine")
    @Conditional(MacCondition.class)
    public Dog getAnimalOfDogWithMachine() {
        Dog dog = new Dog();
        dog.setName("machine");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }


    @Bean("Pomeranian")
    @ConditionalOnBean(name="Weisting")
    public Dog getAnimalOfDog() {
        Dog dog = new Dog();
        dog.setName("Pomeranian");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("TBaby")
    @ConditionalOnClass(Animal.class)
    public Turtle getAnimalOfTurtle() {
        Turtle turtle = new Turtle();
        turtle.setName("TBaby");
        turtle.setType("Turtle");
        turtle.setBehavior("Climb");
        return turtle;
    }

    @Bean("malzis")
    @ConditionalOnMissingBean(name="Pomeranian")
    public Dog getAnimalOfDogWithMalzis() {
        Dog dog= new Dog();
        dog.setName("malzis");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("lucky")
    @ConditionalOnMissingClass(value = {"sw.spring.conditional.model.Cat"})
    public Dog getAnimalOfDogWithLucky() {
        Dog dog= new Dog();
        dog.setName("lucky");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("husky")
    @ConditionalOnWebApplication
    public Dog getAnimalOfDogWithHusky() {
        Dog dog= new Dog();
        dog.setName("husky");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("ghost")
    @ConditionalOnNotWebApplication
    public Dog getAnimalOfDogWithGhost() {
        Dog dog= new Dog();
        dog.setName("ghost");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("Bernard")
    @ConditionalOnProperty(prefix = "sw.spring.conditional",name = "assert",havingValue = "true")
    public Turtle getAnimalOfTurtleWithBernard() {
        Turtle turtle = new Turtle();
        turtle.setName("Bernard");
        turtle.setType("Turtle");
        turtle.setBehavior("Climb");
        return turtle;
    }

    @Bean("schnauzer")
    @ConditionalOnJava(JavaVersion.FIFTEEN)
    public Dog getAnimalOfTurtleWithSchnauzer() {
        Dog dog= new Dog();
        dog.setName("schnauzer");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("dylan")
    @ConditionalOnExpression("#{'true'.equals(environment['sw.spring.conditional.assert'])}")
    public Dog getAnimalOfDogWithDylan() {
        Dog dog = new Dog();
        dog.setName("dylan");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }


    @Bean("resource")
    @ConditionalOnResource( resources = "classpath:/application.properties")
    public Dog getAnimalOfDogWithResource() {
        Dog dog = new Dog();
        dog.setName("resource");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("robert")
    @ConditionalOnSingleCandidate(ApplicationBoot.class)
    public Dog getAnimalOfDogWithSingleCandidate() {
        Dog dog = new Dog();
        dog.setName("robert");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }

    @Bean("JPA-Repository")
    @ConditionalOnRepositoryType(store = "JPA-Repository",type= RepositoryType.NONE)
    public Turtle getAnimalOfFlyTurtle() {
        Turtle turtle = new Turtle();
        turtle.setName("JPA-Repository");
        turtle.setType("Turtle");
        turtle.setBehavior("Climb");
        return turtle;
    }

    @Bean("war")
    @ConditionalOnWarDeployment
    public Dog getAnimalOfDogWithJNDI() {
        Dog dog = new Dog();
        dog.setName("war");
        dog.setType("Dog");
        dog.setSound("Wong ! Wong ! Wong !");
        return dog;
    }
}
