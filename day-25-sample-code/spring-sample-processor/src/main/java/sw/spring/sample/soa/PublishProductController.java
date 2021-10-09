package sw.spring.sample.soa;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;
import sw.spring.sample.services.broadcast.ProductsOrderBookService;
import sw.spring.sample.services.subscribe.CacheSubscribeService;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestController
public class PublishProductController extends ControllerBase {

    @Autowired
    CacheSubscribeService cacheSubscribeService;

    @Autowired
    ProductsOrderBookService productsOrderBookService;

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


    @GetMapping(
            value="/orderbook/${sea.food.api.all}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity< Map<String , List<SeaFood>>> orderBookSeaFood() throws SeaFoodRetailerGenericException {

        Map<String , List<SeaFood>> orderBookMap = new LinkedHashMap<String,List<SeaFood>>();
        orderBookMap.put("TW",productsOrderBookService.getTaiwanOrderBook());
        orderBookMap.put("CN",productsOrderBookService.getChinaOrderBook());
        return new ResponseEntity<>(
                orderBookMap
                , HttpStatus.CREATED
        );
    }
}
