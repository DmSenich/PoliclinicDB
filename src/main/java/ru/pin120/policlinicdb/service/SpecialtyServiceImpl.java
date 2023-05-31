package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Specialty;
import ru.pin120.policlinicdb.repository.SpecialtyRepository;
import ru.pin120.policlinicdb.repository.SpecialtyRepositoryImpl;

import java.sql.Connection;
import java.util.Collection;

public class SpecialtyServiceImpl implements SpecialtyService{

    private final SpecialtyRepository specialtyRepository;

    public SpecialtyServiceImpl(Connection connection){this.specialtyRepository = new SpecialtyRepositoryImpl(connection);}
    @Override
    public Collection<Specialty> findAll() {
        return specialtyRepository.findAll();
    }

    @Override
    public Specialty findOneById(int id) {
        return specialtyRepository.findOneById(id).get();
    }

    @Override
    public Collection<Specialty> findAllOfDoctor(int id) {
        return specialtyRepository.findAllOfDoctor(id);
    }

    @Override
    public void create(String name) {
        Specialty specialty = new Specialty(name);
        specialtyRepository.save(specialty);
    }

    @Override
    public void update(int id, String name) {
        Specialty specialty = new Specialty(id, name);
        specialtyRepository.update(specialty);
    }

    @Override
    public void delete(int id) {
        Specialty specialty = findOneById(id);
        specialtyRepository.delete(specialty);
    }
}
