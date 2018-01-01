package com.kodilla.good.patterns.challenges;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStore {
    private  Map<String, List<String>> moviesWithTranslations;

    public MovieStore(Map<String, List<String>> moviesWithTranslations) {
        this.moviesWithTranslations = new HashMap<String, List<String>>(moviesWithTranslations);
    }

    public Map<String, List<String>> getMovies() {
        return new HashMap<String, List<String>>(moviesWithTranslations);
    }

    public String translationString() {
        return moviesWithTranslations.entrySet().stream().parallel()
                .map(entry -> entry.getValue())
                .flatMap(list -> list.stream())
                .collect(Collectors.joining("!", "", ""));
    }
}
