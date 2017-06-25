package com.tantanwen.data;

import com.tantanwen.data.SpitterRepository;
import org.springframework.stereotype.Component;

@Component
public class SpitterRepositoryImpl
        implements SpitterRepository {


    public Spitter save(Spitter spitter) {
        System.out.println("成功保存！");
        return spitter;
    }

    public Spitter findByUsername(String username) {
        Spitter spitter = new Spitter();
        //spitter.setUsername("liudan");
        //spitter.setFirstName("dan");
        //spitter.setEmail("gundamzaku@163.com");
        return spitter;
    }
}