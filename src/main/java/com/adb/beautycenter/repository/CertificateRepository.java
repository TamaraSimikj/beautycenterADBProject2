package com.adb.beautycenter.repository;

import com.adb.beautycenter.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CertificateRepository extends JpaRepository<Certificate, Integer> {
}
