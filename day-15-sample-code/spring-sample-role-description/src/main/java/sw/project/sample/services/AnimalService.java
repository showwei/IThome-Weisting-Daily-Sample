package sw.project.sample.services;

import sw.project.sample.model.Animal;

import java.util.List;

public interface AnimalService {

    List<Animal> listAnimalList();
    default Animal getAnimalByName(String name) {
        return listAnimalList()
                .stream()
                .filter(animal -> animal.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }
}
