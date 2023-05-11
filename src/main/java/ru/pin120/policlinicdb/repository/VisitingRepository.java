package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Visiting;

import java.util.*;

public interface VisitingRepository {
    Collection<Visiting> findAll();
    Optional<Visiting> findOneById(int id);
    Visiting save(Visiting visiting);
    void delete(Visiting visiting);
    void update(Visiting visiting);
}
