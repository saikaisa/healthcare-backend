package top.saikaisa.healthcarebackend.model.request;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserHealthDataRequest implements Serializable {
    // 生成序列化 id
    private static final long serialVersionUID = 7813736772458864278L;

    private String steps;
    private String calories;
    private String exerciseTime;
    private String sleepDuration;
    private String sleepStartTime;
    private String sleepEndTime;
    private String heartRate;
    private String bloodOxygen;
    private String bloodPressure;
}
