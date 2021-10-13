package sw.spring.sample.soa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import sw.spring.sample.config.CompanyInformationConfig;
import sw.spring.sample.models.SeaFood;
import sw.spring.sample.models.enums.LocationEnum;
import sw.spring.sample.services.async.AsyncCaller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@CrossOrigin
@RequestMapping(value = "v1")
public class ControllerBase {

    @Autowired
    AsyncCaller asyncCaller;

    public SeaFood testAsyncAnnotationForMethodsWithReturnSeaFood(LocationEnum locationEnum,String id)
            throws InterruptedException, ExecutionException {
        System.out.println("Invoking an asynchronous method. "
                + Thread.currentThread().getName());

        Future<SeaFood> future = null;
        if (locationEnum == LocationEnum.TAIWAN)
            future = asyncCaller.asyncSeaFoodWithReturnTypeFromTaiwan(id);
        else
            future = asyncCaller.asyncSeaFoodWithReturnTypeFromChina(id);

        while (true) {
            if (future.isDone()) {
               return future.get();
            }
            System.out.println("Continue doing something else. Waiting... ");
            Thread.sleep(1000);
        }
    }

}
