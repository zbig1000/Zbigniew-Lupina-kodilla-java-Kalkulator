package com.kodilla.testing.collection;

import java.util.ArrayList;
import java.util.*;

public class OddNumbersExterminator {

    public static ArrayList<Integer> exterminate(ArrayList<Integer> numbers) {

        ArrayList<Integer> newArrayList = new ArrayList<Integer>();
        if (numbers.size() > 0) {
            Iterator<Integer> iteratorNumbers = numbers.iterator();

            while(iteratorNumbers.hasNext()){
                Integer currentInteger = iteratorNumbers.next();
                if ((currentInteger % 2) == 0) {
                    newArrayList.add(currentInteger);
                }
            }
            }
        return newArrayList;
        }
}