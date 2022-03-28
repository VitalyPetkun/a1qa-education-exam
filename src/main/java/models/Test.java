package models;

import lombok.Data;

@Data
public class Test {

    private String duration;
    private String method;
    private String name;
    private String startTime;
    private String endTime;
    private String status;

    public Test () {}

    public Test(String name, String method) {
        this.name = name;
        this.method = method;
    }
}
