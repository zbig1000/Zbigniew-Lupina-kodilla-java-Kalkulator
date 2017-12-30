package com.kodilla.good.patterns.challenges;

public class InformationService implements InformationServiceInterface {
    @Override
    public void inform(User user) {
        System.out.println("User " + user.getName() + " informed..");
    }
}
