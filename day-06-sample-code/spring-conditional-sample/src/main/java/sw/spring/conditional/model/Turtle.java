package sw.spring.conditional.model;

public class Turtle extends Animal {
    String behavior;
    public Turtle(){}

    public Turtle(String name, String type) {
        super(name, type);
    }

    public String getBehavior() {
        return behavior;
    }

    public void setBehavior(String behavior) {
        this.behavior = behavior;
    }
}
