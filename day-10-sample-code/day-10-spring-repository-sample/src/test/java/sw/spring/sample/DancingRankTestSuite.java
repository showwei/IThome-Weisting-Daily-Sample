package sw.spring.sample;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sw.spring.sample.model.DanceRank;
import sw.spring.sample.service.DancingRankService;

import java.util.List;

public class DancingRankTestSuite extends ServiceTestBase{

    @Autowired
    DancingRankService noteBookSellerService;

    @Test
    public void testGetDanceRank() {
        DanceRank danceRanks = noteBookSellerService.getDanceRank("Two Steps From Hell - Victory");
        assertEquals(danceRanks.getName(),"Two Steps From Hell - Victory");
        System.out.println(new Gson().toJson(danceRanks));
        System.out.println(">> Verify spring JPA get by name SUCCESS ! ");
    }

    @Test
    public void testInsertDanceRank() {
        DanceRank danceRanks = noteBookSellerService.insertDanceRank(new DanceRank("Don Omar - Danza Kuduro | REMIX",2));
        System.out.println(new Gson().toJson(danceRanks));

        System.out.println(">> Verify spring JPA insert SUCCESS! ");
    }

    @Test
    public void testListAllDanceRank() {
        List<DanceRank> danceRankList = noteBookSellerService.listAllDanceRank();
        System.out.println(new Gson().toJson(danceRankList));

        System.out.println(">> Verify spring JPA Dance Rank List SUCCESS! ");
    }


}
