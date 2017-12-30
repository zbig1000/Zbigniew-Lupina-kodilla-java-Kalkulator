package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MovieStore {

    private  Map<String, List<String>> moviesWithTranslations;

    public MovieStore(Map<String, List<String>> moviesWithTranslations) {
        this.moviesWithTranslations = moviesWithTranslations;
    }

    public Map<String, List<String>> getMovies() {
        return moviesWithTranslations;
    }

    public String translationString() {
        if (!moviesWithTranslations.isEmpty())
        return this.getMovies().entrySet().stream().parallel()
                .map(entry -> entry.getValue())
                .flatMap(list -> list.stream())
                .collect(Collectors.joining("!", "", ""));
        else return "";
    }
}
