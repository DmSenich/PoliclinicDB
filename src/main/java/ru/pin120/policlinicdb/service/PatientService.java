package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Patient;

import java.util.Collection;
import java.util.Date;

public interface PatientService {
    Collection<Patient> findAll();
    Patient findOneById(int id);
    void create(String firstName, String lastName, String part, String birthDate, String area, String city, String house, int apartment);

    void update(int id,String firstName, String lastName, String part, String birthDate, String area, String city, String house, int apartment);
    void delete(int id);
}
