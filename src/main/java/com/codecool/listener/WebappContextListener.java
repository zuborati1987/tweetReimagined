package com.codecool.listener;

import com.codecool.service.TweetList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public final class WebappContextListener implements ServletContextListener {

    private TweetList tweetList = TweetList.getInstance();

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("This method is invoked once when the webapp gets deployed.");
        try {
            tweetList.loadTweetList("tweetlist.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("This method is invoked once when the webapp gets undeployed.");
        try {
            tweetList.saveTweetList(tweetList.getTweets(), sce.getServletContext().getRealPath("/") + "tweetlist.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
