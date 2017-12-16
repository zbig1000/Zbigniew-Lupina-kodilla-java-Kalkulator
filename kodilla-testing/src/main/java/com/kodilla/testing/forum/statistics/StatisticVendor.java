package com.kodilla.testing.forum.statistics;

import java.util.StringJoiner;

public class StatisticVendor {
    private int userNumber = 0;
    private int postNumber = 0;
    private int commentNumber = 0;

    private double averagePostNumberPerUser = 0d;
    private double averageCommentNumberPerUser = 0d;
    private double averageCommentNumberPerPost = 0d;

    public int getUserNumber() {
        return userNumber;
    }

    public int getPostNumber() {
        return postNumber;
    }

    public int getCommentNumber() {
        return commentNumber;
    }

    public double getAveragePostNumberPerUser() {
        return averagePostNumberPerUser;
    }

    public double getAverageCommentNumberPerUser() {
        return averageCommentNumberPerUser;
    }

    public double getAverageCommentNumberPerPost() {
        return averageCommentNumberPerPost;
    }



    public void calculateAdvStatistics(Statistics stats) {

        userNumber = stats.usersNames().size();
        postNumber = stats.postsCount();
        commentNumber = stats.commentsCount();

        if (userNumber > 0) {
            averagePostNumberPerUser = 1.0 * postNumber / userNumber;
            averageCommentNumberPerUser = 1.0 * commentNumber / userNumber;
        } else {
            averagePostNumberPerUser = 0d;
            averageCommentNumberPerUser = 0d;
        }

        if (postNumber > 0) {
            averageCommentNumberPerPost = 1.0 *commentNumber / postNumber;
        } else {
            averageCommentNumberPerPost = 0d;
        }
    }

    public String showStatistics() {
        StringJoiner stringJoiner = new StringJoiner(" ");

        stringJoiner.add("userNumber ");
        stringJoiner.add(new Integer(userNumber).toString());
        stringJoiner.add("postNumber ");
        stringJoiner.add(new Integer(postNumber).toString());
        stringJoiner.add("commentNumber ");
        stringJoiner.add(new Integer(commentNumber).toString());

        stringJoiner.add("averagePostNumberPerUser ");
        stringJoiner.add(new Double(averagePostNumberPerUser).toString());
        stringJoiner.add("averageCommentNumberPerUser ");
        stringJoiner.add(new Double(averageCommentNumberPerUser).toString());
        stringJoiner.add("averageCommentNumberPerPost ");
        stringJoiner.add(new Double(averageCommentNumberPerPost).toString());

        return stringJoiner.toString();
    }

}
