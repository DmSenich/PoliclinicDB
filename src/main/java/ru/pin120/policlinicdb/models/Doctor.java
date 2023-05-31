package ru.pin120.policlinicdb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    private int id;
    private String firstName;
    private String lastName;
    private String patr;
    private int workExp;
    //private List<Specialty> specialties;

//    public Doctor(int id, String firstName, String lastName, String part, String specialties) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        if(part != null){
//            this.part = part;
//        }
//        this.specialties = specialties;
//    }

//    public Doctor(String firstName, String lastName, String part, int workExp, List<Specialty> specialties) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        if(part != null){
//            this.patr = part;
//        }
//        this.workExp = workExp;
//        this.specialties = specialties;
//    }
//    public Doctor(int id, String firstName, String lastName, String part, int workExp) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        if(part != null){
//            this.patr = part;
//        }
//        this.workExp = workExp;
//        //this.specialties = specialties;
//    }

    public Doctor(String firstName, String lastName, String patr, int workExp) {
        this.firstName = firstName;
        this.lastName = lastName;
        if(patr != null){
            this.patr = patr;
        }
        this.workExp = workExp;
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
