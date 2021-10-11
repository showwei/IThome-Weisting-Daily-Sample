package sw.spring.sample.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "書本資料")
public class ResponseData {
    @ApiModelProperty(value = "Http Status code ", required = true)
    int code;
    @ApiModelProperty(value = "Http status text", required = true)
    String status;
    @ApiModelProperty(value = "Error Message", required = true)
    Object Data;

    public int getCode() {
        return code;
    }

    public ResponseData setCode(int code) {
        this.code = code;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public ResponseData setStatus(String status) {
        this.status = status;
        return this;
    }

    public Object getData() {
        return Data;
    }

    public ResponseData setData(Object data) {
        Data = data;
        return this;
    }
}
