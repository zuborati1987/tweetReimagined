package com.codecool.model;


import java.io.Serializable;
import java.util.Date;

public class Tweet implements Serializable {
    private String name;
    private String tweet;
    private Date timestamp;

    public Tweet(String name, String tweet) {
        this.name = name;
        this.tweet = tweet;
        this.timestamp = new Date(System.currentTimeMillis());
    }

    public String getName() {
        return name;
    }

    public String getTweet() {
        return tweet;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Tweet{" +
            "name='" + name + '\'' +
            ", tweet='" + tweet + '\'' +
            ", timestamp=" + timestamp +
            '}';
    }
}
