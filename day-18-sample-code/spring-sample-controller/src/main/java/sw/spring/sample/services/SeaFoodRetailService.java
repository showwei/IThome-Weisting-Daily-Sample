package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface SeaFoodRetailService {

    List<SeaFood> listSeaFoodProducts();
    SeaFood updateSeaFood(SeaFood seaFood);
    SeaFood createSeaFood(SeaFood seaFood);
    boolean deleteSeaFood(String id);
    default Optional<SeaFood> findProductById(String id) {
        return this.listSeaFoodProducts()
                .stream()
                .filter(seaFood -> seaFood.getId().equalsIgnoreCase(id))
                .findAny();
    }


}
