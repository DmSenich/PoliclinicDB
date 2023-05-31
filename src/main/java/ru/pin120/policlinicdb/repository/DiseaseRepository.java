package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Disease;

import java.util.Collection;
import java.util.Optional;

public interface DiseaseRepository {
    Collection<Disease> findAll();
    Optional<Disease> findOneById(int id);
    Collection<Disease> findAllOfVisiting(int id);
    Disease save(Disease disease);
    void delete(Disease disease);
    //void update(Disease disease);
}
