package com.epam.altynbekova.airline.entity;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class Airline {
    private UUID uuid;
    private String name;
    private List<Aircraft> aircraft;

    public Airline() {
    }

    public Airline(UUID uuid, String name, List<Aircraft> aircraft) {
        this.uuid = uuid;
        this.name = name;
        this.aircraft = aircraft.stream().collect(Collectors.toList());
    }

    public String info() {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s Airline contains the following aircraft types:\n", this));
        for (Aircraft a : aircraft)
            info.append(String.format("%s\n", a));

        return info.toString();
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Airline airline = (Airline) o;

        return uuid.equals(airline.uuid);

    }

    @Override
    public int hashCode() {
        return uuid.hashCode();
    }

    @Override
    public String toString() {
        return this.name + " has " + this.aircraft.size() + " aircraft.";
    }
}
