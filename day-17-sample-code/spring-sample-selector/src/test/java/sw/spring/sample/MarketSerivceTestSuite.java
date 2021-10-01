package sw.spring.sample;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import sw.spring.sample.model.MarketMdl;
import sw.spring.sample.services.MarketService;

import java.text.MessageFormat;
import java.util.List;

public class MarketSerivceTestSuite extends ServiceTestBase {

    @Autowired
    private List<MarketService> marketServices;

    @Autowired
    private List<MarketMdl> marketMdls;

    @Autowired
    ApplicationContext context;

    @Test
    public void testBeanContent() {
        Assertions.assertTrue(context.containsBean("WeistingMarket"));
        Assertions.assertTrue(context.containsBean("JyunMarket"));
        marketMdls.forEach( marketMdl -> {
            System.out.println(MessageFormat.format("Name : {0} , Description : {1}", marketMdl.getName(),marketMdl.getDescription()));
        });
        System.out.println("Verify Weisting and Jyun Bean success.");
    }

    @Test
    public void testPrintMarketArea() {
        this.marketServices.forEach(MarketService::getMarketArea);
    }

    @Test
    public void testListMarket() {
        this.marketServices.forEach(marketService -> {
            assertEquals(marketService.listMarketMdl().size(),3);
            System.out.printf("%s verify market size success ! \r\n",marketService.getClass().getCanonicalName());
        });
    }
}
