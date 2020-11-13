package com.patient.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.patient.data.entity.Patient;

public interface PatientRepository extends JpaRepository<Patient, Integer> {

	public Patient findByName(String name);
}
