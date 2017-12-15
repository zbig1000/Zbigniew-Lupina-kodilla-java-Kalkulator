package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class CollectionTestSuite {

    @Before
    public void before(){
        System.out.println("Test Case: begin");
    }
    @After
    public void after(){
        System.out.println("Test Case: end");
    }

    @Test
    public void testOddNumbersExterminatorEmptyList() {
        System.out.println("Testing EmptyList");
        //Given
        ArrayList<Integer> newArrayListTest = new ArrayList<Integer>();
        //When
        ArrayList<Integer> resultArrayList = OddNumbersExterminator.exterminate(newArrayListTest);
        //Then
        Assert.assertEquals(newArrayListTest, resultArrayList);
    }


    @Test
    public void testOddNumbersExterminatorNormalList() {
        System.out.println("Testing NormalList");

        //Given

        ArrayList<Integer> newArrayListTest = new ArrayList<Integer>();
        newArrayListTest.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        ArrayList<Integer> newArrayListCorrectResult = new ArrayList<Integer>();
        newArrayListCorrectResult.addAll(Arrays.asList(2,4,6,8,10));

        //When
        ArrayList<Integer> ArrayListResult = OddNumbersExterminator.exterminate(newArrayListTest);
        //Then
        Assert.assertEquals(newArrayListCorrectResult, ArrayListResult);
    }


}
