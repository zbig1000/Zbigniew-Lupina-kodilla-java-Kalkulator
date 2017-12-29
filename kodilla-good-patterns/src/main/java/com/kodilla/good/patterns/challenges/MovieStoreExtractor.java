package com.kodilla.good.patterns.challenges;

import java.util.stream.Collectors;

public class MovieStoreExtractor {

    public static void main(String args[]) {

        MovieStore movieStore = new MovieStore();

        String movieList = movieStore.getMovies().entrySet().stream()
                .map(entry -> entry.getValue())
                .flatMap(list -> list.stream())
                .collect(Collectors.joining("!","" ,""));

        System.out.println(movieList);
    }
}
