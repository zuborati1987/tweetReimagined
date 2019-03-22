package com.codecool.servlet;

import com.codecool.model.Tweet;
import com.codecool.service.TweetList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

@WebServlet("/filter")
public class Tweetfilter extends HttpServlet {
    private final Date allDates = new Date(1);


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Tweet> tweetList = TweetList.getInstance().getTweets();
        List<Tweet> tempList = new ArrayList<>();
        List<Tweet> resultList = new ArrayList<>();
        Date date;


        for (Tweet tweet : tweetList) {
            tempList.add(tweet);
        }

        System.out.println(tempList.size());

        int limit = Integer.parseInt(req.getParameter("limit"));
        int offset = Integer.parseInt(req.getParameter("offset"));
        String poster = req.getParameter("poster");
        String dateString = req.getParameter("date");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm");

        try {
            date = sdf.parse(dateString);
        } catch (ParseException e) {
            date = allDates;
        }


        Iterator twitterator = tempList.iterator();
        while (twitterator.hasNext()) {
            Tweet currTweet = (Tweet) twitterator.next();
            if ((!(poster.equals("")) && !(currTweet.getName().equals(poster))) || ((currTweet.getTimestamp().compareTo(date) < 0) && (date != null))) {
                System.out.println("Poster is: " + poster);
                twitterator.remove();
                System.out.println(tempList.size());
            }
        }

        for (int i = offset; i < (limit + i); i++) {
            if (i == tempList.size()) {
                break;
            } else {
                resultList.add(tempList.get(i));
                System.out.println("added" + i);
            }
        }

        req.setAttribute("tweetList", resultList);
        req.getRequestDispatcher("tweets.jsp").forward(req, resp);

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Tweet> tweetList = TweetList.getInstance().getTweets();
        request.setAttribute("tweetList", tweetList);
        request.getRequestDispatcher("tweets.jsp").forward(request, response);
    }
}
