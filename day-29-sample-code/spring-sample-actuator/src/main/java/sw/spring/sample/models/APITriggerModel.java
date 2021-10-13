package sw.spring.sample.models;

import java.util.Date;

public class APITriggerModel {
    Date time;
    String apiName;
    String triggerResult;

    public Date getTime() {
        return time;
    }

    public APITriggerModel setTime(Date time) {
        this.time = time;
        return this;
    }

    public String getApiName() {
        return apiName;
    }

    public APITriggerModel setApiName(String apiName) {
        this.apiName = apiName;
        return this;
    }

    public String getTriggerResult() {
        return triggerResult;
    }

    public APITriggerModel setTriggerResult(String triggerResult) {
        this.triggerResult = triggerResult;
        return this;
    }
}
