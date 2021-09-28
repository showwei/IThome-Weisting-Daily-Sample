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

@Component("Google")
@Order(55)
public class GoogleIDEServiceImpl implements IDEService , ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("GoogleIDEServiceImpl init.");
    }

    public static List<IDEMdl> ideMdls = new ArrayList<IDEMdl>();

    static {
        ideMdls.add(new IDEMdl().setId("IDE-001")
                                .setName("Cloud Shell")
                                .setDescription("可讓開發者可以直接從瀏覽器，利用命令列存上雲端資源，" +
                                        "而現在Google推出新的Cloud Shell編輯器，透過線上開發環境強化Cloud " +
                                        "Shell功能，Cloud Shell編輯器是一個以Eclipse Theia IDE為基礎的程式碼編" +
                                        "輯環境"));
        ideMdls.add(new IDEMdl().setId("IDE-002")
                                .setName("Android Studio")
                                .setDescription("Android Studio 主要特色有以下幾點\n" +
                                        "支援不同載具(Phone、Pad、Android TV、Android Wear、Google Glass).\n" +
                                        "支援Gradle 專案建立\n" +
                                        "同個專案產生多樣化的多個APK檔案\n" +
                                        "提供更多的範本，方便開發者建置程式的基本功能\n" +
                                        "豐富的layout編輯工具以及更多的版面主題\n" +
                                        "提供Lint tools來偵測執行效能、可用性、版本相容性等\n" +
                                        "支援ProGuard及App簽署加密金鑰功能來保護程式碼內容"));

    }

    @Override
    public List<IDEMdl> listIDEModels() {
        return ideMdls ;
    }
}
