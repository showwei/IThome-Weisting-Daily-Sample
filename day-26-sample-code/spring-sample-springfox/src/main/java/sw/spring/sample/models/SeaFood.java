package sw.spring.sample.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
@ApiModel(description = "海鮮模型")
public class SeaFood {
    @ApiModelProperty(value = "海鮮序號", required = true)
    String id;
    @ApiModelProperty(value = "海鮮名稱", required = true)
    String name;
    @ApiModelProperty(value = "海鮮敘述", required = true)
    String description;
    @ApiModelProperty(value = "海鮮價格", required = true)
    int price;

    public String getId() {
        return id;
    }

    public SeaFood setId(String id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public SeaFood setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public SeaFood setDescription(String description) {
        this.description = description;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public SeaFood setPrice(int price) {
        this.price = price;
        return this;
    }
}
