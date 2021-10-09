package sw.spring.sample.models;

public class SeaFood {
    String id;
    String name;
    String description;
    int price;

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

    public int getPrice() {
        return price;
    }

    public SeaFood setPrice(int price) {
        this.price = price;
        return this;
    }
}
