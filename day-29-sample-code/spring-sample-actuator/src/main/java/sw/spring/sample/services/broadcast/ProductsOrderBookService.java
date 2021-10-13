package sw.spring.sample.services.broadcast;

import reactor.core.publisher.FluxSink;
import reactor.core.publisher.ReplayProcessor;
import sw.spring.sample.models.SeaFood;

import java.util.List;

public interface ProductsOrderBookService {
    List<SeaFood> getTaiwanOrderBook();
    List<SeaFood> getChinaOrderBook();
    void publishTaiwanProduct(SeaFood seaFood);
    void publishChinaProduct(SeaFood seaFood);

}
