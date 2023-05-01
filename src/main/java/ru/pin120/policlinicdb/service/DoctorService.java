package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Doctor;

import java.util.Collection;

public interface DoctorService {
    Collection<Doctor> findAll();
    Doctor findOneById(int id);
    void create(Doctor doctor);
    void update(Doctor doctor);
    void delete(Doctor doctor);
}
