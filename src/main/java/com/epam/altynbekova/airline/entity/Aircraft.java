package com.epam.altynbekova.airline.entity;

import java.util.UUID;

public class Aircraft implements Comparable<Aircraft> {
    private UUID uuid;
    private String modelName;
    private double rangeInKm;
    /**
     * Fuel consumption in kilogram per hour (kg/hr)
     */
    private double consumption;

    public Aircraft() {
    }

    public Aircraft(UUID uuid, String modelName, double range, double consumption) {
        this.uuid = uuid;
        this.modelName = modelName;
        this.rangeInKm = range;
        this.consumption = consumption;
    }

    public String info() {
        return String.format("Model: %s, id:%s", getModelName(), getUuid().toString());
    }

    public double getConsumption() {
        return consumption;
    }

    public UUID getUuid() {
        return uuid;
    }

    public String getModelName() {
        return modelName;
    }

    public double getRangeInKm() {
        return rangeInKm;
    }

    public int compareTo(Aircraft a) {
        int modelCmp = getModelName().compareToIgnoreCase(a.getModelName());
        return (modelCmp != 0) ? modelCmp : getUuid().compareTo(a.getUuid());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Aircraft aircraft = (Aircraft) o;

        return getUuid().equals(aircraft.getUuid());

    }

    @Override
    public int hashCode() {
        return getUuid().hashCode();
    }
}
