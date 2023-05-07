package ru.pin120.policlinicdb.models;

import lombok.*;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String part;
    private int workExp;
    private List<Specialty> specialties;

//    public Doctor(int id, String firstName, String lastName, String part, String specialties) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        if(part != null){
//            this.part = part;
//        }
//        this.specialties = specialties;
//    }

    public Doctor(String firstName, String lastName, String part, int workExp, List<Specialty> specialties) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(part != null){
            this.part = part;
        }
        this.workExp = workExp;
        this.specialties = specialties;
    }

//    public int getId() {
//        return id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public String getPart() {
//        return part;
//    }
//
//    public String getSpecialties() {
//        return specialties;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public void setPart(String part) {
//        this.part = part;
//    }
//
//    public void setSpecialties(String specialties) {
//        this.specialties = specialties;
//    }

}
