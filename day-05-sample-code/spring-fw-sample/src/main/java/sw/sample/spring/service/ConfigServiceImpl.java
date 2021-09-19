package sw.sample.spring.service;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import sw.sample.spring.config.AppConfig;
import sw.sample.spring.model.Chef;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {

    Map<String,Object> beansContainer = null;

    @PostConstruct
    public void init() {
        ApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        beansContainer =  ctx.getBeansWithAnnotation(Bean.class);
    }

    @Override
    public Map<String,Object> getAllChef() {
        return beansContainer;
    }

    @Override
    public Long getIdByChef(String name) {
        return ((Chef)beansContainer.get(name)).getId();
    }

    @Override
    public String getNameByChef(String name) {
        return ((Chef)beansContainer.get(name)).getName();
    }

    @Override
    public String getRemarkByChef(String name) {
        return ((Chef)beansContainer.get(name)).getRemark();
    }

    @Override
    public List<String> getSpecialSkillsByChef(String name) {
        return ((Chef)beansContainer.get(name)).getSpecialSkills();
    }
}
