package com.epam.altynbekova.airline.entity;

public class Freighter extends Aircraft {
    /**Available volume of cargo in cubic meter (m³)*/
    private double cargoVolume;

    public Freighter(){}

    public Freighter(int id, String modelName, double range, double consumption, double cargoVolume) {
        super(id, modelName, range, consumption);
        this.cargoVolume = cargoVolume;
    }

    public double getCargoVolume() {
        return cargoVolume;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Freighter)) return false;

        Freighter freighter = (Freighter) o;

        return (getId() == freighter.getId()) &&
                (Double.compare(freighter.getRangeInKm(), getRangeInKm()) == 0) &&
                (Double.compare(freighter.getConsumption(), getConsumption()) == 0) &&
                (Double.compare(freighter.getCargoVolume(), getCargoVolume()) == 0) &&
                getModelName().equals(freighter.getModelName());

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
        temp = Double.doubleToLongBits(getCargoVolume());
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "Cargo aircraft "+getModelName()+" id="+getId()+
                "\nrange="+ getRangeInKm()+", consumption="+getConsumption()+
                "\ncargo capacity="+ getCargoVolume();
    }
}
