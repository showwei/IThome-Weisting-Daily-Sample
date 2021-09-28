package sw.project.sample.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import sw.project.sample.model.IDEMdl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("JetBrain")
@Order(5555)
public class JetBrainIDEServiceImpl implements IDEService  , ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("JetBrainIDEServiceImpl init.");
    }

    public static List<IDEMdl> ideMdls = new ArrayList<IDEMdl>();

    static {
        ideMdls.add(new IDEMdl().setId("IDE-001")
                .setName("IntelliJ IDEA")
                .setDescription("一種商業化銷售的Java整合式開發環境" +
                        "（Integrated Development Environment，IDE）工具軟體，" +
                        "由JetBrains軟體公司（前稱為IntelliJ）開發"));
        ideMdls.add(new IDEMdl().setId("IDE-002")
                .setName("WebStorm")
                .setDescription("an integrated development environment for JavaScript and related technologies." +
                        " Like other JetBrains IDEs"));
        ideMdls.add(new IDEMdl().setId("IDE-003")
                                .setName("PyCharm")
                                .setDescription("一個用於電腦編程的整合式開發環境，主要用於Python語言開發，" +
                                        "由捷克公司JetBrains開發，提供代碼分析、圖形化除錯器，整合測試器、" +
                                        "整合版本控制系統，並支援使用Django進行網頁開發。 PyCharm是一個跨平台開發環境，" +
                                        "擁有Microsoft Windows、macOS和Linux版本")
        );

    }

    @Override
    public List<IDEMdl> listIDEModels() {
        return ideMdls;
    }
}
