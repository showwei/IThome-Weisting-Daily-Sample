package sw.project.sample.service;

import sw.project.sample.model.IDEMdl;

import java.util.List;

public interface IDEService {

    List<IDEMdl> listIDEModels();

    default IDEMdl getIDEMdlById(String id) {
        return this.listIDEModels()
                .stream()
                .filter(ideMdl1 -> ideMdl1.getId().equalsIgnoreCase(id))
                .findAny()
                .orElse(null);

    }

}
