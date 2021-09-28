package sw.project.sample;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sw.project.sample.config.IDEBeanEntity;
import sw.project.sample.model.IDEMdl;
import sw.project.sample.service.IDEService;

import static org.junit.Assert.assertEquals;

public class IDETestSuite extends ServiceTestBase{

    @Autowired
    @Qualifier("IBM")
    IDEService ideService;


    @Qualifier("DevC")
    @Autowired
    IDEBeanEntity devCBean;


    @Test
    public void testIBMIDEServiceImpl() {
        IDEMdl entity = ideService.getIDEMdlById("IDE-001");
        assertEquals(entity.getName(),"Eclipse");
        assertEquals(entity.getId(),"IDE-001");
        System.out.println("IBM IDE Service verify success ! ");
    }

    @Test
    public void testDevCBean() {
        assertEquals(devCBean.getName(),"DEV-C++");
        assertEquals(devCBean.getId(),"ID-001");
        System.out.println("Dev C Bean verify success ! ");
    }

}
