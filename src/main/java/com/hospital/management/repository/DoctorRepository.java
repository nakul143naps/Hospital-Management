package com.hospital.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.hospital.management.model.Doctor;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
