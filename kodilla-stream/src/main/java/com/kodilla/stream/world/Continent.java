package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {
    private final List<Country> countryList = new ArrayList<>();

    public void addCountry(final Country country) {
        countryList.add(country);
    }
    public List<Country> getCountryList() {
        return countryList;
    }
}
