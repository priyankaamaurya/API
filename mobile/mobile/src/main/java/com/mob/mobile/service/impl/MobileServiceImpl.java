package com.mob.mobile.service.impl;

import com.mob.mobile.entity.Mobile;
import com.mob.mobile.repository.MobileRepository;
import com.mob.mobile.service.MobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MobileServiceImpl implements MobileService {

    @Autowired
    MobileRepository mobileRepository;

    @Override
    public Mobile saveMobile(Mobile mobile) {
        return mobileRepository.save(mobile);
    }

    @Override
    public List<Mobile> findAll() {
        return mobileRepository.findAll();
    }

    @Override
    public Mobile findById(int id) {
        return mobileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mobile not found "));
    }

    @Override
    public Mobile updateMobile(int id, Mobile mobile) {
        Mobile mobile1 = mobileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mobile not found "));

        return mobileRepository.save(mobile);
    }

    @Override
    public void deleteMobile(int id) {
        Mobile mobile = mobileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Mobile not found "));

        mobileRepository.save(mobile);
    }


}
