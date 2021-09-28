package sw.project.sample.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import sw.project.sample.model.IDEMdl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component("IBM")
@Order(55)
public class IBMIDEServiceImpl implements IDEService  , ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("IBMIDEServiceImpl init.");
    }

    public static List<IDEMdl> ideMdls = new ArrayList<IDEMdl>();

    static {
        ideMdls.add(new IDEMdl().setId("IDE-001")
                .setName("Eclipse")
                .setDescription("Eclipse是著名的跨平台開源整合式開發環境（IDE）。最初主要用來Java語言開發，" +
                        "目前亦有人通過外掛程式使其作為C++、Python、PHP等其他語言的開發工具。"));
        ideMdls.add(new IDEMdl().setId("IDE-002")
                .setName("RDi")
                .setDescription("以Eclipse開發工具為基礎，" +
                        "提供開發人員以類似Java開發環境的操作方式，" +
                        "開發大型主機上的應用程式，例如RPG程式。" +
                        "也能夠直接透過RDi連結AS/400，在同一個視窗中，" +
                        "進行主機檔案與程式結構的檢閱與管理。"));

    }

    @Override
    public List<IDEMdl> listIDEModels() {
        return ideMdls;
    }
}
