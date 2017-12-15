package com.kodilla.testing.forum.statistics;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticVendorTestSuite {
    @Test
    public void testCalculateStatistcsWithMock_0_Posts() {
        // 0 posts
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(0);

        StatisticVendor statsVendor = new StatisticVendor();

        //When
        statsVendor.calculateAdvStatistics(statisticsMock);
        int uNumber = statsVendor.getUserNumber();
        int pNumber = statsVendor.getPostNumber();
        int cNumber = statsVendor.getCommentNumber();

        double avPostPerUser = statsVendor.getAveragePostNumberPerUser();
        double avCommentPerUser = statsVendor.getAverageCommentNumberPerUser();
        double avCommentPerPost = statsVendor.getAverageCommentNumberPerPost();

        //Then
        Assert.assertEquals(0, uNumber);
        Assert.assertEquals(0, pNumber);
        Assert.assertEquals(0, cNumber);
        Assert.assertEquals(0d, avPostPerUser, 0.01d);
        Assert.assertEquals(0d, avCommentPerUser,0.01d);
        Assert.assertEquals(0d, avCommentPerPost, 0.01d);
        }

    @Test
    public void testCalculateStatistcsWithMock_1000_Posts() {
        // 1000 posts
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticVendor statsVendor = new StatisticVendor();

        //When
        statsVendor.calculateAdvStatistics(statisticsMock);
        int uNumber = statsVendor.getUserNumber();
        int pNumber = statsVendor.getPostNumber();
        int cNumber = statsVendor.getCommentNumber();

        double avPostPerUser = statsVendor.getAveragePostNumberPerUser();
        double avCommentPerUser = statsVendor.getAverageCommentNumberPerUser();
        double avCommentPerPost = statsVendor.getAverageCommentNumberPerPost();

        //Then
        Assert.assertEquals(0, uNumber);
        Assert.assertEquals(1000, pNumber);
        Assert.assertEquals(0, cNumber);
        Assert.assertEquals(0d, avPostPerUser, 0.01d);
        Assert.assertEquals(0d, avCommentPerUser,0.01d);
        Assert.assertEquals(0d, avCommentPerPost, 0.01d);
    }

    @Test
    public void testCalculateStatistcsWithMock_0_Comments() {
        // 0 comments
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList("Adam"));

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(1);

        StatisticVendor statsVendor = new StatisticVendor();

        //When
        statsVendor.calculateAdvStatistics(statisticsMock);
        int uNumber = statsVendor.getUserNumber();
        int pNumber = statsVendor.getPostNumber();
        int cNumber = statsVendor.getCommentNumber();

        double avPostPerUser = statsVendor.getAveragePostNumberPerUser();
        double avCommentPerUser = statsVendor.getAverageCommentNumberPerUser();
        double avCommentPerPost = statsVendor.getAverageCommentNumberPerPost();

        //Then
        Assert.assertEquals(1, uNumber);
        Assert.assertEquals(1, pNumber);
        Assert.assertEquals(0, cNumber);
        Assert.assertEquals(1d, avPostPerUser, 0.01d);
        Assert.assertEquals(0d, avCommentPerUser,0.01d);
        Assert.assertEquals(0d, avCommentPerPost, 0.01d);
    }

    @Test
    public void testCalculateStatisticsWithMock_MoreCommentsThanPosts() {
        //  comments < posts
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList("Adam", "Bob", "Joe", "Hank"));

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.commentsCount()).thenReturn(1000);
        when(statisticsMock.postsCount()).thenReturn(100);

        StatisticVendor statsVendor = new StatisticVendor();

        //When
        statsVendor.calculateAdvStatistics(statisticsMock);
        int uNumber = statsVendor.getUserNumber();
        int pNumber = statsVendor.getPostNumber();
        int cNumber = statsVendor.getCommentNumber();

        double avPostPerUser = statsVendor.getAveragePostNumberPerUser();
        double avCommentPerUser = statsVendor.getAverageCommentNumberPerUser();
        double avCommentPerPost = statsVendor.getAverageCommentNumberPerPost();

        //Then
        Assert.assertEquals(4, uNumber);
        Assert.assertEquals(100, pNumber);
        Assert.assertEquals(1000, cNumber);
        Assert.assertEquals(25d, avPostPerUser, 0.01d);
        Assert.assertEquals(250d, avCommentPerUser,0.01d);
        Assert.assertEquals(10d, avCommentPerPost, 0.01d);
    }

    @Test
    public void testCalculateStatisticsWithMock_MorePostsThanComments() {
        //   posts < comments
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList("Adam", "Bob", "Joe", "Hank"));

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.commentsCount()).thenReturn(100);
        when(statisticsMock.postsCount()).thenReturn(1000);

        StatisticVendor statsVendor = new StatisticVendor();

        //When
        statsVendor.calculateAdvStatistics(statisticsMock);
        int uNumber = statsVendor.getUserNumber();
        int pNumber = statsVendor.getPostNumber();
        int cNumber = statsVendor.getCommentNumber();

        double avPostPerUser = statsVendor.getAveragePostNumberPerUser();
        double avCommentPerUser = statsVendor.getAverageCommentNumberPerUser();
        double avCommentPerPost = statsVendor.getAverageCommentNumberPerPost();

        //Then
        Assert.assertEquals(4, uNumber);
        Assert.assertEquals(1000, pNumber);
        Assert.assertEquals(100, cNumber);
        Assert.assertEquals(250d, avPostPerUser, 0.01d);
        Assert.assertEquals(25d, avCommentPerUser,0.01d);
        Assert.assertEquals(0.1d, avCommentPerPost, 0.01d);
    }

    @Test
    public void testCalculateStatisticsWithMock_100_Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();
        for (int i=0; i<100; i++) {
            names.add("a");
        }

        when(statisticsMock.usersNames()).thenReturn(names);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postsCount()).thenReturn(100);

        StatisticVendor statsVendor = new StatisticVendor();

        //When
        statsVendor.calculateAdvStatistics(statisticsMock);
        int uNumber = statsVendor.getUserNumber();
        int pNumber = statsVendor.getPostNumber();
        int cNumber = statsVendor.getCommentNumber();

        double avPostPerUser = statsVendor.getAveragePostNumberPerUser();
        double avCommentPerUser = statsVendor.getAverageCommentNumberPerUser();
        double avCommentPerPost = statsVendor.getAverageCommentNumberPerPost();

        //Then
        Assert.assertEquals(100, uNumber);
        Assert.assertEquals(100, pNumber);
        Assert.assertEquals(0, cNumber);
        Assert.assertEquals(1d, avPostPerUser, 0.01d);
        Assert.assertEquals(0, avCommentPerUser,0.01d);
        Assert.assertEquals(0, avCommentPerPost, 0.01d);
    }
}
