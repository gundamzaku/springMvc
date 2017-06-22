package com.tantanwen.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 * Created by dan on 2017/6/22.
 */
@Controller
public class HomeController {

    @RequestMapping(value = "/",method = GET)
    public String home(){
        return "home";
    }
}
