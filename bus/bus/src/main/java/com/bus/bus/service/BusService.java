package com.bus.bus.service;

import com.bus.bus.entity.Bus;
import org.jspecify.annotations.Nullable;

import java.util.List;


public interface BusService {
    Bus save(Bus bus);

    List<Bus> findAll();

    Bus findById(int id);

    Bus updateBus(int id, Bus bus);

    void deleteBus(int id);

    List<Bus> findByBusName(String busName);
}
