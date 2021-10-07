package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_TAIWAN;
@Primary
@Service("seaFoodRetailService")
public class SeaFoodRetailerServiceImpl implements SeaFoodRetailerService {


    @Override
    public SeaFood updateSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException, ResourceNotFoundException {
        validateNullId(seaFood);
        validateResuouceNotFound(seaFood);
        SeaFood entity = SEA_FOOD_CACHE_TAIWAN.asMap().getOrDefault(seaFood.getId(),null);
        if (entity != null) {
            SEA_FOOD_CACHE_TAIWAN.asMap().put(seaFood.getId(), seaFood);
            return seaFood;
        }
        return null;
    }

    @Override
    public List<SeaFood> listSeaFoodProducts() {
        return SEA_FOOD_CACHE_TAIWAN
                .asMap()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public SeaFood createSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException {
        validateNullId(seaFood);
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
        return seaFood;
    }

    @Override
    public boolean deleteSeaFood(String id) {
         return SEA_FOOD_CACHE_TAIWAN.asMap().remove(id) != null;
    }
}
