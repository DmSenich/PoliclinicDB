package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.models.Specialty;
import ru.pin120.policlinicdb.repository.DoctorRepository;
import ru.pin120.policlinicdb.repository.DoctorRepositoryImpl;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class DoctorServiceImpl implements DoctorService{
    private final DoctorRepository doctorRepository;

    public DoctorServiceImpl(Connection connection){this.doctorRepository = new DoctorRepositoryImpl(connection);
    }

    @Override
    public Collection<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findOneById(int id) {
        return doctorRepository.findOneById(id).get();
    }

    @Override
    public void updateSpecialty(int id, List<Specialty> specialties) {
        doctorRepository.updateSpecialty(id, specialties);
    }

    @Override
    public void create(String firstName, String lastName, String part, int workExp) {
        Doctor doctor = new Doctor(firstName, lastName, part, workExp);
        doctorRepository.save(doctor);
    }

    @Override
    public void update(int id, String firstName, String lastName, String part, int workExp) {
        Doctor doctor = new Doctor(id, firstName, lastName, part, workExp);
        doctorRepository.update(doctor);
    }

    @Override
    public void delete(int id) {
        Doctor doctor = findOneById(id);
        doctorRepository.delete(doctor);
    }
}
