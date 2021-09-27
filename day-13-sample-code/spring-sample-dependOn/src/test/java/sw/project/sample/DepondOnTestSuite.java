package sw.project.sample;

import com.google.gson.Gson;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import sw.project.sample.beans.ProgramLangService;
import sw.project.sample.model.ProgramLangMdl;

import javax.annotation.Resource;

public class DepondOnTestSuite extends ServiceTestBase {

    @Resource(name = "CompiledLanguageService",type = ProgramLangService.class)
    ProgramLangService compiledLanguage;

    @Autowired
    @Qualifier("LuaBean")
    ProgramLangMdl luaBean;

    @Qualifier("FutureLanguageService")
    @Autowired
    ProgramLangService futurePopLanguageService;

    @Test
    public void assertEqualsCompiledObjectTest() {
        ProgramLangMdl programLangMdl = compiledLanguage.getProgramLangMdl("id-001");
        assertEquals(programLangMdl.getId(),"id-001");
        assertEquals(programLangMdl.getName(),"Java");
        System.out.println("Get Compiled object test success.");
    }

    @Test
    public void assertEqualsLuaBeanObjectTest() {
        assertEquals(luaBean.getId(),"id-006");
        assertEquals(luaBean.getName(),"Lua");
        System.out.println("Get Bean object test success.");
    }

    @Test
    public void assertEqualsFuturePopLanguageServiceTest() {
        ProgramLangMdl programLangMdl = futurePopLanguageService.getProgramLangMdl("id-007");
        assertEquals(programLangMdl.getId(),"id-007");
        assertEquals(programLangMdl.getName(),"Deno");
        System.out.println("Get Bean object test success.");
    }

}
