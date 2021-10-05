package sw.spring.sample.soa;

import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.spring.sample.config.CompanyInformationConfig;

import java.util.LinkedHashMap;
import java.util.Map;

@RestController
public class InformationController extends ControllerBase {

    @Value("${sea.food.company.version}")
    String version;

    @Autowired
    private CompanyInformationConfig config;

    @GetMapping(
            value="/about"
    )
    ResponseEntity<Map> seaFoodVersion() {
        Map<String,Object> informationMap = new LinkedHashMap<String, Object>();
        informationMap.put("version",version);
        informationMap.put("name",config.getName());
        informationMap.put("ceo",config.getCeo());
        informationMap.put("capital",config.getCapital());
        informationMap.put("address",config.getAddress());
        informationMap.put("uniformNumber",config.getUniformNumber());
        informationMap.put("createdDate",config.getCreatedDate());
        return new ResponseEntity<>(informationMap, HttpStatus.OK);

    }
}
