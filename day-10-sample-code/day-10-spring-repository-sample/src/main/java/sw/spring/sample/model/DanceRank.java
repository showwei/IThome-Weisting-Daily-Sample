package sw.spring.sample.model;

import org.springframework.util.Assert;

import javax.persistence.*;
import java.util.Random;

@Entity
@Table(name = "dancing_table")
public class DanceRank {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private int rank;

    private DanceRank() {
    }

    /* for testing */
    public DanceRank(Integer id, String name, int rank) {
        Assert.state(id != null && id > 0, () -> "the id should not be null");
        this.id = id;
        init((int)(new Random().nextInt(5000))*100,name, rank);
    }

    public DanceRank(String name, int rank) {
        init((int)(new Random().nextInt(5000))*100,name, rank);
    }

    private void init(int id ,String name, int rank) {
        Assert.isTrue(name.length() > 1, () -> "the name should have more than one character ");
        Assert.state(Character.isUpperCase(name.charAt(0)), () -> "the name should start with an uppercase!");
       // this.id = id;
        this.name = name;
        this.rank = rank;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }
}
