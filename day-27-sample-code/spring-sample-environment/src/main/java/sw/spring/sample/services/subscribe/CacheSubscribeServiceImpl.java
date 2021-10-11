package sw.spring.sample.services.subscribe;

import com.google.gson.Gson;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import reactor.core.scheduler.Schedulers;
import sw.spring.sample.exception.SeaFoodRetailerGenericException;
import sw.spring.sample.models.SeaFood;

import reactor.core.publisher.*;
import sw.spring.sample.services.SeaFoodRetailerService;

import javax.annotation.PostConstruct;

@Service
public class CacheSubscribeServiceImpl implements CacheSubscribeService {

    Logger logger =  LoggerFactory.getLogger(CacheSubscribeServiceImpl.class);

    private static FluxSink<SeaFood> seaFoodSink;

    @Autowired
    @Qualifier("seaFoodRetailService")
    SeaFoodRetailerService taiwanSeaFoodRetailerService;


    @Autowired
    @Qualifier("chinaSeaFoodRetailService")
    SeaFoodRetailerService chinaSeaFoodRetailerService;

    @PostConstruct
    public void init() {
        Flux.<SeaFood>create(sink -> this.seaFoodSink = sink)
                .doOnNext(seaFood -> {
                    try {
                        taiwanSeaFoodRetailerService.createSeaFood(seaFood);
                        chinaSeaFoodRetailerService.createSeaFood(seaFood);
                    } catch (SeaFoodRetailerGenericException e) {
                        logger.error("Create Sea Food into all Place Fail. ex:" + e.toString());
                    }
                })
                .onErrorReturn(new SeaFood())
                .subscribeOn( Schedulers.elastic())
                .subscribe(seaFood -> {
                    System.out.println("Subscribe model : " + new Gson().toJson(seaFood));
                });

    }

    @Override
    public SeaFood subscribeAllLocationSeaFoodProducts(SeaFood seaFood) {
        seaFoodSink.next(seaFood);
        return seaFood;
    }

}
