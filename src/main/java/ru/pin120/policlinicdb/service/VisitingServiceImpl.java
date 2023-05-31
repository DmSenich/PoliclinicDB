package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Disease;
import ru.pin120.policlinicdb.models.Visiting;
import ru.pin120.policlinicdb.repository.VisitingRepository;
import ru.pin120.policlinicdb.repository.VisitingRepositoryImpl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class VisitingServiceImpl implements VisitingService{

    private final VisitingRepository visitingRepository;
    public VisitingServiceImpl(Connection connection){
        this.visitingRepository = new VisitingRepositoryImpl(connection);
    }
    @Override
    public Collection<Visiting> findAll() {
        return visitingRepository.findAll();
    }

    @Override
    public Visiting findOneById(int id) {
        return visitingRepository.findOneById(id).get();
    }

    @Override
    public void create(int id, int doctorId, int patientId, String date) {
        Visiting visiting = new Visiting(id, doctorId, patientId, date);
        visitingRepository.save(visiting);
    }

    @Override
    public void update(int id, int doctorId, int patientId, String date) {
        Visiting visiting = new Visiting(id, doctorId, patientId, date);
        visitingRepository.update(visiting);

    }

    @Override
    public void delete(int id) {
        Visiting visiting = findOneById(id);
        visitingRepository.delete(visiting);
    }
}
