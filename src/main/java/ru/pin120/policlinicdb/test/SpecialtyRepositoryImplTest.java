package ru.pin120.policlinicdb.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.pin120.policlinicdb.models.DiseaseType;
import ru.pin120.policlinicdb.models.Specialty;
import ru.pin120.policlinicdb.repository.DiseaseTypeRepositoryImpl;
import ru.pin120.policlinicdb.repository.SpecialtyRepositoryImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collection;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SpecialtyRepositoryImplTest {

    final static String DB_URL =
            "jdbc:mysql://localhost:3306/"; /*База данных*/
    final static String LOGIN = "root";
    final static String PASSWORD = "root";
    static Connection connection;
    private SpecialtyRepositoryImpl specialtyRepository;

    @BeforeEach
    void setup() {
        // Установка соединения с базой данных

        try {
            connection = DriverManager.getConnection(DB_URL, LOGIN, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        // Создание базы данных для тестирования
        createTestDatabase();

        // Инициализация репозитория
        specialtyRepository = new SpecialtyRepositoryImpl();
        specialtyRepository.setConnection(connection);
    }


    @AfterEach
    void cleanup() {
        // Удаление базы данных для тестирования
        dropTestDatabase();

        // Закрытие соединения с базой данных
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    private void createTestDatabase() {
        try (Statement statement = connection.createStatement()) {
            // Создание базы данных
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS `policlinicdbtest` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;");
            statement.executeUpdate("USE `policlinicdbtest`;");

            // Создание таблиц
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `disease` ( `iddisease` INT NOT NULL AUTO_INCREMENT, `idType` INT NOT NULL, `description` VARCHAR(250) NOT NULL, PRIMARY KEY (`iddisease`));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `diseasetype` ( `iddiseaseType` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NOT NULL, PRIMARY KEY (`iddiseaseType`));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `doctor` ( `iddoctor` INT NOT NULL AUTO_INCREMENT, `firstName` VARCHAR(45) NOT NULL, `lastName` VARCHAR(45) NOT NULL, `patr` VARCHAR(45) NULL DEFAULT NULL, `workExp` INT NOT NULL, `photoPath` VARCHAR(45) NULL DEFAULT NULL, PRIMARY KEY (`iddoctor`));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `patient` ( `idpatient` INT NOT NULL AUTO_INCREMENT, `firstName` VARCHAR(45) NOT NULL, `lastName` VARCHAR(45) NOT NULL, `patr` VARCHAR(45) NULL DEFAULT NULL, `birthDate` DATE NOT NULL, `area` VARCHAR(45) NOT NULL, `city` VARCHAR(45) NOT NULL, `house` VARCHAR(5) NOT NULL, `apartment` INT NULL DEFAULT NULL, PRIMARY KEY (`idpatient`));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `specialty` ( `idspecialty` INT NOT NULL AUTO_INCREMENT, `name` VARCHAR(45) NOT NULL, PRIMARY KEY (`idspecialty`));");
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS `visiting` ( `idvisiting` INT NOT NULL AUTO_INCREMENT, `iddoctor` INT NOT NULL, `idpatient` INT NOT NULL, `date` DATE NOT NULL, PRIMARY KEY (`idvisiting`));");
            statement.executeUpdate("CREATE TABLE if not exists `doctor-specialty`(`iddoctor` INT NULL, `idspecialty` INT NULL);");


            //Заполнение данными
            statement.executeUpdate("insert into specialty(name) value('Сомнолог')");
            statement.executeUpdate("insert into specialty(name) value('Офтальмолог')");
            statement.executeUpdate("insert into specialty(name) value('Стоматолог')");

//            statement.executeUpdate("insert into patient(firstname, lastname, patr, birthdate, area, city, house, apartment) values('Александр','Солнцев','Владимирович','1997-05-05','Владимирская','Муром','93',16)");
//            statement.executeUpdate("insert into patient(firstname, lastname, patr, birthdate, area, city, house, apartment) values('Владимир','Солнцев','Владимирович','1995-11-05','Владимирская','Муром','73',4)");
//            statement.executeUpdate("insert into patient(firstname, lastname, patr, birthdate, area, city, house, apartment) values('Сергей','Колосков','Николаевич','2000-01-05','Нижерородская','Новашино','102',1)");
//            statement.executeUpdate("insert into patient(firstname, lastname, patr, birthdate, area, city, house, apartment) values('Николай','Донцов','Олегович','2001-12-12','Владимирская','Муром','9',6)");
//
//            statement.executeUpdate("insert into patient(firstname, lastname, patr, birthdate, area, city, house, apartment) values('Николай','Донцов','Олегович','2001-12-12','Владимирская','Муром','9',6)");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTestDatabase() {
        try (Statement statement = connection.createStatement()) {
            // Удаление базы данных
            statement.executeUpdate("DROP DATABASE IF EXISTS `policlinicdbtest`;");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    @Test
    void findAll() {
        Collection<Specialty> specialties = specialtyRepository.findAll();
        assertEquals(3, specialties.size(), "Ошибка в количестве");
    }

    @Test
    void findOneByIdFirstTrue() {
        Specialty specialty = specialtyRepository.findOneById(1).get();
        assertEquals("Сомнолог", specialty.getName(), "Ошибка в навзвании");
    }

    @Test
    void findOneById() {
        int id = 3;
        Optional<Specialty> specialty = specialtyRepository.findOneById(id);
        assertTrue(specialty.isPresent());
        assertEquals(id, specialty.get().getId(), "Ошибка в индексе");
    }

    @Test
    void save() {
        Specialty specialty = new Specialty("Анестезиолог");
        specialtyRepository.save(specialty);
        Optional<Specialty> savedSpec = specialtyRepository.findOneById(4);
        assertTrue(savedSpec.isPresent());
        assertEquals(specialty.getName(), savedSpec.get().getName(), "Несовпадение названия");
        specialtyRepository.delete(savedSpec.get());
    }

    @Test
    void delete() {
        int id = 4;
        Specialty specialty = new Specialty("Дальнозоркость");
        specialtyRepository.save(specialty);
        specialty = specialtyRepository.findOneById(id).get();
        specialtyRepository.delete(specialty);
        Optional<Specialty> deleted = specialtyRepository.findOneById(id);
        assertFalse(deleted.isPresent());
    }

    @Test
    void update() {
        int id = 2;
        Specialty specialty = specialtyRepository.findOneById(id).get();
        specialty.setName("Слепота");

        specialtyRepository.update(specialty);
        Optional<Specialty> updated = specialtyRepository.findOneById(id);
        assertTrue(updated.isPresent());
        assertEquals(specialty.getName(), updated.get().getName());

        specialty.setName("Офтальмолог");

        specialtyRepository.update(specialty);
    }
}