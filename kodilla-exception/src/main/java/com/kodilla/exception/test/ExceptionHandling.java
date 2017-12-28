package com.kodilla.exception.test;

import com.kodilla.exception.io.FileReaderException;

import java.util.stream.Stream;

public class ExceptionHandling {
    public static void main(String args[]){

        SecondChallenge secondChallenge = new SecondChallenge();
        String result = null;
        try {
            result = secondChallenge.probablyIWillThrowException(2.5, 2d);
        }
        catch (Exception e) {
            System.out.println("Exception occurred in probablyIWillThrowException "+e);
        }
        finally {
            if (result == null) result = "Operation unsuccessful";
        }
        System.out.println("result "+ result);
    }
}
