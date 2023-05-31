package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.Disease;
import ru.pin120.policlinicdb.models.DiseaseType;
import ru.pin120.policlinicdb.repository.DiseaseRepository;
import ru.pin120.policlinicdb.repository.DiseaseRepositoryImpl;
import ru.pin120.policlinicdb.repository.DiseaseTypeRepository;
import ru.pin120.policlinicdb.repository.DiseaseTypeRepositoryImpl;

import java.sql.Connection;
import java.util.Collection;
import java.util.List;

public class DiseaseServiceImpl implements DiseaseService{
    private final DiseaseRepository diseaseRepository;
    public DiseaseServiceImpl(Connection connection){this.diseaseRepository = new DiseaseRepositoryImpl(connection);}
    @Override
    public Collection<Disease> findAll() {
        return diseaseRepository.findAll();
    }

    @Override
    public Disease findOneById(int id) {
        return diseaseRepository.findOneById(id).get();
    }

    @Override
    public Collection<Disease> findAllOfVisiting(int id) {
        return diseaseRepository.findAllOfVisiting(id);
    }

    @Override
    public void create(int typeId, String description, int visitingId) {
        Disease disease = new Disease(typeId, description,visitingId);
        diseaseRepository.save(disease);
    }

//    @Override
//    public void update(int id, DiseaseType type, String description, int visitingId) {
//        //DiseaseType diseaseType = new DiseaseType(id,name);
//        diseaseRepository.update(disease);
//    }

    @Override
    public void delete(int id) {
        Disease disease = findOneById(id);
        diseaseRepository.delete(disease);
    }
}
