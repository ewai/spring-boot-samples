package com.example.samples.web.form;

import java.io.Serializable;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

public class SampleForm  implements Serializable {

    private static final long serialVersionUID = 1L;

    //@NotEmpty
    //@Size(min = 4, max = 8)
    private String shouhinId;

    //@NotEmpty(message = "入力してちょ")
    private String shouhinName;

    public String getShouhinId() {
        return shouhinId;
    }

    public void setShouhinId(String shouhinId) {
        this.shouhinId = shouhinId;
    }

    public String getShouhinName() {
        return shouhinName;
    }

    public void setShouhinName(String shouhinName) {
        this.shouhinName = shouhinName;
    }

}
