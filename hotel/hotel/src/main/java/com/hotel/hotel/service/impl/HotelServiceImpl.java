package com.hotel.hotel.service.impl;

import com.hotel.hotel.entity.Hotel;
import com.hotel.hotel.exception.HotelException;
import com.hotel.hotel.repository.HotelRepository;
import com.hotel.hotel.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    HotelRepository hotelRepository;

    @Override
    public Hotel saveHotel(Hotel hotel) {
        if (hotelRepository.existsByCity(hotel.getCity()))
            throw new HotelException("city is already exist");
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel findById(int id) {
        return hotelRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Hotel Not Found"));
    }

    @Override
    public Hotel updatePerson(int id, Hotel hotel) {
        Hotel hotel1 = hotelRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Hotel Not Found"));

                return hotelRepository.save(hotel);
    }

    @Override
    public void deleteHotel(int id) {
            Hotel hotel = hotelRepository.findById(id)
                    .orElseThrow(()-> new RuntimeException("Hotel Not Found"));

            hotelRepository.delete(hotel);
    }

    @Override
    public List<Hotel> findByCity(String city) {
        return hotelRepository.findByCity(city);
    }


}
