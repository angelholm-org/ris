package org.ddmed.ris.repository;

import org.ddmed.ris.model.Patient;

import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, String> {

}
