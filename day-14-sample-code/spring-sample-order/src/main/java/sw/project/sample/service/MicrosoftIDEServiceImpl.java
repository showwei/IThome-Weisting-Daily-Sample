package sw.project.sample.service;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import sw.project.sample.model.IDEMdl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@Service("Microsoft")
@Order(555)
public class MicrosoftIDEServiceImpl implements IDEService , ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("MicrosoftIDEServiceImpl init.");
    }

    public static List<IDEMdl> ideMdls = new ArrayList<IDEMdl>();

    static {
        ideMdls.add(new IDEMdl().setId("IDE-001")
                .setName("Visual Studio Code")
                .setDescription("一款由微軟開發且跨平台的免費原始碼編輯器。" +
                        "該軟體支援語法突顯、代碼自動補全、代碼重構、檢視定義功能，" +
                        "並且內建了命令列工具和 Git 版本控制系統"));
        ideMdls.add(new IDEMdl().setId("IDE-002")
                .setName("Visual Studio ")
                .setDescription("「整合式開發環境」是一個有創意的啟動控制板，可供您編輯、偵錯及建置程式碼，" +
                        "然後發佈應用程式。 整合式開發環境 (IDE) 是功能豐富的程式，可用於軟體開發的許多方面。 " +
                        "除了大部分 IDE 提供的標準編輯器和偵錯工具之外，Visual Studio 還有編譯器、程式碼完成工具、" +
                        "圖形設計工具和更多功能，讓軟體開發程序變得更為容易"));
        ideMdls.add(new IDEMdl().setId("IDE-003")
                .setName("Sublime")
                .setDescription("一套跨平台的文字編輯器，支援基於Python的外掛程式。" +
                        "Sublime Text是專有軟體，可透過套件擴充功能。")
        );

    }

    @Override
    public List<IDEMdl> listIDEModels() {
        return ideMdls;
    }
}
