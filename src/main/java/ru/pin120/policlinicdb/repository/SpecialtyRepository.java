package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Specialty;

import java.util.*;

public interface SpecialtyRepository {
    Collection<Specialty> findAll();
    Optional<Specialty> findOneById(int id);
    Specialty save(Specialty specialty);
    void delete(Specialty specialty);
    void update(Specialty specialty);
}
