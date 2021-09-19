package sw.sample.spring.service;

import sw.sample.spring.model.Chef;

import java.util.List;
import java.util.Map;

public interface ConfigService {
    Map<String,Object> getAllChef();
    Long getIdByChef(String name);
    String getNameByChef(String name);
    String getRemarkByChef(String name);
    List<String> getSpecialSkillsByChef(String name);
}
