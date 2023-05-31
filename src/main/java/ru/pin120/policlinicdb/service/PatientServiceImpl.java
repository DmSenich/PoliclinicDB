package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Patient;
import ru.pin120.policlinicdb.repository.PatientRepository;
import ru.pin120.policlinicdb.repository.PatientRepositoryImpl;

import java.sql.Connection;
import java.util.Collection;
import java.util.Date;

public class PatientServiceImpl implements PatientService{
    private final PatientRepository patientRepository;

    public PatientServiceImpl(Connection connection){this.patientRepository = new PatientRepositoryImpl(connection);}
    @Override
    public Collection<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findOneById(int id) {
        return patientRepository.findOneById(id).get();
    }

    @Override
    public void create(String firstName, String lastName, String part, String birthDate, String area, String city, String house, int apartment) {
        Patient patient = new Patient(firstName,lastName,part,birthDate,area,city,house,apartment);
        patientRepository.save(patient);
    }

    @Override
    public void update(int id,String firstName, String lastName, String part, String birthDate, String area, String city, String house, int apartment) {
        Patient patient = new Patient(id,firstName,lastName,part,birthDate,area,city,house,apartment);
        patientRepository.update(patient);
    }

    @Override
    public void delete(int id) {
        Patient patient = findOneById(id);
        patientRepository.delete(patient);
    }
}
