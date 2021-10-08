package sw.spring.sample.services;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

public interface SeaFoodRetailerService {

    List<SeaFood> listSeaFoodProducts();
    SeaFood updateSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException,ResourceNotFoundException;
    SeaFood createSeaFood(SeaFood seaFood) throws SeaFoodRetailerGenericException;
    boolean deleteSeaFood(String id);
    default Optional<SeaFood> findProductById(String id) throws ResourceNotFoundException {
        return this.listSeaFoodProducts()
                .stream()
                .filter(seaFood -> seaFood.getId().equalsIgnoreCase(id))
                .findAny();
    }
    default void validateNullId(SeaFood entity) throws SeaFoodRetailerGenericException {
        if (entity.getId() ==null )
            throw new SeaFoodRetailerGenericException("Sea Food Id is REQUIRED ! ");
    }
    default void validateResuouceNotFound(SeaFood bodyEntity) throws ResourceNotFoundException {
        if ( !this.listSeaFoodProducts()
                .stream()
                .anyMatch(seaFood -> seaFood.getId().equalsIgnoreCase(bodyEntity.getId())) )
            throw new ResourceNotFoundException();

    }
}
