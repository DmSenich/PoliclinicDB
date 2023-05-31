package ru.pin120.policlinicdb.service;

import ru.pin120.policlinicdb.models.DiseaseType;
import ru.pin120.policlinicdb.repository.DiseaseTypeRepository;
import ru.pin120.policlinicdb.repository.DiseaseTypeRepositoryImpl;

import java.sql.Connection;
import java.util.Collection;

public class DiseaseTypeServiceImpl implements DiseaseTypeService{

    private final DiseaseTypeRepository diseaseTypeRepository;
    public DiseaseTypeServiceImpl(Connection connection){this.diseaseTypeRepository = new DiseaseTypeRepositoryImpl(connection);}
    @Override
    public Collection<DiseaseType> findAll() {
        return diseaseTypeRepository.findAll();
    }

    @Override
    public DiseaseType findOneById(int id) {
        return diseaseTypeRepository.findOneById(id).get();
    }

    @Override
    public void create(String name) {
        DiseaseType diseaseType = new DiseaseType(name);
        diseaseTypeRepository.save(diseaseType);
    }

    @Override
    public void update(int id, String name) {
        DiseaseType diseaseType = new DiseaseType(id,name);
        diseaseTypeRepository.update(diseaseType);
    }

    @Override
    public void delete(int id) {
        DiseaseType diseaseType = findOneById(id);
        diseaseTypeRepository.delete(diseaseType);
    }
}
