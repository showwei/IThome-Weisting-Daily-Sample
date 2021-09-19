package sw.sample.spring.model;


import java.util.List;
public class Chef {
    private Long id;
    private String name;
    private List<String> specialSkills;
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSpecialSkills() {
        return specialSkills;
    }

    public void setSpecialSkills(List<String> specialSkills) {
        this.specialSkills = specialSkills;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
