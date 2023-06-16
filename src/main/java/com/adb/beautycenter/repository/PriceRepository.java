package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Price;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PriceRepository extends JpaRepository<Price, Integer> {
}
