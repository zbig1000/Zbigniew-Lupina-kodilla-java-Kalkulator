package com.kodilla.good.patterns.challenges;

public class InformationServicePerformer implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("User " + user.getName() + " informed..");
    }
}
