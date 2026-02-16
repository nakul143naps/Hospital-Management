package com.hospital.management.service;

import com.hospital.management.model.Patient;
import com.hospital.management.repository.PatientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

  private final PatientRepository patientRepository;

  public PatientServiceImpl(PatientRepository patientRepository) {
    this.patientRepository = patientRepository;
  }

  @Override
  public Patient savePatient(Patient patient) {
    return patientRepository.save(patient);
  }

  @Override
  public List<Patient> getAllPatients() {
    return patientRepository.findAll();
  }

  @Override
  public Page<Patient> getPatientsPaginated(int page, int size) {
    return patientRepository.findAll(PageRequest.of(page, size));
  }

  @Override
  public Patient updatePatient(Long id, Patient patient) {
    Patient existing = patientRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Patient not found"));

    existing.setName(patient.getName());
    existing.setAge(patient.getAge());
    existing.setGender(patient.getGender());
    existing.setDisease(patient.getDisease());

    return patientRepository.save(existing);
  }

  @Override
  public void deletePatient(Long id) {
    patientRepository.deleteById(id);
  }

  @Override
  public List<Patient> searchPatients(String keyword) {
    if (keyword == null || keyword.trim().isEmpty()) {
      return patientRepository.findAll();
    }
    return patientRepository.findByNameContainingIgnoreCase(keyword);
  }
}
