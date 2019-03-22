package com.codecool.service;


import com.codecool.model.Tweet;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TweetList implements Serializable {

    private static TweetList instance = new TweetList();
    private List<Tweet> tweets;

    private TweetList() {
        this.tweets = new ArrayList<>();
    }

    public void addTweet(Tweet tweet) {
        tweets.add(tweet);
    }

    public List<Tweet> getTweets() {
        return tweets;
    }

    public static TweetList getInstance() {
        return instance;
    }

    public void saveTweetList(List<Tweet> tweets, String filename) throws IOException {
        FileOutputStream fileOut = new FileOutputStream(filename);
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(tweets);
        out.close();
        fileOut.close();
    }

    @SuppressWarnings("unchecked")
    public void loadTweetList(String filename) throws IOException, ClassNotFoundException {
        FileInputStream fileIn = new FileInputStream(filename);
        ObjectInputStream in = new ObjectInputStream(fileIn);
        tweets = (List<Tweet>) in.readObject();
        in.close();
        fileIn.close();
    }
}
