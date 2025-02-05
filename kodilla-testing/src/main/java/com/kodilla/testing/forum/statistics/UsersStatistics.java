package com.kodilla.testing.forum.statistics;

import java.util.List;

public class UsersStatistics {

    private int usersNumber;
    private int postsNumber;
    private int commentsNumber;
    private double avgPostsNumberPerUser;
    private double avgCommentsNumberPerUser;
    private double avgCommentsNumberPerPost;


    public int getUsersNumber() {
        return usersNumber;
    }

    public int getPostsNumber() {
        return postsNumber;
    }

    public int getCommentsNumber() {
        return commentsNumber;
    }

    public double getAvgPostsNumberPerUser() {
        return avgPostsNumberPerUser;
    }

    public double getAvgCommentsNumberPerUser() {
        return avgCommentsNumberPerUser;
    }

    public double getAvgCommentsNumberPerPost() {
        return avgCommentsNumberPerPost;
    }

    public void calculateAdvStatistics(Statistics statistics) {
        List<String> userNames = statistics.usersNames();
        usersNumber = userNames.size();
        postsNumber = statistics.postsCount();
        commentsNumber = statistics.commentsCount();

        avgPostsNumberPerUser = (usersNumber > 0 && postsNumber > 0) ? (double) postsNumber / usersNumber : 0;
        avgCommentsNumberPerUser = (commentsNumber > 0 && usersNumber > 0) ? (double) commentsNumber / usersNumber : 0;
        avgCommentsNumberPerPost = (commentsNumber > 0 && postsNumber > 0) ? (double) commentsNumber / postsNumber : 0;
    }
}