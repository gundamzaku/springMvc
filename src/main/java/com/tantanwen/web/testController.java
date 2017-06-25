package com.tantanwen.web;


import javax.validation.Valid;

import com.tantanwen.data.TestForm;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by dan on 2017/6/25.
 */
@Controller
@RequestMapping("/test")
public class testController extends WebMvcConfigurerAdapter {

    @RequestMapping(value = "/form",method = RequestMethod.GET)
    public String showTestForm(TestForm test){
        return "test/testForm";
    }

    @RequestMapping(value = "/form",method = RequestMethod.POST)
    public String processTest(
            @Valid TestForm test,
            BindingResult errors){
        System.out.println(test.getTestValue());
        System.out.println(errors.hasErrors());
        if(errors.hasErrors()){
            return  "test/testForm";
        }

        return "redirect:/test/done";
    }

    @RequestMapping(value = "/done",method = RequestMethod.GET)
    public String doneTestForm(){
        return "test/done";
    }
}
