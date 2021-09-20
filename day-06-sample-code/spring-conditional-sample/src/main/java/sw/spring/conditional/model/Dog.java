package sw.spring.conditional.model;

public class Dog extends Animal {

    public Dog() {}
    public Dog(String name, String type) {
        super(name, type);
    }

    String sound;

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }
}
