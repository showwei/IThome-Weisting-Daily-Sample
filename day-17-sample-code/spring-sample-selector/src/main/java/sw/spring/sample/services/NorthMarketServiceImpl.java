package sw.spring.sample.services;

import org.springframework.stereotype.Service;
import sw.spring.sample.model.MarketMdl;

import java.util.ArrayList;
import java.util.List;

@Service("north")
public class NorthMarketServiceImpl implements MarketService{

    private static List<MarketMdl> marketMdls = new ArrayList<MarketMdl>();

    static {
        marketMdls.add(new MarketMdl().setName("Ningxia Market")
                .setDescription("at Taipei")
        );
        marketMdls.add(new MarketMdl().setName("Tourist  Market")
                .setDescription("at Taoyuan")
        );
        marketMdls.add(new MarketMdl().setName("Linjiang Market")
                .setDescription("at Taipei")
        );
    }


    @Override
    public List<MarketMdl> listMarketMdl() {
        return marketMdls;
    }

    @Override
    public void getMarketArea() {
        System.out.println( "Taiwan North" );
    }
}
