package sw.spring.sample.services.actuator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import sw.spring.sample.config.CompanyInformationConfig;

import java.util.LinkedHashMap;
import java.util.Map;

@Component
public class SeaFoodInfoContributor implements InfoContributor {
    @Value("${sea.food.company.version}")
    String version;

    @Autowired
    private CompanyInformationConfig config;

    @Override
    public void contribute(Info.Builder builder) {
        Map<String,Object> informationMap = new LinkedHashMap<String, Object>();
        informationMap.put("system_version",version);
        informationMap.put("name",config.getName());
        informationMap.put("contact",config.getContact());
        informationMap.put("description",config.getDescription());
        informationMap.put("ceo",config.getCeo());
        informationMap.put("capital",config.getCapital());
        informationMap.put("address",config.getAddress());
        informationMap.put("uniform_number",config.getUniformNumber());
        informationMap.put("created_date",config.getCreatedDate());

        builder.withDetail("app", informationMap);
    }
}
