package sw.spring.sample.soa.v1;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
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
import sw.spring.sample.soa.ControllerBase;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Api(tags = "Asia area ＡＰＩ")
@RestController
public class PublishProductController extends ControllerBase {

    @Autowired
    CacheSubscribeService cacheSubscribeService;

    @Autowired
    ProductsOrderBookService productsOrderBookService;

    @PostMapping(
            value="/${sea.food.api.all}/create",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns sea food product entity", notes = "Returns a sea food product by id base on request body.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of sea food product ! ", response = SeaFood.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<SeaFood> createSeaFoodIntoAllArea(@RequestBody SeaFood entity) throws SeaFoodRetailerGenericException {
        return new ResponseEntity<>(
                cacheSubscribeService.subscribeAllLocationSeaFoodProducts(entity)
                , HttpStatus.CREATED
        );
    }


    @GetMapping(
            value="/orderbook/${sea.food.api.all}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns taiwan and china sea food ORDERBOOK. ", notes = "Returns taiwan and china sea food ORDERBOOK.", response = Map.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of taiwan and china sea food ORDERBOOK ! ", response = SeaFood.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity< Map<String , List<SeaFood>>> orderBookSeaFood() throws SeaFoodRetailerGenericException {

        Map<String , List<SeaFood>> orderBookMap = new LinkedHashMap<String,List<SeaFood>>();
        orderBookMap.put("TW",productsOrderBookService.getTaiwanOrderBook());
        orderBookMap.put("CN",productsOrderBookService.getChinaOrderBook());
        return new ResponseEntity<>(
                orderBookMap
                , HttpStatus.OK
        );
    }
}
