package sw.project.sample.services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;
import sw.project.sample.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Service("MammalService")
@Role(BeanDefinition.ROLE_APPLICATION)
@Description("Used for verify Mammals type animal.")
public class MammalsAnimalServiceImpl implements AnimalService {


    private static List<Animal> animalList = new ArrayList<Animal>();
    static {
        animalList.add(new Animal()
                .setName("Barron")
                .setType("Dog")
                .setDescription("Barron is a dog.")
        );

        animalList.add(new Animal()
                .setName("Cathy")
                .setType("Cat")
                .setDescription("Cathy is a cat.")
        );
    }

    @Override
    public List<Animal> listAnimalList() {
        return animalList;
    }
}
