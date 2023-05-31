package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.models.Specialty;

import java.util.Collection;
import java.util.List;

public interface DoctorService {
    Collection<Doctor> findAll();
    Doctor findOneById(int id);
    void updateSpecialty(int id, List<Specialty> specialties);
    void create(String firstName, String lastName, String part, int workExp) ;
    void update(int id, String firstName, String lastName, String part, int workExp) ;
    void delete(int id);
}
