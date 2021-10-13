package sw.spring.sample.soa.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Endpoint(id = "memory")
public class MemoryMontorController {

    Runtime runtime = Runtime.getRuntime();

    @ReadOperation
    public Map<String, Object> getData() {
        Map<String, Object> map = new HashMap<>();
        map.put("available-processors", runtime.availableProcessors());
        map.put("free-memory", runtime.freeMemory());
        map.put("max-memory", runtime.maxMemory());
        map.put("total-memory", runtime.totalMemory());
        return map;
    }
}
