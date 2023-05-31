package ru.pin120.policlinicdb.repository;

import ru.pin120.policlinicdb.models.Doctor;
import ru.pin120.policlinicdb.models.Specialty;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class DoctorRepositoryImpl implements DoctorRepository {
    private Connection connection;
    private SpecialtyRepositoryImpl specialtyRepository;
    //private DoctorRepositoryImpl doctorRepository;
    //private DBHelper dbHelper;
    //public DoctorRepositoryImpl(){
//        DBHelper.connect();
//        connection = DBHelper.getConnection();
   // }
//    public void close(){
//        try{
//            DBHelper.disconnect();
//
//        }catch (SQLException ex){
//            System.out.println("Не возможно закрыть соединение");
//        }
//    }
    public DoctorRepositoryImpl(Connection connection){
        this.connection = connection;
        specialtyRepository = new SpecialtyRepositoryImpl(connection);
    }

    @Override
    public Collection<Doctor> findAll() {
        Collection<Doctor> doctors = null;
        Statement statement = null;
        try{
            statement = connection.createStatement();
        }
        catch (SQLException ex){
            System.out.println("Ошибка созданя сессии");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM doctor");
            doctors = mapper(resultSet);
        }
        catch (SQLException ex){
            System.out.println("Ошибка выполнения запроса");
        }
        return doctors;
    }

    private Collection<Doctor> mapper(ResultSet resultSet){
        Collection<Doctor> doctors = new ArrayList<>();
        Doctor doctor;
        try{
        while (resultSet.next()){
            int id = resultSet.getInt("iddoctor");
            String firstName = resultSet.getString("firstName");
            String lastName = resultSet.getString("lastName");
            String patr = resultSet.getString("patr");

            int workExp = resultSet.getInt("workExp");
            //List<Specialty> specialties = specialtyRepository.findAllOfDoctor(id).stream().toList();
            doctor = new Doctor(id, firstName, lastName, patr, workExp);
            doctors.add(doctor);
        }
        }catch (SQLException ex){
            System.out.println("Ошибка чтения данных");
        }
        return doctors;
    }

    @Override
    public Optional<Doctor> findOneById(int id) {
        Optional<Doctor> doctor = null;
        Statement statement = null;
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            ResultSet resultSet = statement.executeQuery("select * FROM doctor where iddoctor = " + id);
            doctor = mapper(resultSet).stream().findFirst();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }

        return doctor;
    }

    @Override
    public Doctor save(Doctor doctor) {
        PreparedStatement statement = null;
            try {
                statement = connection.prepareStatement("INSERT into doctor (firstName, lastName, patr, workExp) values(?,?,?,?)");

                statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getPatr());
            statement.setInt(4, doctor.getWorkExp());

        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
        statement = null;
//        if(doctor.getSpecialties().size() > 0){
//            try{
//                for (Specialty specialty:
//                     doctor.getSpecialties()) {
//                    statement = connection.prepareStatement("INSERT into doctor_specialty (iddoctor, idspecialty) values(?,?)");
//                    statement.setInt(1, doctor.getId());
//                    statement.setInt(2, specialty.getId());
//                }
//
//            }
//            catch (SQLException e){
//                System.out.println("Ошибка выполнения запроса");
//            }
//        }

        return null;
    }

    @Override
    public Doctor updateSpecialty(int id, List<Specialty> specialties) {
        Statement firststat = null;
        PreparedStatement statementDel = null;
        PreparedStatement statementIns = null;
        List<Specialty> oldSpecilties = specialtyRepository.findAllOfDoctor(id).stream().toList();
        try {
            ResultSet resultSet = firststat.executeQuery("select idspecialty from doctor where iddoctor = " + id);
            while (resultSet.next()){
                Specialty specialty = specialtyRepository.findOneById(resultSet.getInt("idspecialty")).get();
                specialties.add(specialty);
            }
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
        try{
            for (Specialty specialty:
                    oldSpecilties) {
                if(!specialties.contains(specialty)){
                    statementDel = connection.prepareStatement("delete from doctor_specialty where iddoctor = ? and idspecialty = ?");
                    statementDel.setInt(1, id);
                    statementDel.setInt(2, specialty.getId());
                    statementDel.executeUpdate();
                }
            }
            for (Specialty specialty:
                    specialties) {
                if(!oldSpecilties.contains(specialty)){
                    statementIns = connection.prepareStatement("INSERT into doctor_specialty (iddoctor, idspecialty) values(?,?)");
                    statementIns.setInt(1, id);
                    statementIns.setInt(2, specialty.getId());
                    statementIns.executeUpdate();
                }
            }
        }
        catch (SQLException e){
            System.out.println("Ошибка выполнения запроса");
        }
        return null;
    }

    @Override
    public void delete(Doctor doctor) {
        List<Specialty> specialties = specialtyRepository.findAllOfDoctor(doctor.getId()).stream().toList();
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("delete from doctor where iddoctor = ?");
            statement.setInt(1, doctor.getId());
        } catch (SQLException e) {
            System.out.println("Ошибка создания сессии.");
        }
        try {
            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Ошибка выполнения запроса");
        }
        if(specialties.size() > 0){
            try{
                statement = connection.prepareStatement("delete from doctor_specialty where iddoctor = ?");
                statement.setInt(1, doctor.getId());
                statement.executeUpdate();
            }
            catch (SQLException e){
                System.out.println("Ошибка выполнения запроса");
            }
        }
    }

    @Override
    public void update(Doctor doctor) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement("update doctor set firstName = ?, lastName = ?, patr = ?, workExp = ? where iddoctor = ?");

            statement.setString(1, doctor.getFirstName());
            statement.setString(2, doctor.getLastName());
            statement.setString(3, doctor.getPatr());
            statement.setInt(4, doctor.getWorkExp());
            statement.setInt(5, doctor.getId());
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
