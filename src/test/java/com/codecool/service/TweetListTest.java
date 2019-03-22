package com.codecool.service;

import com.codecool.model.Tweet;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertTrue;

class TweetListTest {

    private TweetList tweetList;
    private Tweet tweet;

    @BeforeEach
    void setUp() {
        tweetList = TweetList.getInstance();
        tweet = new Tweet("Attila", "You shouldn't see this!");
        tweetList.addTweet(tweet);
    }

    @AfterEach
    void tearDown() {
        tweetList = null;
        tweet = null;
    }

    @Test
    void addTweet() {
        tweetList.addTweet(tweet);
        assertTrue(tweetList.getTweets().contains(tweet));
    }
}

