package ru.pin120.policlinicdb.repository;
import ru.pin120.policlinicdb.models.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class SpecialtyRepositoryImpl implements SpecialtyRepository{
    private Connection connection;
    public SpecialtyRepositoryImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public Collection<Specialty> findAll() {
        Collection<Specialty> specialties = null;
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM specialty");
            specialties = mapper(resultSet);
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return specialties;
    }

    private Collection<Specialty> mapper(ResultSet resultSet){
        Collection<Specialty> specialties = new ArrayList<>();
        Specialty specialty;
        try{
            while (resultSet.next()){
                int id = resultSet.getInt("idspecialty");
                String name = resultSet.getString("name");

                specialty = new Specialty(id, name);
                specialties.add(specialty);
            }
        }catch (SQLException ex){
            System.out.println("Ошибка чтения данных");
        }
        return specialties;
    }

    @Override
    public Optional<Specialty> findOneById(int id) {
        Optional<Specialty> specialty = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM specialty where idspecialty = " + id);
            specialty = mapper(resultSet).stream().findFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }

        return specialty;
    }

    @Override
    public Collection<Specialty> findAllOfDoctor(int id) {
        Collection<Specialty> specialties = new ArrayList<>();
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * from doctor_specialty where iddoctor = " + id);
            while (resultSet.next()){
                int idspecialty = resultSet.getInt("idspecialty");
                Specialty specialty = findOneById(idspecialty).get();
                specialties.add(specialty);
            }
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return specialties;
    }

    @Override
    public Specialty save(Specialty specialty) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into specialty (name) value(?)");

            statement.setString(1, specialty.getName());

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
    public void delete(Specialty specialty) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from specialty where idspecialty = ?");
            statement.setInt(1, specialty.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
        try {
            statement = connection.prepareStatement("delete from doctor_specialty where idspecialty = ?");
            statement.setInt(1, specialty.getId());
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
    public void update(Specialty specialty) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update specialty set name = ? where idspecialty = ?");

            statement.setString(1, specialty.getName());
            statement.setInt(2, specialty.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
    }
    public void setConnection(Connection connection){
        this.connection = connection;
    }
}
