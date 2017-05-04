package com.bibinet.finance.bean;

import java.io.Serializable;

/**
 * Created by bibinet on 2017-2-16.
 */
public class CompanyData implements Serializable {
    private String name;
    private String detail;
    private String time;

    public CompanyData(String name, String time, String detail) {
        this.name = name;
        this.time = time;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "CompanyData{" +
                "name='" + name + '\'' +
                ", detail='" + detail + '\'' +
                ", time='" + time + '\'' +
                '}';
    }
}
