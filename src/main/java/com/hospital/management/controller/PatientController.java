package com.hospital.management.controller;

import com.hospital.management.model.Patient;
import com.hospital.management.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/patients")
@CrossOrigin(origins = "http://localhost:3000")
public class PatientController {

  private final PatientService service;

  public PatientController(PatientService service) {
    this.service = service;
  }

  @GetMapping
  public List<Patient> getAllPatients() {
    return service.getAllPatients();
  }

  @GetMapping("/search")
  public List<Patient> searchPatients(@RequestParam String keyword) {
    return service.searchPatients(keyword);
  }

  @GetMapping("/page")
  public Page<Patient> getPatients(
      @RequestParam int page,
      @RequestParam int size) {
    return service.getPatientsPaginated(page, size);
  }

  @PostMapping
  public Patient addPatient(@RequestBody Patient patient) {
    return service.savePatient(patient);
  }

  @PutMapping("/{id}")
  public Patient updatePatient(
      @PathVariable Long id,
      @RequestBody Patient patient) {
    return service.updatePatient(id, patient);
  }

  @DeleteMapping("/{id}")
  public void deletePatient(@PathVariable Long id) {
    service.deletePatient(id);
  }
}
