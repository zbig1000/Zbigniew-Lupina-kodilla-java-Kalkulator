package com.kodilla.patterns.builder.bigmac;

import org.junit.Assert;
import org.junit.Test;

public class BigmacTestSuite {
    @Test
    public void testBigmacBuilderInitial() {
        //Given
        Bigmac bigmac = new Bigmac.BigmacBuilder()
                .roll(Bigmac.BigmacBuilder.SESAME)
                .burgers(2)
                .sauce(Bigmac.BigmacBuilder.BARBEQUE)
                .ingredient(Bigmac.BigmacBuilder.LETTUCE)
                .ingredient(Bigmac.BigmacBuilder.ONION)
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
                .ingredient(Bigmac.BigmacBuilder.BACKON)
                .ingredient(Bigmac.BigmacBuilder.CHAMPIGNON)
                .roll(Bigmac.BigmacBuilder.STANDARD)
                .burgers(1)
                .sauce(Bigmac.BigmacBuilder.STANDARD)
                .ingredient(Bigmac.BigmacBuilder.ONION)
                .build();
        System.out.println(bigmac.toString());

        //When
        String sauce = bigmac.getSauce();

        //Then
        Assert.assertEquals("STANDARD", sauce);
    }

}
