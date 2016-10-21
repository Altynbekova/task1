package com.epam.altynbekova.airline.service;

import com.epam.altynbekova.airline.entity.Aircraft;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class AircraftSorter {
    private static final Logger LOG = LoggerFactory.getLogger(AircraftSorter.class);

    private static final Comparator<Aircraft> RANGE_ORDER =
            (a1, a2) -> {
                int rangeCmp = Double.compare(a1.getRangeInKm(), a2.getRangeInKm());
                if (rangeCmp != 0)
                    return rangeCmp;

                return a1.getUuid().compareTo(a2.getUuid());
            };


    public AircraftSorter() {
    }

    public List<Aircraft> sortByRange(List<Aircraft> aircraft) {
        List<Aircraft> result = aircraft.stream().collect(Collectors.toList());
        Collections.sort(result, RANGE_ORDER);
        return result;
    }
}
