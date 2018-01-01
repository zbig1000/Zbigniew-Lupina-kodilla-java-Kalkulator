package com.kodilla.good.patterns.challenges;

public class InformationServiceImpl implements InformationService {
    @Override
    public void inform(User user) {
        System.out.println("User " + user.getName() + " informed..");
    }
}
