package com.kodilla.testing.forum.statistics;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class StatisticVendorTestSuite {
    @Test
    public void testCalculateStatistcsWithMock_0_Posts() {
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
    public void testCalculateStatisticsWithMock_1000_Posts() {
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
    public void testCalculateStatisticsWithMock_1000_Users() {
        //Given
        Statistics statisticsMock = mock(Statistics.class);
        ArrayList<String> names = new ArrayList<String>();
        names.addAll(Arrays.asList("Adam", "Bob", "Joe", "Hank", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a", "a", "a", "a", "a", "a","a", "a", "a", "a", "a" ));


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
        Assert.assertEquals(100, uNumber);
        Assert.assertEquals(100, pNumber);
        Assert.assertEquals(1000, cNumber);
        Assert.assertEquals(1d, avPostPerUser, 0.01d);
        Assert.assertEquals(10d, avCommentPerUser,0.01d);
        Assert.assertEquals(10d, avCommentPerPost, 0.01d);
    }
}
