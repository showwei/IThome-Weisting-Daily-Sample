package sw.spring.model;

public class JohnWickMovieActor {
    String name;
    String description;
    Integer killCounter;

    public String getName() {
        return name;
    }

    public JohnWickMovieActor setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public JohnWickMovieActor setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getKillCounter() {
        return killCounter;
    }

    public JohnWickMovieActor setKillCounter(Integer killCounter) {
        this.killCounter = killCounter;
        return this;
    }
}
