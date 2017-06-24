package com.tantanwen.web;

import com.tantanwen.data.Spittle;
import com.tantanwen.data.SpittleRepository;
import com.tantanwen.data.SpittleRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by dan on 2017/6/23.
 */
@Controller
@RequestMapping("/spittles")
public class SpittleController {

    private SpittleRepository spittleRepository;
    //不知道为什么，右边用了Long.MAX_VALUE就报错了
    private static final String MAX_LONG_AS_STRING = "10000";

    @Autowired  //其实意思就是把SpittleRepository注入进来吧?(不加也可以正常注入）
    public SpittleController(SpittleRepository spittleRepository){

        this.spittleRepository = spittleRepository;

    }

    @RequestMapping(method = RequestMethod.GET)
    public String spittles(Model model){
        model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE,20));
        return "spittles";
    }
    /*
    @RequestMapping(method = RequestMethod.GET)
    public List<Spittle> spittles(

            @RequestParam(value = "max",defaultValue = MAX_LONG_AS_STRING) long max,
            @RequestParam(value = "count",defaultValue = "20") int count
    ){
        return spittleRepository.findSpittles(max,count);
    }*/

    @RequestMapping(value="/{spittleId}",method = RequestMethod.GET)
    public String showSpittle(
           @PathVariable("spittleId") int spittleId,Model model
           //@RequestParam("spittle_id") int spittleId,Model model
    ){
               model.addAttribute(spittleRepository.findOne(spittleId));
               return "spittle";
    }
}
