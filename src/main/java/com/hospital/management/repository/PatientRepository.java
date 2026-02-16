package com.hospital.management.repository;

import com.hospital.management.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {

  List<Patient> findByNameContainingIgnoreCase(String keyword);
}
