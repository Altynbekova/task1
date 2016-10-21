package com.epam.altynbekova.airline.entity;

import java.util.UUID;

public class Trainer extends Aircraft {
    private String typeName;

    public Trainer(){}

    public Trainer(UUID uuid, String modelName, double range, double consumption, String typeName) {
        super(uuid, modelName, range, consumption);
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

    @Override
    public String toString() {
        return "Training aircraft "+getModelName()+" id="+getUuid()+
                "\nrange="+ getRangeInKm()+", consumption="+getConsumption()+
                "\ntype="+typeName;
    }
}
