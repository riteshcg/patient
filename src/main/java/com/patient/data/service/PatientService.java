package com.patient.data.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.patient.data.entity.Patient;
import com.patient.data.repository.PatientRepository;

@Service
public class PatientService {
	
	private static Logger logger = LoggerFactory.getLogger(PatientService.class);


	@Autowired
	private PatientRepository repository;

	public Patient addPatient(Patient patient) {
		logger.info("Request to add patient");
		return repository.save(patient);
	}

	public List<Patient> getPatients() {
		logger.info("Request to fetch all patients");
		return repository.findAll();
	}

	public Patient getPatientById(int id) {
		logger.info("Request to fetch patient");
		return repository.findById(id).orElse(null);
	}

	public Patient getPatientByName(String name) {
		logger.info("Request to fetch patient by name");
		return repository.findByName(name);
	}

	public String deletePatient(int id) {
		logger.info("Request to delete patient");
		repository.deleteById(id);
		return "product removed !! " + id;
	}

	public Patient updatePatient(Patient patient) {
		logger.info("Request to update patient");
		Patient existingPatient = repository.findById(patient.getId()).orElse(null);
		existingPatient.setName(patient.getName());
		existingPatient.setGender(patient.getGender());
		existingPatient.setPhoneNumber(patient.getPhoneNumber());
		return repository.save(existingPatient);
	}

}
