package com.kodilla.testing.forum.statistics;

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
            averagePostNumberPerUser = postNumber / userNumber;
            averageCommentNumberPerUser = commentNumber / userNumber;
        }
        if (postNumber > 0) {
            averageCommentNumberPerPost = 1.0 *commentNumber / postNumber;
        }
    }

    public String showStatistics() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("userNumber ");
        stringBuilder.append(userNumber);
        stringBuilder.append(" ");
        stringBuilder.append("postNumber ");
        stringBuilder.append(postNumber);
        stringBuilder.append(" ");
        stringBuilder.append("commentNumber ");
        stringBuilder.append(commentNumber);
        stringBuilder.append(" ");

        stringBuilder.append("averagePostNumberPerUser ");
        stringBuilder.append(averagePostNumberPerUser);
        stringBuilder.append(" ");
        stringBuilder.append("averageCommentNumberPerUser ");
        stringBuilder.append(averageCommentNumberPerUser);
        stringBuilder.append(" ");
        stringBuilder.append("averageCommentNumberPerPost ");
        stringBuilder.append(averageCommentNumberPerPost);
        stringBuilder.append(" ");

        return stringBuilder.toString();
    }

}
