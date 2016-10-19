package com.epam.altynbekova.airline.service;

import com.epam.altynbekova.airline.entity.Aircraft;
import com.epam.altynbekova.airline.entity.Airliner;
import com.epam.altynbekova.airline.entity.Freighter;
import com.epam.altynbekova.airline.entity.Trainer;
import com.epam.altynbekova.airline.util.PropertyManager;

import java.io.IOException;

public class AircraftFactory implements Comparable{
    public AircraftFactory() {
    }

    public static Aircraft createAircraft (Aircraft a) throws IOException {
        PropertyManager propertyManager= PropertyManager.getInstance();
        if (a instanceof Airliner)
        {
            return new Airliner(Integer.parseInt(propertyManager.getProperty("airliner.1.id")),
                    propertyManager.getProperty("airliner.1.modelName"),
                    Double.parseDouble(propertyManager.getProperty("airliner.1.range")),
                    Double.parseDouble(propertyManager.getProperty("airliner.1.consumption")),
                    Integer.parseInt(propertyManager.getProperty("airliner.1.passengerSeats")),
                    Double.parseDouble(propertyManager.getProperty("airliner.1.cargoVolume")));
        }
        if (a instanceof Freighter)
        {
            return new Freighter(Integer.parseInt(propertyManager.getProperty("freighter.1.id")),
                    propertyManager.getProperty("freighter.1.modelName"),
                    Double.parseDouble(propertyManager.getProperty("freighter.1.range")),
                    Double.parseDouble(propertyManager.getProperty("freighter.1.consumption")),
                    Double.parseDouble(propertyManager.getProperty("freighter.1.cargoVolume")));
        }
        else
        {
            return new Trainer(Integer.parseInt(propertyManager.getProperty("trainer.1.id")),
                    propertyManager.getProperty("trainer.1.modelName"),
                    Double.parseDouble(propertyManager.getProperty("trainer.1.range")),
                    Double.parseDouble(propertyManager.getProperty("trainer.1.consumption")),
                    propertyManager.getProperty("trainer.1.typeName"));
        }
    }

    public int compareTo(Object o) {
        /*Aircraft other = (Aircraft)o;
        if (this.range<other)*/
        return 0;
    }
}
