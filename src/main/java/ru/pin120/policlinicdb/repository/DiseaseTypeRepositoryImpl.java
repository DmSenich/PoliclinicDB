package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.DiseaseType;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class DiseaseTypeRepositoryImpl implements DiseaseTypeRepository{
    private Connection connection;
    public DiseaseTypeRepositoryImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public Collection<DiseaseType> findAll() {
        Collection<DiseaseType> diseaseTypes = null;
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM diseasetype");
            diseaseTypes = mapper(resultSet);
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return diseaseTypes;
    }
    private Collection<DiseaseType> mapper(ResultSet resultSet){
        Collection<DiseaseType> diseaseTypes = new ArrayList<>();
        DiseaseType diseaseType;
        try{
            while (resultSet.next()){
                int id = resultSet.getInt("iddiseasetype");
                String name = resultSet.getString("name");

                diseaseType = new DiseaseType(id, name);
                diseaseTypes.add(diseaseType);
            }
        }catch (SQLException ex){
            System.out.println("Ошибка чтения данных");
        }
        return diseaseTypes;
    }

    @Override
    public Optional<DiseaseType> findOneById(int id) {
        Optional<DiseaseType> diseaseType = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM diseasetype where iddiseasetype = " + id);
            diseaseType = mapper(resultSet).stream().findFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }

        return diseaseType;
    }
    @Override
    public DiseaseType save(DiseaseType diseaseType) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into diseasetype (name) value(?)");

            statement.setString(1, diseaseType.getName());

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
    public void update(DiseaseType diseaseType){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update diseasetype set name = ? where iddiseasetype = ?");

            statement.setString(1, diseaseType.getName());
            statement.setInt(2, diseaseType.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
    }
    @Override
    public void delete(DiseaseType diseaseType){
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from diseasetype where iddiseasetype = ?");
            statement.setInt(1, diseaseType.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
    }


}
