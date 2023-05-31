package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Patient;

import java.util.Collection;
import java.util.Optional;

public interface PatientRepository {
    Collection<Patient> findAll();
    Optional<Patient> findOneById(int id);
    Patient save(Patient patient);
    void delete(Patient patient);
    void update(Patient patient);
}
