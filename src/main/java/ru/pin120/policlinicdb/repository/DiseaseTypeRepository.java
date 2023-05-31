package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.DiseaseType;

import java.util.Collection;
import java.util.Optional;

public interface DiseaseTypeRepository {
    Collection<DiseaseType> findAll();
    Optional<DiseaseType> findOneById(int id);
    DiseaseType save(DiseaseType diseaseType);
    void update(DiseaseType diseaseType);
    void delete(DiseaseType diseaseType);
}
