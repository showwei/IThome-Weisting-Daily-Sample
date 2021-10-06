package sw.spring.sample.scheduled;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sw.spring.sample.models.SeaFood;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_TAIWAN;

@Component
public class SeaFoodScheduler {

    Logger logger = LoggerFactory.getLogger(SeaFoodScheduler.class);

    @Scheduled(initialDelay=1000L,fixedDelay = 10000L)
    public void triggerFixedDelaySeaFoodMethod () {
        logger.info("triggerFixedDelaySeaFoodMethod scheduler");
       SeaFood seaFood = new SeaFood()
                .setId("C-0011")
                .setDescription("Is a medium-sized burrowing crab that is named for its Busy claws.")
                .setName("Busy crabs");
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
    }


    @Scheduled(initialDelay=1000L,fixedRate=10000L)
    public void triggerFixedRateSeaFoodMethod () {
        logger.info("triggerFixedRateSeaFoodMethod scheduler");
        SeaFood seaFood = new SeaFood()
                .setId("C-0012")
                .setDescription("Is a medium-sized burrowing crab that is named for its Bubby claws.")
                .setName("Bubby crabs");
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
    }
    @Scheduled(initialDelay = 1000L,fixedRateString="${sea.food.company.scheduled.fixedRate}")
    public void triggerFixedRateSeaFoodMethodByConfig(){
        logger.info("triggerFixedRateSeaFoodMethodByConfig scheduler");
        SeaFood seaFood = new SeaFood()
                .setId("F-0012")
                .setDescription("Is a medium-sized burrowing crab that is named for its Shock Fish.")
                .setName("Shock Fish");
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
    }

    @Scheduled(fixedDelayString ="${sea.food.company.scheduled.fixedDelay}")
    public void triggerFixedDeleySeaFoodMethodByConfig () {
        logger.info("triggerFixedDeleySeaFoodMethodByConfig scheduler");
        SeaFood seaFood = new SeaFood()
                .setId("F-0013")
                .setDescription("Is a medium-sized burrowing crab that is named for its Baby Fish.")
                .setName("Baby Fish");
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
    }

    @Scheduled(cron="${sea.food.company.scheduled.cron}")
    public void triggerCronJobByConfig () {
        logger.info("triggerCronJobByConfig scheduler");
        SeaFood seaFood = new SeaFood()
                .setId("F-0014")
                .setDescription("Is a medium-sized burrowing crab that is named for its HAHA Fish.")
                .setName("HAHA Fish");
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(seaFood.getId(),seaFood);
    }
}
