package sw.spring.sample;


import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import sw.spring.sample.enums.LanguageEunm;
import sw.spring.sample.model.MovieCandidate;

import javax.annotation.Resource;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.websocket.Session;

import static org.junit.Assert.assertEquals;

public class MovieCandidateTestSuite extends ServiceTestBase {

    @Resource(name="MyLove",description="Get bean by beanName")
    MovieCandidate myLove;

    @Resource(name="GodzillaKong",type=MovieCandidate.class,description="Get GodzillaKong bean by beanName and class type")
    MovieCandidate godzillaKong;



    @Test
    public void testCandidateForMyLove() {
        assertEquals(myLove.getName(),"My Love");
        assertEquals(myLove.getLang(), LanguageEunm.CN);
        System.out.println("Get My Love Bean from Resource verify success");
    }


    @Test
    public void testCandidateForGodzillaKong() {
        assertEquals(godzillaKong.getName(),"Godzilla vs. Kong");
        System.out.println("Get GodzillaKong Bean from Resource verify success");
    }

}
