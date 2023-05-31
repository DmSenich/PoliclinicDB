package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Disease;
import ru.pin120.policlinicdb.models.DiseaseType;

import java.util.Collection;

public interface DiseaseService {
    Collection<Disease> findAll();
    Disease findOneById(int id);
    Collection<Disease> findAllOfVisiting(int id);
    void create(int typeId, String description, int visitingId);
    //void update(Disease disease);
    void delete(int id);
}
