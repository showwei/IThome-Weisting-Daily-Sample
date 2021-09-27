package sw.project.sample.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;
import sw.project.sample.model.ProgramLangMdl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("CompiledLanguageService")
public class CompiledLangServiceImpl implements ProgramLangService, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("CompiledLangServiceImpl initial.");
    }

    private static List<ProgramLangMdl> programLangMdlList = new ArrayList<ProgramLangMdl>();

    static {
        programLangMdlList.add(
                new ProgramLangMdl()
                    .setId("id-001")
                    .setName("Java")
                    .setDescritpion("Java is a high-level, class-based, object-oriented programming language that is designed to have as few implementation dependencies as possible. It is a general-purpose programming language intended to let application developers write once, run anywhere (WORA),[17] meaning that compiled Java code can run on all platforms that support Java without the need for recompilation")
        );
        programLangMdlList.add(
                new ProgramLangMdl()
                        .setId("id-002")
                        .setName("C#")
                        .setDescritpion("C# is a general-purpose, multi-paradigm programming language. C# encompasses static typing, strong typing, lexically scoped, imperative, declarative, functional, generic, object-oriented (class-based), and component-oriented programming disciplines.")
        );
    }

    @Override
    public List<ProgramLangMdl> listProgramLangMdl() {
        return programLangMdlList;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("CompiledLanguageService is destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("CompiledLanguageService is afterPropertiesSet");

    }
}
