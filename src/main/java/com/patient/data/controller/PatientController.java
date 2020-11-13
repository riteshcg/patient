
package com.patient.data.controller;

import com.patient.data.entity.Patient;
import com.patient.data.service.PatientService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class PatientController {

	private static Logger logger = LoggerFactory.getLogger(PatientController.class);

	@Autowired
	private PatientService service;

	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		logger.info("Request to add patient");
		return service.addPatient(patient);
	}

	@GetMapping("/patients")
	public List<Patient> findAllPatients() {
		logger.info("Request to fetch all patients details");
		return service.getPatients();
	}

	@GetMapping("/patientById/{id}")
	public Patient findPatientById(@PathVariable int id) {
		logger.info("Request to fetch patient details");
		return service.getPatientById(id);
	}

	@GetMapping("/patientByName/{name}")
	public Patient findPatientByName(@PathVariable String name) {
		logger.info("Request to fetch patients details by name");
		return service.getPatientByName(name);
	}

	@PutMapping("/update")
	public Patient updatePatient(@RequestBody Patient patient) {
		logger.info("Request to update patients details");
		return service.updatePatient(patient);
	}

	@DeleteMapping("/delete/{id}")
	public String deletePatient(@PathVariable int id) {
		logger.info("Request to delete patient details");
		return service.deletePatient(id);
	}
}
