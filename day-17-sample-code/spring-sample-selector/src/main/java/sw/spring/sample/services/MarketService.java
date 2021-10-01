package sw.spring.sample.services;

import sw.spring.sample.model.MarketMdl;

import java.util.List;

public interface MarketService {
    List<MarketMdl> listMarketMdl();
    default MarketMdl getMarketMdlByName(String name) {
        return this.listMarketMdl()
                .stream()
                .filter(marketMdl -> marketMdl.getName().equalsIgnoreCase(name))
                .findAny()
                .orElse(null);
    }

    void getMarketArea();
}
