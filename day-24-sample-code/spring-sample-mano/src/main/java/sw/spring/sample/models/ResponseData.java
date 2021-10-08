package sw.spring.sample.models;

public class ResponseData {
    int code;
    String status;
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
