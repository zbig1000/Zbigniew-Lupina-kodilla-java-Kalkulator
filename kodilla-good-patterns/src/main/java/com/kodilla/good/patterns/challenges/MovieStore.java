package com.kodilla.good.patterns.challenges;

import java.util.List;
import java.util.Map;

public class MovieStore {

    private  Map<String, List<String>> moviesWithTranslations;

    public MovieStore(Map<String, List<String>> moviesWithTranslations) {
        this.moviesWithTranslations = moviesWithTranslations;
    }

    public Map<String, List<String>> getMovies() {
        return moviesWithTranslations;
    }
}
