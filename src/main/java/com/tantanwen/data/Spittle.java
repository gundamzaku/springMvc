package com.tantanwen.data;

import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;

import javax.validation.constraints.Null;
import java.util.Date;

/**
 * Created by dan on 2017/6/22.
 */
public class Spittle {

    private final Long id;
    private final String message;
    private final Date time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message,Date time){
        this(message,time,null,null);
    }

    public Spittle(String message,Date time,Double longitude,Double latitude){
        this.id = null;
        this.message = message;
        this.time = time;
        this.longitude =  longitude;
        this.latitude = latitude;;
    }

    public long getId(){
        return id;
    }

    public String getMessage(){
        return message;
    }

    public Date getTime(){
        return time;
    }

    public Double getLongitude(){
        return longitude;
    }

    public Double getLatitude(){
        return latitude;
    }

    @Override
    public boolean equals(Object that){
        return EqualsBuilder.reflectionEquals(this,that,new String[]{"id","time"});//new String("id"),new String("time")
    }

    @Override
    public int hashCode(){
        return HashCodeBuilder.reflectionHashCode(this,new String[]{"id","time"});
    }
}
