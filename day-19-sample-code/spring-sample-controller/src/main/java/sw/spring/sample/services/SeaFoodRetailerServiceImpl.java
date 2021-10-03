package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

@Service("seaFoodRetailService")
public class SeaFoodRetailerServiceImpl implements SeaFoodRetailerService {
   public static final Cache<String, SeaFood> SEA_FOOD_CACHE =  CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();;

   static {

       SEA_FOOD_CACHE.asMap().putIfAbsent(
               "F-0001",
               new SeaFood()
                       .setId("F-0001")
                        .setDescription("Gold type for the Dragon fish.")
                        .setName("Dragon fish"));
       SEA_FOOD_CACHE.asMap().putIfAbsent(
               "C-0001",
               new SeaFood()
                       .setId("C-0001")
                       .setDescription("A taxon of crab-like decapod crustaceans chiefly found in cold seas.")
                       .setName("King Crab"));
       SEA_FOOD_CACHE.asMap().putIfAbsent(
               "C-0002",
               new SeaFood()
                       .setId("C-0002")
                       .setDescription("Opilio is the primary species referred to as snow crab.")
                       .setName("Snow Crab"));
   }

    @Override
    public SeaFood updateSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException, ResourceNotFoundException {
        validateNullId(seaFood);
        validateResuouceNotFound(seaFood);
        SeaFood entity = this.SEA_FOOD_CACHE.asMap().getOrDefault(seaFood.getId(),null);
        if (entity != null) {
            this.SEA_FOOD_CACHE.asMap().put(seaFood.getId(), seaFood);
            return seaFood;
        }
        return null;
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
    public SeaFood createSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException {
        validateNullId(seaFood);
        this.SEA_FOOD_CACHE.asMap().putIfAbsent(seaFood.getId(),seaFood);
        return seaFood;
    }

    @Override
    public boolean deleteSeaFood(String id) {
         return this.SEA_FOOD_CACHE.asMap().remove(id) != null;
    }
}
