package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Visiting;

import java.util.Collection;

public interface VisitingService {
    Collection<Visiting> findAll();
    Visiting findOneById(int id);
    void create(int id, int doctorId, int patientId, String date);
    void update(int id, int doctorId, int patientId, String date);
    void delete(int id);
}
