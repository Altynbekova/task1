package com.epam.altynbekova.airline.entity;

public class Trainer extends Aircraft {
    private String typeName;

    public Trainer(){}

    public Trainer(int id, String modelName, double range, double consumption, String typeName) {
        super(id, modelName, range, consumption);
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Trainer)) return false;

        Trainer trainer = (Trainer) o;

        return (getId() == trainer.getId()) &&
                (Double.compare(trainer.getRangeInKm(), getRangeInKm()) == 0) &&
                (Double.compare(trainer.getConsumption(), getConsumption()) == 0) &&
                getModelName().equals(trainer.getModelName())&&
                getTypeName().equals(trainer.getTypeName());

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
        result = 31 * result + getTypeName().hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Training aircraft "+getModelName()+" id="+getId()+
                "\nrange="+ getRangeInKm()+", consumption="+getConsumption()+
                "\ntype="+typeName;
    }
}
