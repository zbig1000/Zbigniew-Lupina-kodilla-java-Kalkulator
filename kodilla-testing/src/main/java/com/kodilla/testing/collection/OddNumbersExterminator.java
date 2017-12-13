package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.*;

public class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        if (numbers.size() > 0) {
            for (Integer currentInteger : numbers) {
                if ((currentInteger % 2) == 0) {
                    newArrayList.add(currentInteger);
                }
            }
        }
        return newArrayList;
        }
}