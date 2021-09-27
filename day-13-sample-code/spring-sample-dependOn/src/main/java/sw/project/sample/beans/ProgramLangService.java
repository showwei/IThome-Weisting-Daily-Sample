package sw.project.sample.beans;

import sw.project.sample.model.ProgramLangMdl;

import java.util.List;

public interface ProgramLangService {

    List<ProgramLangMdl> listProgramLangMdl();


    default ProgramLangMdl getProgramLangMdl(String id) {
        ProgramLangMdl entity = this.listProgramLangMdl()
                .stream()
                .filter(programLangMdl -> programLangMdl.getId().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);
        return entity;
    }
}
