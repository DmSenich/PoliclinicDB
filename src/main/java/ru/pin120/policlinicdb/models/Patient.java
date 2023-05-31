package ru.pin120.policlinicdb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Patient {
    private int id;
    private String firstName;
    private String lastName;
    private String patr;
    private String birthDate;
    private String area, city, house;
    private int apartment;

//    public Patient(int id, String firstName, String lastName, String part, Date birthDate) {
//        this.id = id;
//        this.firstName = firstName;
//        this.lastName = lastName;
//        if(part != null){
//            this.part = part;
//        }
//        this.birthDate = birthDate;
//    }

    public Patient(String firstName, String lastName, String patr, String birthDate, String area, String city, String house, int apartment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.patr = patr;
        this.birthDate = birthDate;
        this.area = area;
        this.city = city;
        this.house = house;
        this.apartment = apartment;
    }

//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public void setFirstName(String firstName) {
//        this.firstName = firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//
//    public void setLastName(String lastName) {
//        this.lastName = lastName;
//    }
//
//    public String getPart() {
//        return part;
//    }
//
//    public void setPart(String part) {
//        this.part = part;
//    }
//
//    public Date getBirthDate() {
//        return birthDate;
//    }
//
//    public void setBirthDate(Date birthDate) {
//        this.birthDate = birthDate;
//    }
}
