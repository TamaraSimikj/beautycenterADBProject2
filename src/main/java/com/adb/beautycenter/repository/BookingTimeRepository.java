package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.BookingTime;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BookingTimeRepository extends JpaRepository<BookingTime, Integer> {
}
