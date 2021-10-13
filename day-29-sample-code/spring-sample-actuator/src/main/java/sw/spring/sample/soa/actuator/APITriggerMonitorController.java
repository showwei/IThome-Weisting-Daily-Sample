package sw.spring.sample.soa.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static sw.spring.sample.cache.CacheService.SEA_FOOD_API_MONITOR_CACHE;

@Component
@Endpoint(id = "apiTriggerList")
public class APITriggerMonitorController {

    @ReadOperation
    public List<Object> getData() {
       return SEA_FOOD_API_MONITOR_CACHE.asMap().values().stream().collect(Collectors.toList());
    }
}

