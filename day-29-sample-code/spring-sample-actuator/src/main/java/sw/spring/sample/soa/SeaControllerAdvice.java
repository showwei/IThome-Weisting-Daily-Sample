package sw.spring.sample.soa;

import org.springframework.web.bind.annotation.*;
import sw.spring.sample.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.ResponseData;
import sw.spring.sample.models.enums.ResponseStatusEnum;
import sw.spring.sample.soa.v1.ProductController;

@RestControllerAdvice(assignableTypes= {ProductController.class},basePackages = {"sw.spring.sample.soa" })
public class SeaControllerAdvice {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    ResponseData resourceNotFound(ResourceNotFoundException ex) {
        return new ResponseData().setCode(ResponseStatusEnum.RESOURCES_NOT_FOUND.getCode())
                                .setStatus(ResponseStatusEnum.RESOURCES_NOT_FOUND.getStatus())
                                .setData(ex.toString());
    }


    @ExceptionHandler(SeaFoodRetailerGenericException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    ResponseData retailerGenericException(SeaFoodRetailerGenericException ex) {
        return new ResponseData().setCode(ResponseStatusEnum.SERVICE_INTERNAL_ERROR.getCode())
                .setStatus(ResponseStatusEnum.SERVICE_INTERNAL_ERROR.getStatus())
                .setData(ex.toString());
    }


}
