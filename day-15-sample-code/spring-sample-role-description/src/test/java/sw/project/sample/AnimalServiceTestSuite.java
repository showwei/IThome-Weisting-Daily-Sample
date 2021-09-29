package sw.project.sample;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import sw.project.sample.services.BirdsAnimalServiceImpl;

import static org.junit.Assert.assertEquals;

public class AnimalServiceTestSuite extends ServiceTestBase {

    @Autowired
    GenericApplicationContext context;

    @Test
    public void testMammalsBeanCaseTestCase() {
        BeanDefinition beanDefinition = context.getBeanDefinition("MammalService");
        assertEquals(beanDefinition.getRole(), BeanDefinition.ROLE_APPLICATION);
        System.out.println("Bean Definition Role : " + (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION? "BeanDefinition.ROLE_APPLICATION" : "NULL"));
        assertEquals(beanDefinition.getDescription(),"Used for verify Mammals type animal.");
        System.out.println("Bean Definition Description : " + beanDefinition.getDescription());
        assertEquals(beanDefinition.getScope(),"singleton");
        System.out.println("Verify MammalsAnimalService's role and description success.");
    }

    @Test
    public void testBirdServiceBeanCaseTestCase() {
        BeanDefinition beanDefinition = context.getBeanDefinition("BirdService");
        assertEquals(beanDefinition.getRole(), BeanDefinition.ROLE_SUPPORT);
        assertEquals(beanDefinition.getDescription(),"Used for verify Birds type animal.");
        assertEquals(beanDefinition.getScope(),"singleton");
        System.out.println("Verify BirdService's role and description success.");
    }
}

