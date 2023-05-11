package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Patient;

import java.util.Collection;

public interface PatientService {
    Collection<Patient> findAll();
    Patient findOneById(int id);
    void create(Patient patient);
    void update(Patient patient);
    void delete(Patient patient);
}
