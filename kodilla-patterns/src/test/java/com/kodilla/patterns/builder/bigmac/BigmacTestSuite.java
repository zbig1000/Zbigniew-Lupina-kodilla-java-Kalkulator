package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilderInitial() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(Bigmac.Roll.SESAME)
                .burgers(2)
                .sauce(Bigmac.Sauce.BARBEQUE)
                .ingredient(Bigmac.Ingredients.LETTUCE)
                .ingredient(Bigmac.Ingredients.ONION)
                .build();
        System.out.println(bigmac.toString());

        //When
        String sauce = bigmac.getSauce().toString();

        //Then
        Assert.assertEquals("BARBEQUE", sauce);
    }

    @Test
    public void testBigmacBuilderRandomOrderParameters() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Bigmac.Ingredients.BACKON)
                .ingredient(Bigmac.Ingredients.CHAMPIGNON)
                .roll(Bigmac.Roll.STANDARD)
                .burgers(1)
                .sauce(Bigmac.Sauce.STANDARD)
                .ingredient(Bigmac.Ingredients.ONION)
                .build();
        System.out.println(bigmac.toString());

        //When
        String sauce = bigmac.getSauce().toString();

        //Then
        Assert.assertEquals("STANDARD", sauce);
    }

}
