package com.kodilla.good.patterns.challenges;

import java.util.*;
import java.util.stream.Collectors;

public class MovieStore {

    public Map<String, List<String>> getMovies() {
        List<String> ironManTranslations = createTranslations("Iron Man", "Żelazny Człowiek");
        List<String> avengersTranslations = createTranslations("Avengers", "Mściciele");
        List<String> flashTranslations = createTranslations("Flash", "Błyskawica");

        return Map.of(
                "IM", ironManTranslations,
                "AV", avengersTranslations,
                "FL", flashTranslations
        );
    }

    private List<String> createTranslations(String... translations) {
        return Arrays.asList(translations);
    }

    void printMovies(Map<String, List<String>> movies) {
        String result = movies.values().stream()
                .flatMap(Collection::stream)
                .collect(Collectors.joining("!"));
        System.out.println(result);
    }

    public int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}