package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ClientRepository extends JpaRepository<Client, String> {
}
