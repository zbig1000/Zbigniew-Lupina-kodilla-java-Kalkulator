package com.kodilla.testing.collection;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

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
        ArrayList<Integer> newArrayListTest = new ArrayList<Integer>();
        Assert.assertEquals(OddNumbersExterminator.exterminate(newArrayListTest), newArrayListTest);
    }


    @Test
    public void testOddNumbersExterminatorNormalList() {
        System.out.println("Testing NormalList");
        ArrayList<Integer> newArrayListTest = new ArrayList<Integer>();
        newArrayListTest.add(1);
        newArrayListTest.add(2);
        newArrayListTest.add(3);
        newArrayListTest.add(4);
        newArrayListTest.add(5);
        newArrayListTest.add(6);
        newArrayListTest.add(7);
        newArrayListTest.add(8);
        newArrayListTest.add(9);
        newArrayListTest.add(10);

        ArrayList<Integer> newArrayListResult = new ArrayList<Integer>();
        newArrayListResult.add(2);
        newArrayListResult.add(4);
        newArrayListResult.add(6);
        newArrayListResult.add(8);
        newArrayListResult.add(10);

        Assert.assertEquals(OddNumbersExterminator.exterminate(newArrayListTest), newArrayListResult);
    }


}
