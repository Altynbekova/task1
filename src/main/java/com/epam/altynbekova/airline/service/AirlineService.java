package com.epam.altynbekova.airline.service;

import com.epam.altynbekova.airline.Runner;
import com.epam.altynbekova.airline.entity.Aircraft;
import com.epam.altynbekova.airline.entity.Airliner;
import com.epam.altynbekova.airline.entity.Freighter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class AirlineService {
    private static final Logger LOG = LoggerFactory.getLogger(AirlineService.class);

    public AirlineService(){}

    public TotalCapacity getTotalCapacity (List<Aircraft> aircraft)
    {
        TotalCapacity totalCapacity = new TotalCapacity();
        for (Aircraft value : aircraft) {
            if (value instanceof Airliner) {
                 totalCapacity.passengerSeats+= ((Airliner) value).getPassengerSeats();
                totalCapacity.cargoVolume+=((Airliner) value).getCargoVolume();
            }
            else if (value instanceof Freighter)
                totalCapacity.cargoVolume+=((Freighter) value).getCargoVolume();
        }
        LOG.info("Total capacity: {} passenger seats and {} m³ of cargo.",
                totalCapacity.getPassengerSeats(),
                totalCapacity.getCargoVolume());

        return totalCapacity;
    }

    public List<Aircraft> getByConsumption (List<Aircraft> aircraft, double minValue, double maxValue)
    {
       List<Aircraft> result = new ArrayList<>();

        if (aircraft == null) {
            throw new IllegalArgumentException();
        }
        if (minValue > maxValue) {
            throw new IllegalArgumentException(
                    "minValue(" + minValue + ") > maxValue(" + maxValue + ")");
        }
        for (Aircraft value : aircraft){
                if (value.getConsumption() >= minValue && value.getConsumption() <= maxValue)
                    result.add(value);
        }
        LOG.info("The following {} aircraft have value of consumption from {} to {} kg/h:", result.size(), minValue, maxValue);
        for (Aircraft a : result)
            LOG.info("{}", a.info());

        return result;
    }

    public static class TotalCapacity
    {
        private int passengerSeats;
        private double cargoVolume;

        public TotalCapacity(){}

        public TotalCapacity(int passengerSeats, double cargoVolume) {
            this.passengerSeats = passengerSeats;
            this.cargoVolume = cargoVolume;
        }

        public int getPassengerSeats() {
            return passengerSeats;
        }

        public double getCargoVolume() {
            return cargoVolume;
        }
    }
}
