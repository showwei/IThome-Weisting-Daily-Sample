package sw.spring.sample.soa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sw.spring.sample.config.CompanyInformationConfig;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;
import sw.spring.sample.services.SeaFoodRetailerService;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class ProductController extends ControllerBase{
    @Resource(name="seaFoodRetailService",type = SeaFoodRetailerService.class)
    SeaFoodRetailerService seaFoodRetailService;

    @GetMapping(
            value="/${sea.food.api.taiwan}/list"
    )
    List<SeaFood> listSeaFood() {
        return seaFoodRetailService.listSeaFoodProducts();

    }

    @GetMapping(
            value="/${sea.food.api.taiwan}/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<SeaFood> findSeaFoodById(@PathVariable("id") String id) throws ResourceNotFoundException {
        Optional<SeaFood> seaFood =  seaFoodRetailService.findProductById(id);
        if (!seaFood.isPresent())
            throw new ResourceNotFoundException();
        return new ResponseEntity<SeaFood>(
                seaFood.get()
                , HttpStatus.OK
        );
    }

    @PostMapping(
            value="/${sea.food.api.taiwan}/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<SeaFood> createSeaFood(@RequestBody SeaFood entity) throws SeaFoodRetailerGenericException {
        return new ResponseEntity<>(
                seaFoodRetailService.createSeaFood(entity)
                ,HttpStatus.CREATED
        );
    }

    @DeleteMapping(
            value="/${sea.food.api.taiwan}/remove/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<Boolean> deleteSeaFood(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                seaFoodRetailService.deleteSeaFood(id),
                HttpStatus.OK
        );
    }

    @PutMapping(
            value = "/${sea.food.api.taiwan}/update",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<SeaFood> updateSeaFood(@RequestBody SeaFood entityBody) throws SeaFoodRetailerGenericException, ResourceNotFoundException {
        return new ResponseEntity<>(
                seaFoodRetailService.updateSeaFood(entityBody),
                HttpStatus.OK
        );
    }
 }
