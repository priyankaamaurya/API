package com.hotel.hotel.service;

import com.hotel.hotel.entity.Hotel;
import org.jspecify.annotations.Nullable;

import java.util.List;

public interface HotelService {
    Hotel saveHotel(Hotel hotel);

    List<Hotel> findAll();

    Hotel findById(int id);

    Hotel updatePerson(int id, Hotel hotel);

    void deleteHotel(int id);

    List<Hotel> findByCity(String city);
}
