package com.kodilla.patterns.strategy.social;

import org.junit.Assert;
import org.junit.Test;

public class UserTestSuite {
    @Test
    public void testDefaultSharingStrategies() {
        //Given
        User stevenFacebook = new Millenials("Steven");
        User johnTwitter = new YGeneration("John");
        User zibiSnapchat = new ZGeneration("Zibi");

        //When
        String stevenFacebookPublisher = stevenFacebook.sharePost();
        System.out.println("Steven publisher: " + stevenFacebookPublisher);
        String johnTwitterPublisher = johnTwitter.sharePost();
        System.out.println("John publisher: " + johnTwitterPublisher);
        String zibiSnapchatPublisher = zibiSnapchat.sharePost();
        System.out.println("Zibi publisher: " + zibiSnapchatPublisher);

        //Then
        Assert.assertEquals("Facebook", stevenFacebookPublisher);
        Assert.assertEquals("Twitter", johnTwitterPublisher);
        Assert.assertEquals("Snapchat", zibiSnapchatPublisher);
    }

    @Test
    public void testIndividualSharingStrategy() {
        //Given
        User stevenFacebook = new Millenials("Steven");

        //When
        String stevenDefaultPublisher = stevenFacebook.sharePost();
        System.out.println("Steven publisher: " + stevenDefaultPublisher);

        stevenFacebook.setSocialPublisher(new TwitterPublisher());
        String stevenNewPublisher = stevenFacebook.sharePost();
        System.out.println("Steven new publisher: " + stevenNewPublisher);

        //Then
        Assert.assertEquals("Facebook", stevenDefaultPublisher);
        Assert.assertEquals("Twitter", stevenNewPublisher);
    }

}
