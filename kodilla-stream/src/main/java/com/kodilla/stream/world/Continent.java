package com.kodilla.stream.world;

import java.util.ArrayList;
import java.util.List;

public final class Continent {

    private final List<Country> countries = new ArrayList<>();

    public void addCountry(final Country country) {
        countries.add(country);
    }

    public void removeCountry(final Country country) {
        countries.remove(country);
    }

    public List<Country> getCountries() {
        return new ArrayList<>(countries);
    }
}