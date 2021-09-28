package sw.project.sample.config;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import sw.project.sample.model.IDEMdl;

public class IDEBeanEntity implements ApplicationRunner {

    String id;
    String name;
    String description;

    public String getId() {
        return id;
    }

    public IDEBeanEntity setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public IDEBeanEntity setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public IDEBeanEntity setDescription(String description) {
        this.description = description;
        return this;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("IDEBeanEntity["+this.getId()+"] args assign and init.");
    }

    public void init() {
        System.out.println("DevC Bean["+this.getId()+"] is init.");
    }
    public IDEBeanEntity() {
        super();
        System.out.println("Build["+this.getId()+"] constructor");
    }
    public void destroy() {
        System.out.println("Method["+this.getId()+"] destroy");
    }
}
