package com.tantanwen.data;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by dan on 2017/6/23.
 */
@Component
public class SpittleRepositoryImpl implements SpittleRepository {
    List<Spittle> spittles = new ArrayList<Spittle>();
    @Override
    public List<Spittle> findSpittles(long max, int count) {

        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle" + i, new Date()));
        }
        return spittles;
    }

    public List<Spittle> findOne(int id) {
        List<Spittle> sp = new ArrayList<Spittle>();
        sp.add(new Spittle(spittles.get(id).getMessage(),spittles.get(id).getTime()));
        return sp;
    }
    /*
    public Spitter save(Spitter spitter){
        return spitter;
    }*/
}
