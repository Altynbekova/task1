package com.epam.altynbekova.airline.entity;

import java.util.Comparator;
import java.util.Objects;

public class Aircraft implements Comparable<Aircraft> {
    private int id;
    private String modelName;
    private double rangeInKm;
    /** Fuel consumption in kilogram per hour (kg/hr)*/
    private double consumption;

    public Aircraft(){}

    public Aircraft(int id, String modelName, double range, double consumption) {
        this.id = id;
        this.modelName = modelName;
        this.rangeInKm = range;
        this.consumption = consumption;
    }

    public String info()
    {
        return String.format("Model: %s, id:%d", getModelName(), getId());
    }
    public double getConsumption() {
        return consumption;
    }

    public int getId() {
        return id;
    }

    public String getModelName() {
        return modelName;
    }

    public double getRangeInKm() {
        return rangeInKm;
    }

   public int compareTo(Aircraft a) {
        int modelCmp=this.modelName.compareToIgnoreCase(a.getModelName());
        return (modelCmp != 0) ? modelCmp : Integer.compare(this.id, a.getId());
    }
}
