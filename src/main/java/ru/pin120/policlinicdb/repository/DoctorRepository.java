package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.models.Specialty;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface DoctorRepository {
    Collection<Doctor> findAll();
    Optional<Doctor> findOneById(int id);
    Doctor save(Doctor doctor);
    Doctor updateSpecialty(int id,List<Specialty> specialties);
    void delete(Doctor doctor);
    void update(Doctor doctor);
}
