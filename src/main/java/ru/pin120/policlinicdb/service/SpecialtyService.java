package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Specialty;

import java.util.Collection;

public interface SpecialtyService {
    Collection<Specialty> findAll();
    Specialty findOneById(int id);
    Collection<Specialty> findAllOfDoctor(int id);
    void create(String name);
    void update(int id, String name);
    void delete(int id);
}
