package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Disease;
import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.models.Patient;
import ru.pin120.policlinicdb.models.Visiting;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class VisitingRepositoryImpl implements VisitingRepository{
    private Connection connection;
    private DoctorRepositoryImpl doctorRepository;
    private  PatientRepositoryImpl patientRepository;
    private DiseaseRepositoryImpl diseaseRepository;

    public VisitingRepositoryImpl(Connection connection){
        this.connection = connection;
        doctorRepository = new DoctorRepositoryImpl(connection);
        patientRepository = new PatientRepositoryImpl(connection);
        diseaseRepository = new DiseaseRepositoryImpl(connection);
    }

    @Override
    public Collection<Visiting> findAll() {
        Collection<Visiting> visitings = null;
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM visiting");
            visitings = mapper(resultSet);
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return visitings;
    }

    private Collection<Visiting> mapper(ResultSet resultSet){
        Collection<Visiting> visitings = new ArrayList<>();
        try{
            while (resultSet.next()){
                int id = resultSet.getInt("idvisiting");
                int doctorId = resultSet.getInt("iddoctor");
                int patientId = resultSet.getInt("idpatient");
                String date = resultSet.getString("date");
//                Doctor doctor = doctorRepository.findOneById(doctorId).get();
//                Patient patient = patientRepository.findOneById(patientId).get();
//                List<Disease> diseases = diseaseRepository.findAllOfVisiting(id).stream().toList();
                Visiting visiting = new Visiting(id, doctorId, patientId, date);
                visitings.add(visiting);
            }
        }catch (SQLException ex){
            System.out.println("Ошибка чтения данных");
        }
        return visitings;
    }

    @Override
    public Optional<Visiting> findOneById(int id) {
        Optional<Visiting> visiting = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM visiting where idvisiting = " + id);
            visiting = mapper(resultSet).stream().findFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }

        return visiting;
    }

    @Override
    public Visiting save(Visiting visiting) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("INSERT into visiting(iddoctor, idpatient, date) value(?, ?, ?)");

            statement.setInt(1, visiting.getDoctorId());
            statement.setInt(2, visiting.getPatientId());
            statement.setString(3, visiting.getDate());

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
    public void delete(Visiting visiting) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from visiting where idvisiting = ?");
            statement.setInt(1, visiting.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
        try{
            statement = connection.prepareStatement("delete from disease where idvisiting = ?");
            statement.setInt(1, visiting.getId());
        }catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
    }

    @Override
    public void update(Visiting visiting) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update visiting set iddoctor = ?, idpatient = ?, date = ? where idvisiting = ?");

            statement.setInt(1, visiting.getDoctorId());
            statement.setInt(2, visiting.getPatientId());
            statement.setString(3, visiting.getDate());
            statement.setInt(4, visiting.getId());
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
