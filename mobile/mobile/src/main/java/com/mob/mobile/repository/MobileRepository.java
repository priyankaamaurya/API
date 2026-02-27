package com.mob.mobile.repository;

import com.mob.mobile.entity.Mobile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MobileRepository extends JpaRepository<Mobile, Integer> {

    List<Mobile> findByBrand(String brand);

    boolean existsByBrand(String brand);
}
