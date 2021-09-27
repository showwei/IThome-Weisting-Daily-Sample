package sw.project.sample.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import sw.project.sample.model.ProgramLangMdl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("InterpretedLanguageService")
@DependsOn("CompiledLanguageService")
public class InterpretedLanguServiceImpl implements ProgramLangService, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("InterpretedLanguServiceImpl initial after CompiledLanguage.");
    }

    private static List<ProgramLangMdl> programLangMdlList = new ArrayList<ProgramLangMdl>();

    static {
        programLangMdlList.add(
                new ProgramLangMdl()
                        .setId("id-003")
                        .setName("PHP")
                        .setDescritpion("PHP is a popular general-purpose scripting language that is especially suited to web development.\n" +
                                "\n" +
                                "Fast, flexible and pragmatic, PHP powers everything from your blog to the most popular websites in the world.")
        );
        programLangMdlList.add(
                new ProgramLangMdl()
                        .setId("id-002")
                        .setName("JavaScript")
                        .setDescritpion("JavaScript , often abbreviated as JS, is a programming language that conforms to the ECMAScript specification.[10] JavaScript is high-level, often just-in-time compiled, and multi-paradigm. It has curly-bracket syntax, dynamic typing, prototype-based object-orientation, and first-class functions.")
        );
    }

    @Override
    public List<ProgramLangMdl> listProgramLangMdl() {
        return programLangMdlList;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("InterpretedLanguageService is destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("InterpretedLanguageService is afterPropertiesSet");
    }
}
