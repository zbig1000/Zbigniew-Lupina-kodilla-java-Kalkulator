package com.kodilla.good.patterns.challenges;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;

public class MovieStoreTestSuiteTask {

    public Map<String, List<String>> prepareTestData() {
        List<String> ironManTranslations = new ArrayList<>();
        ironManTranslations.add("Żelazny Człowiek");
        ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
        avengersTranslations.add("Mściciele");
        avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
        flashTranslations.add("Błyskawica");
        flashTranslations.add("Flash");

        Map<String, List<String>> moviesWithTranslations = new HashMap<>();
        moviesWithTranslations.put("IM", ironManTranslations);
        moviesWithTranslations.put("AV", avengersTranslations);
        moviesWithTranslations.put("FL", flashTranslations);

        return moviesWithTranslations;
    }

    @Test
    public void testMovieStore() {
        // Given
        MovieStore movieStore = new MovieStore(prepareTestData());

        // When
        String movieList = movieStore.translationString();

        // Then
        String expectedResult = "Żelazny Człowiek!Iron Man!Mściciele!Avengers!Błyskawica!Flash";
        assertEquals(expectedResult, movieList);
    }
}

