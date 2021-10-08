package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_CHINESE;
import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_TAIWAN;

@Service("chinaSeaFoodRetailService")
public class ChinaSeaFoodRetailerServiceImpl implements SeaFoodRetailerService {
    Logger logger = LoggerFactory.getLogger(ChinaSeaFoodRetailerServiceImpl.class);
    @Override
    public List<SeaFood> listSeaFoodProducts() {
        return SEA_FOOD_CACHE_CHINESE
                .asMap()
                .values()
                .stream()
                .collect(Collectors.toList());
    }

    @Override
    public SeaFood updateSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException, ResourceNotFoundException {
        validateNullId(seaFood);
        validateResuouceNotFound(seaFood);
        SeaFood entity = SEA_FOOD_CACHE_CHINESE.asMap().getOrDefault(seaFood.getId(),null);
        if (entity != null) {
            SEA_FOOD_CACHE_CHINESE.asMap().put(seaFood.getId(), seaFood);
            return seaFood;
        }
        return null;
    }

    @Override
    public SeaFood createSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException {
        validateNullId(seaFood);
        validateNullId(seaFood);
        Mono.fromCallable(() ->seaFood).subscribe(
                new Consumer<SeaFood>() {
                    @Override
                    public void accept(SeaFood seaFood1) {
                        SEA_FOOD_CACHE_CHINESE.asMap().putIfAbsent(seaFood.getId(),seaFood);
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        try {
                            logger.error("China product create fail. ex:{}",throwable.getMessage());
                            throw new SeaFoodRetailerGenericException("Out of EXPECT error.");
                        } catch (SeaFoodRetailerGenericException e) {
                            e.printStackTrace();
                        }
                    }
                },
                ()->logger.info("Create China product success ! "));

        return seaFood;
    }

    @Override
    public boolean deleteSeaFood(String id) {
        return SEA_FOOD_CACHE_CHINESE.asMap().remove(id) != null;
    }
}
