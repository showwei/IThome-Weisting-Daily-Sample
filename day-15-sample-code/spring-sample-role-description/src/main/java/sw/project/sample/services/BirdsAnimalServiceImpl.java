package sw.project.sample.services;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Description;
import org.springframework.context.annotation.Role;
import org.springframework.stereotype.Service;
import sw.project.sample.model.Animal;

import java.util.ArrayList;
import java.util.List;

@Service("BirdService")
@Role(BeanDefinition.ROLE_SUPPORT)
@Description("Used for verify Birds type animal.")
public class BirdsAnimalServiceImpl implements AnimalService {

    private static List<Animal> animalList = new ArrayList<Animal>();
    static {
        animalList.add(new Animal()
                .setName("Syml")
                .setType("Chicken")
                .setDescription("park is a chicken.")
        );

        animalList.add(new Animal()
                .setName("Dylan")
                .setType("Duck")
                .setDescription("Dylan is a duck.")
        );
    }

    @Override
    public List<Animal> listAnimalList() {
        return animalList;
    }
}
