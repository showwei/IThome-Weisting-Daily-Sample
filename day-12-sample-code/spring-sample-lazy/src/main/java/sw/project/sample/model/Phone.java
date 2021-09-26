package sw.project.sample.model;

public class Phone {
    String name;
    String vendor;
    String description;

    public String getName() {
        return name;
    }

    public Phone setName(String name) {
        this.name = name;
        return this;
    }

    public String getVendor() {
        return vendor;
    }

    public Phone setVendor(String vendor) {
        this.vendor = vendor;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Phone setDescription(String description) {
        this.description = description;
        return this;
    }
}
