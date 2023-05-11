package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Visiting;

import java.util.Collection;

public interface VisitingService {
    Collection<Visiting> findAll();
    Visiting findOneById(int id);
    void create(Visiting visiting);
    void update(Visiting visiting);
    void delete(Visiting visiting);
}
