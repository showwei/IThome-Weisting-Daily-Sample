package sw.spring.sample.model;

import java.util.ArrayList;
import java.util.List;

public class MarketMdl {
    String name;
    String description;

    public String getName() {
        return name;
    }

    public MarketMdl setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public MarketMdl setDescription(String description) {
        this.description = description;
        return this;
    }
}
