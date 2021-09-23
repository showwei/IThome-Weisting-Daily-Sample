package sw.spring.sample.model;

public class NoteBook {

    public NoteBook(String id, String name, String vendor, String descritpion) {
        this.id = id;
        this.name = name;
        this.vendor = vendor;
        this.descritpion = descritpion;
    }

    String id;
    String name;
    String vendor;
    String descritpion;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVendor() {
        return vendor;
    }

    public void setVendor(String vendor) {
        this.vendor = vendor;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }
}
