package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Service;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ServiceRepository extends JpaRepository<Service, Integer> {
}
