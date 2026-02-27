package com.bus.bus.repository;

import com.bus.bus.entity.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository<Bus, Integer> {

    List<Bus> findByBusName(String busName);

    boolean existsByBusName(String busName);
}
