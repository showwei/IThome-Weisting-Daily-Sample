package sw.spring.sample.models.enums;

public enum ResponseStatusEnum {
    CREATED(201,"Sea Food created success!"),
    SUCCESS(200,"Sea Food retailer service success ! "),
    RESOURCES_NOT_FOUND(400,"Sea Food resource NOT FOUND!"),
    SERVICE_NOT_FOUND(404,"Sea Food retailer service NOT FOUND!"),
    SERVICE_INTERNAL_ERROR(503,"AH ! Oops ! Oops ! Sea Food retailer service is BROKEN ! BROKEN ! BROKEN !");



    int code;
    String status;
    ResponseStatusEnum(int code, String status) {
        this.code = code;
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
