package sw.spring.sample.soa;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.Mono;
import sw.spring.sample.config.CompanyInformationConfig;
import sw.spring.sample.exception.ResourceNotFoundException;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;
import sw.spring.sample.models.enums.LocationEnum;
import sw.spring.sample.services.SeaFoodRetailerService;

import javax.annotation.Resource;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ExecutionException;
@Api(tags = "Taiwan Area Retailer ＡＰＩ")
@RestController
public class ProductController extends ControllerBase{
    @Resource(name="seaFoodRetailService",type = SeaFoodRetailerService.class)
    SeaFoodRetailerService seaFoodRetailService;

    Logger logger = LoggerFactory.getLogger(ProductController.class);

    @GetMapping(
            value="/${sea.food.api.taiwan}/list",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns list sea food products", notes = "Returns a list sea food products base on GET Method.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of sea food list products ! ", response = List.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<Flux> listSeaFood() {
        return new ResponseEntity<>(Mono.just(seaFoodRetailService.listSeaFoodProducts()).flatMapMany(Flux::fromIterable),HttpStatus.OK);
    }

    @GetMapping(
            value="/${sea.food.api.taiwan}/find/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns sea food product by id ", notes = "Returns a list sea food product by id base on GET Method.", response = SeaFood.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of sea food products by id! ", response = SeaFood.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<SeaFood> findSeaFoodById(@PathVariable("id") String id) throws ResourceNotFoundException {
        Optional<SeaFood> seaFood =  seaFoodRetailService.findProductById(id);
        if (!seaFood.isPresent())
            throw new ResourceNotFoundException();
        try {
            return new ResponseEntity<SeaFood>(
                    this.testAsyncAnnotationForMethodsWithReturnSeaFood(LocationEnum.TAIWAN,id)
                    , HttpStatus.OK
            );
        } catch (InterruptedException e) {
            logger.error("InterruptedException fail : {}" , e.toString());
            throw new ResourceNotFoundException();
        } catch (ExecutionException e) {
            logger.error("ExecutionException fail : {}" , e.toString());
            throw new ResourceNotFoundException();
        }

    }

    @PostMapping(
            value="/${sea.food.api.taiwan}/create",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns sea food product entity", notes = "Returns a sea food product by id base on request body.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of sea food product ! ", response = SeaFood.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<SeaFood> createSeaFood(@RequestBody SeaFood entity) throws SeaFoodRetailerGenericException {

        return new ResponseEntity<>(
             seaFoodRetailService.createSeaFood(entity)
                ,HttpStatus.CREATED
        );
    }

    @DeleteMapping(
            value="/${sea.food.api.taiwan}/remove/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns boolean value", notes = "Returns a boolean value  on delete request body.", response = Boolean.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of Boolean value ! ", response = Boolean.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<Boolean> deleteSeaFood(@PathVariable("id") String id) {
        return new ResponseEntity<>(
                seaFoodRetailService.deleteSeaFood(id),
                HttpStatus.OK
        );
    }

    @PutMapping(
            value = "/${sea.food.api.taiwan}/update",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns a sea food product entity", notes = "Returns a sea food product by id base on request body.", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of sea food product ! ", response = SeaFood.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
    ResponseEntity<SeaFood> updateSeaFood(@RequestBody SeaFood entityBody) throws SeaFoodRetailerGenericException, ResourceNotFoundException {
        return new ResponseEntity<>(
                seaFoodRetailService.updateSeaFood(entityBody),
                HttpStatus.OK
        );
    }


 }
