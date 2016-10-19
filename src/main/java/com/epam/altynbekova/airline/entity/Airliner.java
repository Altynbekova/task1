package com.epam.altynbekova.airline.entity;

import java.util.Objects;

public class Airliner extends Aircraft {
    private int passengerSeats;
    /**Available volume of cargo in cubic meter (m³)*/
    private double cargoVolume;

    public Airliner() {}

    public Airliner(int id, String modelName, double range, double consumption, int passengerCapacity, double cargoVolume) {
        super(id, modelName, range, consumption);
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airliner)) return false;

        Airliner airliner = (Airliner) o;
        return (getId() == airliner.getId()) &&
                (Double.compare(airliner.getRangeInKm(), getRangeInKm()) == 0) &&
                (Double.compare(airliner.getConsumption(), getConsumption()) == 0) &&
                (getPassengerSeats() == airliner.getPassengerSeats()) &&
                (Double.compare(airliner.getCargoVolume(), getCargoVolume()) == 0) &&
                getModelName().equals(airliner.getModelName());

    }

     @Override
    public int hashCode() {
        int result;
        long temp;
        result = getId();
        result = 31 * result + getModelName().hashCode();
        temp = Double.doubleToLongBits(getRangeInKm());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(getConsumption());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31*result+getPassengerSeats();
        temp = Double.doubleToLongBits(getCargoVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }


    @Override
    public String toString() {
        return "Passenger aircraft "+getModelName()+" id="+getId()+
                "\nrange="+ getRangeInKm()+", consumption="+getConsumption()+
                "\npassenger capacity="+ getPassengerSeats()+", cargo capacity="+ getCargoVolume();
    }
}
