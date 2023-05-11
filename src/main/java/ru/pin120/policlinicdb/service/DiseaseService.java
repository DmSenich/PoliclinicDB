package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Disease;

import java.util.Collection;

public interface DiseaseService {
    Collection<Disease> findAll();
    Disease findOneById(int id);
    void create(Disease disease);
    void update(Disease disease);
    void delete(Disease disease);
}
