package sw.spring.sample.services;

import org.springframework.stereotype.Service;
import sw.spring.sample.model.MarketMdl;

import java.util.ArrayList;
import java.util.List;

@Service("south")
public class SouthMarketServiceImpl implements MarketService {

    private static List<MarketMdl> marketMdls = new ArrayList<MarketMdl>();

    static {
        marketMdls.add(new MarketMdl().setName("Flower Market")
                .setDescription("at Tainan")
        );
        marketMdls.add(new MarketMdl().setName("Ruifeng Market")
                .setDescription("at Kaohsiung")
        );
        marketMdls.add(new MarketMdl().setName("Teenager Market")
                .setDescription("at Kaohsiung")
        );
    }


    @Override
    public List<MarketMdl> listMarketMdl() {
        return marketMdls;
    }

    @Override
    public void getMarketArea() {

        System.out.println( "Taiwan South" );
    }
}
