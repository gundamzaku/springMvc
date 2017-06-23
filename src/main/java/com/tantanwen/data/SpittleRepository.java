package com.tantanwen.data;

import java.util.List;

/**
 * Created by dan on 2017/6/22.
 */
public interface SpittleRepository {
    List<Spittle> findSpittles(long max,int count);
}
