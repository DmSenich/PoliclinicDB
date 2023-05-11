package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Specialty;

import java.util.Collection;

public interface SpecialtyService {
    Collection<Specialty> findAll();
    Specialty findOneById(int id);
    void create(Specialty specialty);
    void update(Specialty specialty);
    void delete(Specialty specialty);
}
