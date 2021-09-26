package sw.project.sample;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import sw.project.sample.service.PhoneServcie;

import javax.annotation.Resource;

public class PhoneTestSuite extends ServiceTestBase {

    @Resource(name = "Android",type = PhoneServcie.class)
    PhoneServcie androidPhoneServcie;


    PhoneServcie applePhoneService = null;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testAndroidPhoneProductSizeTask() {
        assertEquals(androidPhoneServcie.listAllPhone().size(),6);
        System.out.println("Android vendor validate success.");
    }

    @Test
    public void testBlackBerryPhoneProductSizeTask( ) {
        PhoneServcie blackBerryPhoneService = applicationContext.getBean("BlackBerry",PhoneServcie.class);
        assertEquals(blackBerryPhoneService.listAllPhone().size(),2);
        System.out.println("Black Berry vendor with lazy loading validate success.");
    }

    @Test
    public void testApplePhoneProductSizeTask( ) {
        PhoneServcie applePhoneService = applicationContext.getBean(PhoneServcie.class);
        assertEquals(applePhoneService.listAllPhone().size(),6);
        System.out.println("Apple vendor with lazy loading validate success.");
    }

}
