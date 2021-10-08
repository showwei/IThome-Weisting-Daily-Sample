package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_TAIWAN;
@Primary
@Service("seaFoodRetailService")
public class SeaFoodRetailerServiceImpl implements SeaFoodRetailerService {

    Logger logger = LoggerFactory.getLogger(SeaFoodRetailerServiceImpl.class);

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
        Mono.fromCallable(() ->seaFood).subscribe(
                new Consumer<SeaFood>() {
                    @Override
                    public void accept(SeaFood seaFood1) {
                        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
                    }
                },
                new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        try {
                            logger.error("Taiwan product create fail. ex:{}",throwable.getMessage());
                            throw new SeaFoodRetailerGenericException("Out of EXPECT error.");
                        } catch (SeaFoodRetailerGenericException e) {
                            e.printStackTrace();
                        }
                    }
                },
                ()->logger.info("Create Taiwan product success ! "));
        return seaFood;
    }

    @Override
    public boolean deleteSeaFood(String id) {
         return SEA_FOOD_CACHE_TAIWAN.asMap().remove(id) != null;
    }
}
