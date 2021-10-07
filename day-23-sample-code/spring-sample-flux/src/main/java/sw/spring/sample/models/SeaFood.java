package sw.spring.sample.models;

public class SeaFood {
    String id;
    String name;
    String description;

    public String getId() {
        return id;
    }

    public SeaFood setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SeaFood setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SeaFood setDescription(String description) {
        this.description = description;
        return this;
    }
}
