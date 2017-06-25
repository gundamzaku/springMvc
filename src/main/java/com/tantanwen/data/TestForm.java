package com.tantanwen.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

/**
 * Created by dan on 2016/12/23.
 */
public class TestForm {

    @NotNull(message = "noooooo")
    @Size(min=5, max=16, message="{testValue.size}")
    private String testValue;

    //private MultipartFile profilePicture;
    public TestForm() {}

    public TestForm(String testValue) {
        this.testValue = testValue
        ;
    }

    public String getTestValue() {
        return testValue;
    }

    public void setTestValue(String testValue) {
        this.testValue = testValue;
    }

}
