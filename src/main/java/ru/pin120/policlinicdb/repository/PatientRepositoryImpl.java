package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;

public class PatientRepositoryImpl implements PatientRepository{

    private Connection connection;
    public PatientRepositoryImpl(Connection connection){
        this.connection = connection;
    }
    @Override
    public Collection<Patient> findAll() {
        Collection<Patient> patients = null;
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM patient");
            patients = mapper(resultSet);
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return patients;
    }

    private Collection<Patient> mapper(ResultSet resultSet){
        Collection<Patient> patients = new ArrayList<>();
        Patient patient;
        try{
            while (resultSet.next()){
                int id = resultSet.getInt("idpatient");
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String patr = resultSet.getString("patr");
                String area = resultSet.getString("area");
                String city = resultSet.getString("city");
                String house = resultSet.getString("house");
                int apart = resultSet.getInt("apartment");
                String birth = resultSet.getString("birthDate");

                patient = new Patient(id, firstName, lastName, patr, birth, area, city, house, apart);
                patients.add(patient);
            }
        }catch (SQLException ex){
            System.out.println("Ошибка чтения данных");
        }
        return patients;
    }

    @Override
    public Optional<Patient> findOneById(int id) {
        Optional<Patient> patient = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM patient where idpatient = " + id);
            patient = mapper(resultSet).stream().findFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }

        return patient;
    }

    @Override
    public Patient save(Patient patient) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into patient (firstName, lastName, patr, birthDate, area, city, house, apartment) values(?,?,?,?,?,?,?,?)");

            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getLastName());
            statement.setString(3, patient.getPatr());
            statement.setString(4, patient.getBirthDate());
            statement.setString(5, patient.getArea());
            statement.setString(6, patient.getCity());
            statement.setString(7, patient.getHouse());
            statement.setInt(8, patient.getApartment());

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
    public void delete(Patient patient) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from patient where idpatient = ?");
            statement.setInt(1, patient.getId());
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
    public void update(Patient patient) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update patient set firstName = ?, lastName = ?, patr = ?, birthDate = ?, area = ?, city = ?, house = ?, apartment = ? where idpatient = ?");

            statement.setString(1, patient.getFirstName());
            statement.setString(2, patient.getLastName());
            statement.setString(3, patient.getPatr());
            statement.setString(4, patient.getBirthDate());
            statement.setString(5, patient.getArea());
            statement.setString(6, patient.getCity());
            statement.setString(7, patient.getHouse());
            statement.setInt(8, patient.getApartment());
            statement.setInt(9, patient.getId());
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
