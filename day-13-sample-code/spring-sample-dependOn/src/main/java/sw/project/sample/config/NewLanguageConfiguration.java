package sw.project.sample.config;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import sw.project.sample.model.ProgramLangMdl;

import javax.annotation.PostConstruct;

@Configuration
@DependsOn("InterpretedLanguageService")
public class NewLanguageConfiguration  implements InitializingBean, DisposableBean {

    @PostConstruct
    public void init() {
        System.out.println("NewLanguageConfiguration initial after InterpretedLanguage.");
    }

    @Bean("GoBean")
    public ProgramLangMdl getProgramLangMdlWithGo() {
       return new ProgramLangMdl()
                .setId("id-005")
                .setName("GoLang")
                .setDescritpion("Go is an open source programming language that makes it easy to build simple, reliable, and efficient software.");
    }

    @Bean("LuaBean")
    @DependsOn("GoBean")
    public ProgramLangMdl getProgramLangMdlWithLua() {
        return new ProgramLangMdl()
                .setId("id-006")
                .setName("Lua")
                .setDescritpion("Lua is a lightweight, high-level, multi-paradigm programming language designed primarily for embedded use in applications. Lua is cross-platform, since the interpreter of compiled bytecode is written in ANSI C,[4] and Lua has a relatively simple C API to embed it into applications.");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("NewLanguageConfiguration is destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("NewLanguageConfiguration is afterPropertiesSet");
    }
}
