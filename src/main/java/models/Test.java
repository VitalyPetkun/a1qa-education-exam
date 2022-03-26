package models;

import lombok.Data;

@Data
public class Test {

    private String testName;
    private String methodName;
    private String status;
    private String startTime;
    private String endTime;
    private String duration;
}
