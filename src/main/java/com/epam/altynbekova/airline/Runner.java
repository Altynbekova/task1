package com.epam.altynbekova.airline;

import com.epam.altynbekova.airline.entity.*;
import com.epam.altynbekova.airline.service.AircraftFactory;
import com.epam.altynbekova.airline.service.AircraftSorter;
import com.epam.altynbekova.airline.service.AirlineService;
import com.epam.altynbekova.airline.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.*;
import java.util.List;


public class Runner {
    private static final Logger LOG = LoggerFactory.getLogger(Runner.class);
    private static final double CONSUMPTION_MIN_SEARCH_VALUE=110;
    private static final  double CONSUMPTION_MAX_SEARCH_VALUE=20000;

    public static void main(String[] args) throws IOException {
            PropertyManager propertyManager = PropertyManager.getInstance();
            Aircraft[] aircraft={AircraftFactory.createAircraft(new Airliner()),
                    AircraftFactory.createAircraft(new Freighter()),
                    AircraftFactory.createAircraft(new Trainer())};

            Airline airline=new Airline(propertyManager.getProperty("airline.name"), Arrays.asList(aircraft));
            LOG.info(airline.info());

            AirlineService airlineService = new AirlineService();
            List<Aircraft> aircraftList = Arrays.asList(aircraft);
            AirlineService.TotalCapacity totalCapacity = airlineService.getTotalCapacity(aircraftList);

            List<Aircraft> searchRes= airlineService.getByConsumption(aircraftList,CONSUMPTION_MIN_SEARCH_VALUE,
                                                                    CONSUMPTION_MAX_SEARCH_VALUE);

            AircraftSorter aircraftSorter= new AircraftSorter();
            aircraftSorter.sortByRange(Arrays.asList(aircraft));
    }
}
