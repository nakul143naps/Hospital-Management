package com.hospital.management.service;

import com.hospital.management.model.Patient;
import org.springframework.data.domain.Page;

import java.util.List;

public interface PatientService {

  Patient savePatient(Patient patient);

  List<Patient> getAllPatients();

  Page<Patient> getPatientsPaginated(int page, int size);

  Patient updatePatient(Long id, Patient patient);

  void deletePatient(Long id);

  List<Patient> searchPatients(String keyword);
}
