package com.epam.altynbekova.airline.entity;

import java.util.List;

public class Airline {
    private String name;
    private List<Aircraft> aircraft;

    public Airline(){}

    public Airline(String name, List<Aircraft> aircraft) {
        this.name = name;
        this.aircraft = aircraft;
    }

    public String info()
    {
        StringBuilder info = new StringBuilder();
        info.append(String.format("%s Airline contains the following aircraft types:\n", this));
        for (Aircraft a:aircraft)
            info.append(String.format("%s\n", a));

        return info.toString();
    }

    public List<Aircraft> getAircraft() {
        return aircraft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airline)) return false;

        Airline airline = (Airline) o;

        if (!name.equals(airline.name)) return false;
        return getAircraft().equals(airline.getAircraft());

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + getAircraft().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return this.name+" has "+ this.aircraft.size() + " aircraft.";
    }
}
