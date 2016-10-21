package com.epam.altynbekova.airline.entity;

import java.util.UUID;

public class Freighter extends Aircraft {
    /**Available volume of cargo in cubic meter (m³)*/
    private double cargoVolume;

    public Freighter(){}

    public Freighter(UUID uuid, String modelName, double range, double consumption, double cargoVolume) {
        super(uuid, modelName, range, consumption);
        this.cargoVolume = cargoVolume;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    @Override
    public String toString() {
        return "Cargo aircraft "+getModelName()+" id="+getUuid()+
                "\nrange="+ getRangeInKm()+", consumption="+getConsumption()+
                "\ncargo capacity="+ getCargoVolume();
    }
}
