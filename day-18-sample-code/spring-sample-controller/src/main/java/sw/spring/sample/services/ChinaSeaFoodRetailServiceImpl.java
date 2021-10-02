package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service("chinaSeaFoodRetailService")
public class ChinaSeaFoodRetailServiceImpl implements SeaFoodRetailService {
    public static final Cache<String, SeaFood> SEA_FOOD_CACHE =  CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();;

    static {

        SEA_FOOD_CACHE.asMap().putIfAbsent(
                "F-0001",
                new SeaFood()
                        .setId("F-0001")
                        .setDescription("Sturgeon is the common name for the 27 species of fish belonging to the family Acipenseridae..")
                        .setName("Sturgeon fish"));
        SEA_FOOD_CACHE.asMap().putIfAbsent(
                "C-0001",
                new SeaFood()
                        .setId("C-0001")
                        .setDescription("Is a medium-sized burrowing crab that is named for its furry claws.")
                        .setName("Hairy crabs"));
    }

    @Override
    public List<SeaFood> listSeaFoodProducts() {
        return this.SEA_FOOD_CACHE
                .asMap()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public SeaFood updateSeaFood(SeaFood seaFood) {
        SeaFood entity = this.SEA_FOOD_CACHE.asMap().getOrDefault(seaFood.getId(),null);
        if (entity != null) {
            this.SEA_FOOD_CACHE.asMap().put(seaFood.getId(), seaFood);
            return seaFood;
        }
        return null;
    }

    @Override
    public SeaFood createSeaFood(SeaFood seaFood) {
        this.SEA_FOOD_CACHE.asMap().putIfAbsent(seaFood.getId(),seaFood);
        return seaFood;
    }

    @Override
    public boolean deleteSeaFood(String id) {
        return this.SEA_FOOD_CACHE.asMap().remove(id) != null;
    }
}
