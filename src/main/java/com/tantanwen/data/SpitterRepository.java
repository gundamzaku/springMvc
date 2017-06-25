package com.tantanwen.data;

/**
 * Created by dan on 2017/6/24.
 */
public interface SpitterRepository {
    Spitter save(Spitter spitter);
    Spitter findByUsername(String username);
}
