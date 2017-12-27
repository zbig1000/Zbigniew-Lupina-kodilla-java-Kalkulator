package com.kodilla.stream.world;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class WorldTestSuite {
    @Test
    public void testGetPeopleQuantity() {
        //Given
        World world = new World();
        Continent europe = new Continent();
        Continent america = new Continent();
        Continent asia = new Continent();

        europe.addCountry(new Country(new BigDecimal("40000000")));
        europe.addCountry(new Country(new BigDecimal("80000000")));
        europe.addCountry(new Country(new BigDecimal("60000000")));
        europe.addCountry(new Country(new BigDecimal("50000000")));

        america.addCountry(new Country(new BigDecimal("350000000")));
        america.addCountry(new Country(new BigDecimal("30000000")));
        america.addCountry(new Country(new BigDecimal("120000000")));

        asia.addCountry(new Country(new BigDecimal("1200000000")));
        asia.addCountry(new Country(new BigDecimal("1300000000")));
        asia.addCountry(new Country(new BigDecimal("150000000")));
        asia.addCountry(new Country(new BigDecimal("150000000")));

        world.addContinent(europe);
        world.addContinent(america);
        world.addContinent(asia);

        //When
        BigDecimal totalPeopleQuantity = world.getPeopleQuantity();

        //Then
        BigDecimal expectedTotalPeopleQuantity = new BigDecimal("3530000000");
        Assert.assertEquals(expectedTotalPeopleQuantity, totalPeopleQuantity);
    }
}
