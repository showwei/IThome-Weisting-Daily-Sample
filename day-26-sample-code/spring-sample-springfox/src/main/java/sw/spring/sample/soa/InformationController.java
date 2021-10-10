package sw.spring.sample.soa;

import com.google.gson.Gson;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sw.spring.sample.config.CompanyInformationConfig;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
@Api(tags = "SeaFood Retailer information")
@RestController
public class InformationController extends ControllerBase {

    @Value("${sea.food.company.version}")
    String version;

    @Autowired
    private CompanyInformationConfig config;

    @GetMapping(
            value="/about",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ApiOperation(value = "Returns WEISTING company information", notes = "Returns WEISTING company information.", response = Map.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a WEISTING company information ! ", response = Map.class),
            @ApiResponse(code = 400, message = "Sea food resource not found ! "),
            @ApiResponse(code = 500, message = "Internal server error") })
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
