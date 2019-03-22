package com.codecool.servlet;

import com.codecool.model.Tweet;
import com.codecool.service.TweetList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/new-tweet")
public class TweetSaver extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String tweet = req.getParameter("text");
        TweetList tweeter = TweetList.getInstance();
        List<Tweet> tweetList = tweeter.getTweets();
        tweetList.add(new Tweet(name, tweet));
        try {
            tweeter.saveTweetList(tweeter.getTweets(), "tweetlist.ser");
        } catch (IOException e) {
            e.printStackTrace();
        }
        req.setAttribute("tweetList", tweetList);
        req.getRequestDispatcher("tweets.jsp").forward(req, resp);

    }

}
