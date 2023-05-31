package ru.pin120.policlinicdb.service;


import ru.pin120.policlinicdb.models.DiseaseType;

import java.util.Collection;

public interface DiseaseTypeService {
    Collection<DiseaseType> findAll();
    DiseaseType findOneById(int id);
    void create(String name);
    void update(int id, String name);
    void delete(int id);
}
