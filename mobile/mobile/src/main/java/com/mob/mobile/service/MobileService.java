package com.mob.mobile.service;

import com.mob.mobile.entity.Mobile;

import java.util.List;

public interface MobileService {


    Mobile saveMobile(Mobile mobile);

    List<Mobile> findAll();

    Mobile findById(int id);

    Mobile updateMobile(int id, Mobile mobile);

    void deleteMobile(int id);
}
