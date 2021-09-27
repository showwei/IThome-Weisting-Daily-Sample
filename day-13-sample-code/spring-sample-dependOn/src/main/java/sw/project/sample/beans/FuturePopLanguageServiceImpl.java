package sw.project.sample.beans;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import sw.project.sample.model.ProgramLangMdl;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service("FutureLanguageService")
@DependsOn({"LuaBean","GoBean"})
public class FuturePopLanguageServiceImpl implements ProgramLangService, InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("FuturePopLanguageServiceImpl initial after LuaBean,GoBean.");
    }

    private static List<ProgramLangMdl> programLangMdlList = new ArrayList<ProgramLangMdl>();

    static {
        programLangMdlList.add(
                new ProgramLangMdl()
                        .setId("id-007")
                        .setName("Deno")
                        .setDescritpion("Deno is a runtime for JavaScript and TypeScript that is based on the V8 JavaScript engine and the Rust programming language. It was created by Ryan Dahl, original creator of Node.js, and is focused on productivity.")
        );
        programLangMdlList.add(
                new ProgramLangMdl()
                        .setId("id-008")
                        .setName("Swift")
                        .setDescritpion("Swift is a general-purpose, multi-paradigm, compiled programming language developed by Apple Inc. and the open-source community. First released in 2014, Swift was developed as a replacement for Apple's earlier programming language Objective-C, as Objective-C had been largely unchanged since the early 1980s and lacked modern language features. Swift works with Apple's Cocoa and Cocoa Touch frameworks, and a key aspect of Swift's design was the ability to interoperate with the huge body of existing Objective-C code developed for Apple products over the previous decades. ")
        );
    }

    @Override
    public List<ProgramLangMdl> listProgramLangMdl() {
        return programLangMdlList;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("FutureLanguageService is destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FutureLanguageService is afterPropertiesSet");
    }
}
