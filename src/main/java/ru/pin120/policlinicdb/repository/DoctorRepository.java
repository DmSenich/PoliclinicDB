package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Doctor;

import java.util.*;

public interface DoctorRepository {
    Collection<Doctor> findAl();
    Optional<Doctor> findOneById(int id);
    Doctor save(Doctor doctor);
    void delete(Doctor doctor);
    void update(Doctor doctor);
}
