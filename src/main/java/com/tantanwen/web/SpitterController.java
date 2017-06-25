package com.tantanwen.web;

import static org.springframework.web.bind.annotation.RequestMethod.*;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tantanwen.data.Spitter;
import com.tantanwen.data.SpitterRepository;

/**
 * Created by dan on 2017/6/24.
 */
@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository){//一定要有个方法去实现这个IMPL
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register",method = GET)
    public String showRegistrationForm(){
        return "registerForm";
    }

    @RequestMapping(value = "/register",method = POST)
    public String processRegistration(
            @Valid Spitter spitter,
            Errors errors){
        System.out.println("username : "+spitter.getUsername());
        System.out.println("email : "+spitter.getEmail());
        System.out.println("lastname : "+spitter.getLastName());
        System.out.println("firstname : "+spitter.getFirstName());
        System.out.println("password : "+spitter.getPassword());
        System.out.println(errors.hasErrors());
        if(errors.hasErrors()){
            return  "registerForm";
        }
        spitterRepository.save(spitter);

        return "redirect:/spitter/"+spitter.getUsername();
    }

    @RequestMapping(value = "/{username}",method = GET)
    public String showSpitterProfile(@PathVariable String username,Model model){
        Spitter spitter = spitterRepository.findByUsername(username);
        model.addAttribute(spitter);
        return "profile";
    }
}
