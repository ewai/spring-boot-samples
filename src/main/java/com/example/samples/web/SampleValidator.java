package com.example.samples.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.example.samples.service.ShouhinService;
import com.example.samples.web.form.SampleForm;

@Component
public class SampleValidator implements Validator {

    @Autowired
    ShouhinService shouhinService;

    @Override
    public boolean supports(Class<?> clazz) {
        return SampleValidator.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        SampleForm form = SampleForm.class.cast(target);
        if (StringUtils.isEmpty(form.getShouhinId())) {
            errors.reject("shouhinId", "入力してください。");
        }
        
    }

}
