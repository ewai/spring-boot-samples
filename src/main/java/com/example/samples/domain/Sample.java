package com.example.samples.domain;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SAMPLE")
public class Sample implements Serializable {

    private static final long serialVersionUID = 1L;
 
    @Id
    private String testId;
    private String testValue;

    public String getTestId() {
        return testId;
    }
    public void setTestId(String testId) {
        this.testId = testId;
    }
    public String getTestValue() {
        return testValue;
    }
    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }
}
