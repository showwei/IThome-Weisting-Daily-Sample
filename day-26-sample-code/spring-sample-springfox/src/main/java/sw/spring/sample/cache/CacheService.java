package sw.spring.sample.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import sw.spring.sample.models.SeaFood;

import java.util.concurrent.TimeUnit;

public class CacheService {
    public static final Cache<String, SeaFood> SEA_FOOD_CACHE_CHINESE =  CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build();;
    public static final Cache<String, SeaFood> SEA_FOOD_CACHE_TAIWAN =  CacheBuilder.newBuilder().expireAfterWrite(1, TimeUnit.DAYS).build();;

    static {

        SEA_FOOD_CACHE_CHINESE.asMap().putIfAbsent(
                "F-0001",
                new SeaFood()
                        .setId("F-0001")
                        .setDescription("Sturgeon is the common name for the 27 species of fish belonging to the family Acipenseridae..")
                        .setName("Sturgeon fish")
                        .setPrice(200));
        SEA_FOOD_CACHE_CHINESE.asMap().putIfAbsent(
                "C-0001",
                new SeaFood()
                        .setId("C-0001")
                        .setDescription("Is a medium-sized burrowing crab that is named for its furry claws.")
                        .setName("Hairy crabs")
                        .setPrice(300));
        SEA_FOOD_CACHE_CHINESE.asMap().putIfAbsent(
                "C-0002",
                new SeaFood()
                        .setId("C-0002")
                        .setDescription("Is a medium-sized burrowing crab that is named for its weisting claws.")
                        .setName("Weisting crabs")
                        .setPrice(1000));
    }


    static {

        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(
                "F-0001",
                new SeaFood()
                        .setId("F-0001")
                        .setDescription("Gold type for the Dragon fish.")
                        .setName("Dragon fish")
                        .setPrice(250));
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(
                "C-0001",
                new SeaFood()
                        .setId("C-0001")
                        .setDescription("A taxon of crab-like decapod crustaceans chiefly found in cold seas.")
                        .setName("King Crab")
                        .setPrice(300));
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(
                "C-0002",
                new SeaFood()
                        .setId("C-0002")
                        .setDescription("Opilio is the primary species referred to as snow crab.")
                        .setName("Snow Crab")
                        .setPrice(350));
    }
}
