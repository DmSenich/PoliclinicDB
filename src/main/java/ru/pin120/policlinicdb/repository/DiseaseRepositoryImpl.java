package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Disease;
import ru.pin120.policlinicdb.models.DiseaseType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DiseaseRepositoryImpl implements DiseaseRepository{
    private Connection connection;
    //DiseaseTypeRepositoryImpl diseaseTypeRepository;
    public DiseaseRepositoryImpl(Connection connection){
        this.connection = connection;
//        diseaseTypeRepository = new DiseaseTypeRepositoryImpl();
//        diseaseTypeRepository.setConnection(connection);
    }
    @Override
    public Collection<Disease> findAll() {
        Collection<Disease> diseases = null;
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM disease");
            diseases = mapper(resultSet);
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return diseases;
    }

    private Collection<Disease> mapper(ResultSet resultSet){
        Collection<Disease> diseases = new ArrayList<>();
        Disease disease;
        try{
            while (resultSet.next()){
                int id = resultSet.getInt("iddisease");
                int typeId = resultSet.getInt("idType");
                int visitingId = resultSet.getInt("idVisiting");
                String description = resultSet.getString("description");
                //DiseaseType diseaseType = diseaseTypeRepository.findOneById(typeId).get();
                disease = new Disease(id, typeId,visitingId, description);
                diseases.add(disease);
            }
        }catch (SQLException ex){
            System.out.println("Ошибка чтения данных");
        }
        return diseases;
    }

    @Override
    public Optional<Disease> findOneById(int id) {
        Optional<Disease> disease = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM disease where iddisease = " + id);
            disease = mapper(resultSet).stream().findFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }

        return disease;
    }

    @Override
    public Collection<Disease> findAllOfVisiting(int id) {
        Collection<Disease> diseases = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * from disease where idvisiting = " + id);
            while (resultSet.next()){
                int disId = resultSet.getInt("iddisease");
                int typeId = resultSet.getInt("idType");
                String description = resultSet.getString("description");
                //DiseaseType diseaseType = diseaseTypeRepository.findOneById(typeId).get();
                Disease disease = new Disease(disId, typeId,id, description);
                diseases.add(disease);
            }
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return diseases;
    }

    @Override
    public Disease save(Disease disease) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into disease(idtype, description, idvisiting) value(?, ?, ?)");

            statement.setInt(1, disease.getTypeId());
            statement.setString(2, disease.getDescription());
            statement.setInt(3, disease.getVisitingId());

        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
        return null;
    }

    @Override
    public void delete(Disease disease) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from disease where iddisease = ?");
            statement.setInt(1, disease.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
    }

//    @Override
//    public void update(Disease disease) {
//        PreparedStatement statement = null;
//        try {
//            statement = connection.prepareStatement("update disease set idtype = ?, description = ? where iddisease = ?");
//
//            statement.setInt(1, disease.getTypeId());
//            statement.setString(2, disease.getDescription());
//            statement.setInt(3, disease.getId());
//        } catch (SQLException e) {
//            System.out.println("Ошибка создания сессии.");
//        }
//        try {
//            statement.executeUpdate();
//        } catch (SQLException e) {
//            System.out.println("Ошибка выполнения запроса");
//        }
//    }

}
