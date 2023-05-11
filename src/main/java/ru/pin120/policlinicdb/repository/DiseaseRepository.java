package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Disease;

import java.util.*;

public interface DiseaseRepository {
    Collection<Disease> findAl();
    Optional<Disease> findOneById(int id);
    Disease save(Disease disease);
    void delete(Disease disease);
    void update(Disease disease);
}
