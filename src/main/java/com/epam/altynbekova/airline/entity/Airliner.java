package com.epam.altynbekova.airline.entity;

import java.util.UUID;

public class Airliner extends Aircraft {
    private int passengerSeats;
    /**
     * Available volume of cargo in cubic meter (m³)
     */
    private double cargoVolume;

    public Airliner() {
    }

    public Airliner(UUID uuid, String modelName, double range, double consumption, int passengerCapacity, double cargoVolume) {
        super(uuid, modelName, range, consumption);
        this.passengerSeats = passengerCapacity;
        this.cargoVolume = cargoVolume;
    }

    public int getPassengerSeats() {
        return passengerSeats;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    @Override
    public String toString() {
        return "Passenger aircraft " + getModelName() + " id=" + getUuid() +
                "\nrange=" + getRangeInKm() + ", consumption=" + getConsumption() +
                "\npassenger capacity=" + getPassengerSeats() + ", cargo capacity=" + getCargoVolume();
    }
}
