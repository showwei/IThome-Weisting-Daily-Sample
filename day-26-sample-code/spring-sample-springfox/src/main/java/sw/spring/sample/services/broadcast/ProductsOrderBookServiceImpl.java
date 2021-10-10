package sw.spring.sample.services.broadcast;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import reactor.core.publisher.FluxSink;
import reactor.core.publisher.ReplayProcessor;
import sw.spring.sample.models.SeaFood;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_CHINESE;
import static sw.spring.sample.cache.CacheService.SEA_FOOD_CACHE_TAIWAN;

@Service
public class ProductsOrderBookServiceImpl implements ProductsOrderBookService {

    ReplayProcessor<SeaFood> taiwanProductProcessor = null;
    ReplayProcessor<SeaFood> chinaProductProcessor = null;

    FluxSink<SeaFood> taiwanProductSink = null;
    FluxSink<SeaFood> chinaProductSink = null;
    @PostConstruct
    public void init() {
        this.taiwanProductProcessor = ReplayProcessor.create(3);
        this.taiwanProductSink = this.taiwanProductProcessor.sink();
        SEA_FOOD_CACHE_TAIWAN
                .asMap()
                .values()
                .stream()
                .forEach(seaFood -> taiwanProductSink.next(seaFood));
        this.chinaProductProcessor = ReplayProcessor.create(3);
        this.chinaProductSink = this.chinaProductProcessor.sink();
        SEA_FOOD_CACHE_CHINESE
                .asMap()
                .values()
                .stream()
                .forEach(seaFood -> chinaProductSink.next(seaFood));
    }

    @Override
    public List<SeaFood> getTaiwanOrderBook() {
        List<SeaFood> seaFoods = new ArrayList<SeaFood>();
        this.taiwanProductProcessor.subscribe(seaFood -> seaFoods.add(seaFood));
        return seaFoods;
    }

    @Override
    public List<SeaFood> getChinaOrderBook() {
        List<SeaFood> seaFoods = new ArrayList<SeaFood>();
        this.chinaProductProcessor.subscribe(seaFood -> seaFoods.add(seaFood));
        return seaFoods;
    }

    @Override
    public void publishTaiwanProduct(SeaFood seaFood) {
        this.taiwanProductSink.next(seaFood);
    }

    @Override
    public void publishChinaProduct(SeaFood seaFood) {
        this.chinaProductSink.next(seaFood);
    }
}
