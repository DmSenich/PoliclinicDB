package ru.pin120.policlinicdb.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Visiting {
    private int id;
    private int doctorId;
    private int patientId;
    private String disease;
    private Date date;

//    public Visiting(int id, int doctorId, int patientId, String disease, Date date) {
//        this.id = id;
//        this.doctorId = doctorId;
//        this.patientId = patientId;
//        if(disease != null){
//            this.disease = disease;
//        }
//        this.date = date;
//    }

    public Visiting(int doctorId, int patientId, String disease, Date date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        if(disease != null){
            this.disease = disease;
        }
        this.date = date;
    }

//    public int getId() {
//        return id;
//    }
//
//    public int getDoctorId() {
//        return doctorId;
//    }
//
//    public int getPatientId() {
//        return patientId;
//    }
//
//    public String getDisease() {
//        return disease;
//    }
//    public Date getDate(){
//        return date;
//    }
}
