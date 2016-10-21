package com.epam.altynbekova.airline;

import com.epam.altynbekova.airline.entity.*;
import com.epam.altynbekova.airline.service.*;
import com.epam.altynbekova.airline.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;


public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
    private static final double CONSUMPTION_MIN_SEARCH_VALUE = 110;
    private static final double CONSUMPTION_MAX_SEARCH_VALUE = 20000;

    public static void main(String[] args) throws IOException {
        PropertyManager propertyManager = PropertyManager.getInstance();
        Aircraft[] aircraft = {AircraftFactory.createAircraft(new Airliner()),
                AircraftFactory.createAircraft(new Freighter()),
                AircraftFactory.createAircraft(new Trainer())};

        Airline airline = new Airline(UUID.randomUUID(), propertyManager.getProperty("airline.name"), Arrays.asList(aircraft));
        LOG.info(airline.info());

        AirlineService airlineService = new AirlineService();
        List<Aircraft> aircraftList = Arrays.asList(aircraft);
        AirlineService.TotalCapacity totalCapacity = airlineService.getTotalCapacity(aircraftList);

        List<Aircraft> searchRes = airlineService.getByConsumption(airline, CONSUMPTION_MIN_SEARCH_VALUE,
                CONSUMPTION_MAX_SEARCH_VALUE);

        AircraftSorter aircraftSorter = new AircraftSorter();
        List<Aircraft> sortedList = aircraftSorter.sortByRange(Arrays.asList(aircraft));

        LOG.info("List of aircraft sorted by range :");
        for (Aircraft a : sortedList)
            LOG.info("{}", a.info());
    }
}
