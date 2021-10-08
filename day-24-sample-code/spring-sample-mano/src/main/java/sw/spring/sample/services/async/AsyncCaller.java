package sw.spring.sample.services.async;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;
import sw.spring.sample.models.SeaFood;

import java.util.concurrent.Future;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_CHINESE;
import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_TAIWAN;

@Service
public class AsyncCaller {
    Logger logger = LoggerFactory.getLogger(AsyncCaller.class);
    @Async
    public Future<SeaFood> asyncSeaFoodWithReturnTypeFromTaiwan(String id) {
        System.out.println("Execute taiwan's async method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            SeaFood seaFood = SEA_FOOD_CACHE_TAIWAN.asMap().getOrDefault(id,null);
            return new AsyncResult<SeaFood>(seaFood);
        } catch (InterruptedException e) {
            logger.error("InterruptedException : {}",e.toString() );
        }

        return null;
    }


    @Async
    public Future<SeaFood> asyncSeaFoodWithReturnTypeFromChina(String id) {
        System.out.println("Execute china's async method asynchronously - "
                + Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
            SeaFood seaFood = SEA_FOOD_CACHE_CHINESE.asMap().getOrDefault(id,null);
            return new AsyncResult<SeaFood>(seaFood);
        } catch (InterruptedException e) {
            logger.error("InterruptedException : {}",e.toString() );
        }

        return null;
    }
}
