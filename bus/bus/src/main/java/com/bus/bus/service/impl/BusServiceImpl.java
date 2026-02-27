package com.bus.bus.service.impl;

import com.bus.bus.entity.Bus;
import com.bus.bus.exception.BusException;
import com.bus.bus.repository.BusRepository;
import com.bus.bus.service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements BusService {

    @Autowired
    BusRepository busRepository;

    @Override
    public Bus save(Bus bus) {
        if (busRepository.existsByBusName(bus.getBusName()))
            throw new BusException("Bus is already exist");
        return busRepository.save(bus);
    }

    @Override
    public List<Bus> findAll() {
        return busRepository.findAll();
    }

    @Override
    public Bus findById(int id) {
        return busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus Not found "));
    }

    @Override
    public Bus updateBus(int id, Bus bus) {
        Bus bus1 = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not Found "));

        return busRepository.save(bus);
    }

    @Override
    public void deleteBus(int id) {
        Bus bus = busRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Bus not found "));

        busRepository.delete(bus);
    }

    @Override
    public List<Bus> findByBusName(String busName) {
        return busRepository.findByBusName(busName);
    }


}
