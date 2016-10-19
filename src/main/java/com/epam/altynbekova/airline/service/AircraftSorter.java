package com.epam.altynbekova.airline.service;

import com.epam.altynbekova.airline.Runner;
import com.epam.altynbekova.airline.entity.Aircraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;

public class AircraftSorter {
    private static final Logger LOG = LoggerFactory.getLogger(AircraftSorter.class);

    private static final Comparator<Aircraft> RANGE_ORDER =
            (a1, a2) -> {
                int rangeCmp = Double.compare(a1.getRangeInKm(),a2.getRangeInKm());
                if (rangeCmp != 0)
                    return rangeCmp;

                return Integer.compare(a1.getId(),a2.getId());
            };


    public AircraftSorter() {
    }

    public void sortByRange(List<Aircraft> aircraft)
    {
        Collections.sort(aircraft, RANGE_ORDER);
        LOG.info("List of aircraft sorted by range :");
        for(Aircraft a : aircraft)
            LOG.info("{}",a.info());
    }
}
