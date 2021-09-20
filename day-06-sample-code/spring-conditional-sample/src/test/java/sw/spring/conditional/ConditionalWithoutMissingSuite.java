package sw.spring.conditional;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import sw.spring.conditional.model.Dog;
import sw.spring.conditional.model.Turtle;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Hashtable;
import java.util.Properties;

public class ConditionalWithoutMissingSuite extends ServiceTestBase {

    @Qualifier("Pomeranian")
    @Autowired
    Dog sasaDog;


    @Qualifier("TBaby")
    @Autowired
    Turtle turtle;

    @Qualifier("husky")
    @Autowired
    Dog husky;

    @Qualifier("Bernard")
    @Autowired
    Turtle bernard;

    @Qualifier("schnauzer")
    @Autowired
    Dog schnauzer;

    @Qualifier("dylan")
    @Autowired
    Dog dylan;

    @Qualifier("resource")
    @Autowired
    Dog resource;

    @Qualifier("robert")
    @Autowired
    Dog robert;

    @Qualifier("machine")
    @Autowired
    Dog machine;

    @Qualifier("JPA-Repository")
    @Autowired
    Turtle jpaRepository;

    @Qualifier("war")
    @Autowired
    Dog war;

    @Test
    public void validateConditionalOnBean() {
        assertEquals(sasaDog.getName(),"Pomeranian");
        System.out.println(" | >> Validate conditional on bean success ! ");

    }

    @Test
    public void validateOSTypeCondition() {
        assertEquals(machine.getName(),"machine");
        System.out.println(" | >> Validate OS type condition success ! ");

    }

    @Test
    public void validateConditionalOnClass() {
        assertEquals(turtle.getName(),"TBaby");
        System.out.println(" | >> Validate conditional on class success! ");
    }


    @Test
    public void validateConditionalOnWebApplication() {
        assertEquals(husky.getName(),"husky");
        System.out.println(" | >> Validate conditional on WebApplication success! ");

    }

    @Test
    public void validateConditionalOnProperty() {
        assertEquals(bernard.getName(),"Bernard");
        System.out.println(" | >> Validate conditional on Property success ! ");
    }


    @Test
    public void validateConditionalOnJava() {
        assertEquals(schnauzer.getName(),"schnauzer");
        System.out.println(" | >> Validate conditional On Java success ! ");
    }

    @Test
    public void validateConditionalOnExpression() {
        assertEquals(dylan.getName(),"dylan");
        System.out.println(" | >> Validate conditional on Expression success ! ");
    }

    @Test
    public void validateConditionalOnResource() {
        assertEquals(resource.getName(),"resource");
        System.out.println(" | >> Validate conditional on resource success ! ");
    }

    @Test
    public void validateConditionalOnSingleCandidate() {
        assertEquals(robert.getName(),"robert");
        System.out.println(" | >> Validate conditional on single candidate success ! ");
    }

    @Test
    public void validateConditionalOnRepositoryType() {
        assertEquals(jpaRepository.getName(),"JPA-Repository");
        System.out.println(" | >> Validate conditional on repository type success ! ");
    }

    @Test
    public void validateConditionalOnWarDeployment() {

        assertEquals(war.getName(),"war");
        System.out.println(" | >> Validate conditional on war deployment success ! ");
    }
}
