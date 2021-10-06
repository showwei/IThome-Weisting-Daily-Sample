package sw.spring.sample.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import sw.spring.sample.models.SeaFood;

import java.util.concurrent.TimeUnit;

public class CacheService {
    public static final Cache<String, SeaFood> SEA_FOOD_CACHE_CHINESE =  CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();;
    public static final Cache<String, SeaFood> SEA_FOOD_CACHE_TAIWAN =  CacheBuilder.newBuilder().expireAfterWrite(5, TimeUnit.MINUTES).build();;

    static {

        SEA_FOOD_CACHE_CHINESE.asMap().putIfAbsent(
                "F-0001",
                new SeaFood()
                        .setId("F-0001")
                        .setDescription("Sturgeon is the common name for the 27 species of fish belonging to the family Acipenseridae..")
                        .setName("Sturgeon fish"));
        SEA_FOOD_CACHE_CHINESE.asMap().putIfAbsent(
                "C-0001",
                new SeaFood()
                        .setId("C-0001")
                        .setDescription("Is a medium-sized burrowing crab that is named for its furry claws.")
                        .setName("Hairy crabs"));
    }


    static {

        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(
                "F-0001",
                new SeaFood()
                        .setId("F-0001")
                        .setDescription("Gold type for the Dragon fish.")
                        .setName("Dragon fish"));
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(
                "C-0001",
                new SeaFood()
                        .setId("C-0001")
                        .setDescription("A taxon of crab-like decapod crustaceans chiefly found in cold seas.")
                        .setName("King Crab"));
        SEA_FOOD_CACHE_TAIWAN.asMap().putIfAbsent(
                "C-0002",
                new SeaFood()
                        .setId("C-0002")
                        .setDescription("Opilio is the primary species referred to as snow crab.")
                        .setName("Snow Crab"));
    }
}
