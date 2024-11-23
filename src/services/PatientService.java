package services;
import models.Patient;

import java.util.ArrayList;
import java.util.List;

public class PatientService {

    private List<Patient> patientList;

    public PatientService(){
        patientList = new ArrayList<>();
    }
    public void addPatient(Patient patient){
        patientList.add(patient);
    }

    public Patient getPatientById(int id){
        for (Patient patient : patientList) {
            if(patient.getId() == id){
                return patient;
            }
        }
        return null;
    }

    public boolean updatePatient(int id, String name, int age){
        Patient patient = getPatientById(id);
        if(patient != null){
            patient.setName(name);
            patient.setAge(age);
            return true;
        }

        return false;
    }

    public boolean updatePatientName(String name, int id){
        Patient patient = getPatientById(id);
        if(patient!=null){
            patient.setName(name);
            return  true;
        }
        return false;
    }

    public boolean updatePatientAge(int age, int id){
        Patient patient = getPatientById(id);
        if(patient != null){
            patient.setAge(age);
        }
    return false;
    }

    public boolean deletePatient(int id){
        Patient patient = getPatientById(id);
        if(patient != null){
            patientList.remove(patient);
        }
        return false;
    }

    public void displayAllPatients(){
        if(patientList.isEmpty()){
            System.out.println("No Patient data available");
        } else {
            for(Patient patient : patientList){
                System.out.println((patient));
            }
        }
    }

}
