package com.codecool.listener;

import com.codecool.service.TweetList;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.IOException;

@WebListener
public final class WebappContextListener implements ServletContextListener {

    private TweetList tweetList = TweetList.getInstance();
    private String homeDir = System.getenv("CATALINA_HOME");
    private String directory = homeDir + "/webapps/";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("This method is invoked once when the webapp gets deployed.");
        try {
            tweetList.loadTweetList(directory + "tweetlist.ser");
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("This method is invoked once when the webapp gets undeployed.");
        try {
            tweetList.saveTweetList(tweetList.getTweets(), directory + "tweetlist.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
