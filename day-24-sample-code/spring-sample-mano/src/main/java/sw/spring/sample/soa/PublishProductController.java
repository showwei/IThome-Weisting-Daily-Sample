package sw.spring.sample.soa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;
import sw.spring.sample.subscribe.CacheSubscribeService;

@RestController
public class PublishProductController extends ControllerBase {

    @Autowired
    CacheSubscribeService cacheSubscribeService;

    @PostMapping(
            value="/${sea.food.api.all}/create",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<SeaFood> createSeaFood(@RequestBody SeaFood entity) throws SeaFoodRetailerGenericException {
        return new ResponseEntity<>(
                cacheSubscribeService.subscribeAllLocationSeaFoodProducts(entity)
                , HttpStatus.CREATED
        );
    }

}
