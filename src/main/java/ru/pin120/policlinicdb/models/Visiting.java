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
public class Visiting {
    private int id;
    private int doctorId;
    //private Doctor doctor;
    private int patientId;
    //private Patient patient;
    //private List<Disease> diseases;
    private String date;

//    public Visiting(int id, int doctorId, int patientId, String disease, Date date) {
//        this.id = id;
//        this.doctorId = doctorId;
//        this.patientId = patientId;
//        if(disease != null){
//            this.disease = disease;
//        }
//        this.date = date;
//    }

//    public Visiting(Doctor doctor, Patient patient, String date, List<Disease> diseases) {
//        this.doctor = doctor;
//        this.doctorId = doctor.getId();
//        this.patient = patient;
//        this.patientId = patient.getId();
//        this.diseases = diseases;
//        this.date = date;
//    }
//    public Visiting(int id, Doctor doctor, Patient patient, String date, List<Disease> diseases) {
//        this.id = id;
//        this.doctor = doctor;
//        this.doctorId = doctor.getId();
//        this.patient = patient;
//        this.patientId = patient.getId();
//        this.diseases = diseases;
//        this.date = date;
//    }
    public Visiting(int doctorId, int patientId, String date) {
        this.doctorId = doctorId;
        this.patientId = patientId;
        //this.diseases = diseases;
        this.date = date;
    }
//    public Visiting(int id, int doctorId, int patientId, String date) {
//        this.id = id;
//        this.doctorId = doctorId;
//        this.patientId = patientId;
//        //this.diseases = diseases;
//        this.date = date;
//    }


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
