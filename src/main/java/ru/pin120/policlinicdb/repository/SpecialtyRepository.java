package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Specialty;

import java.util.Collection;
import java.util.Optional;

public interface SpecialtyRepository {
    Collection<Specialty> findAll();
    Optional<Specialty> findOneById(int id);
    Collection<Specialty> findAllOfDoctor(int id);
    Specialty save(Specialty specialty);
    void delete(Specialty specialty);
    void update(Specialty specialty);
}
