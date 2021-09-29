package sw.project.sample.model;

public class Animal {

    String name;
    String type;
    String Description;

    public String getName() {
        return name;
    }

    public Animal setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Animal setType(String type) {
        this.type = type;
        return this;
    }

    public String getDescription() {
        return Description;
    }

    public Animal setDescription(String description) {
        Description = description;
        return this;
    }
}
