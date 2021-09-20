package sw.spring.conditional.model;

public class Cat extends Animal {

    String sound;

    public Cat() {
    }

    public Cat(String name, String type) {
        super(name, type);
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
