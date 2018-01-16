package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilderInitial() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(Bigmac.BigmacBuilder.Roll.SESAME)
                .burgers(2)
                .sauce(Bigmac.BigmacBuilder.Sauce.BARBEQUE)
                .ingredient(Bigmac.BigmacBuilder.Ingredients.LETTUCE)
                .ingredient(Bigmac.BigmacBuilder.Ingredients.ONION)
                .build();
        System.out.println(bigmac.toString());

        //When
        String sauce = bigmac.getSauce();

        //Then
        Assert.assertEquals("BARBEQUE", sauce);
    }

    @Test
    public void testBigmacBuilderRandomOrderParameters() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .ingredient(Bigmac.BigmacBuilder.Ingredients.BACKON)
                .ingredient(Bigmac.BigmacBuilder.Ingredients.CHAMPIGNON)
                .roll(Bigmac.BigmacBuilder.Roll.STANDARD)
                .burgers(1)
                .sauce(Bigmac.BigmacBuilder.Sauce.STANDARD)
                .ingredient(Bigmac.BigmacBuilder.Ingredients.ONION)
                .build();
        System.out.println(bigmac.toString());

        //When
        String sauce = bigmac.getSauce();

        //Then
        Assert.assertEquals("STANDARD", sauce);
    }

}
