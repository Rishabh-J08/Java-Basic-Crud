package main;

import models.Patient;
import services.PatientService;
import java.util.*;
public class PatientManagementApp {
private static final Scanner sc = new Scanner(System.in);
private static final PatientService patientService = new PatientService();

    public static void main(String[] args) {
        while(true) {
            System.out.println("\nPatient Management System");
            System.out.println("1. Add Patient");
            System.out.println("2. View Patient");
            System.out.println("3. Update Patient");
            System.out.println("4. Update Patient Name");
            System.out.println("5. Update Patient Age");
            System.out.println("6. Delete Patient");
            System.out.println("7. Display All Patients");
            System.out.println("8. Exit");

            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch(choice){
                case 1:
                    addPatient();
                    break;
                case 2:
                    viewPatient();
                    break;
                case 3:
                    updatePatient();
                    break;
                case 4:
                    updatePatientName();
                    break;
                case 5:
                    updatePatientAge();
                    break;
                case 6:
                    deletePatient();
                    break;
                case 7:
                    patientService.displayAllPatients();
                    break;
                case 8:
                    System.out.println("Exiting the system");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again");
            }
        }


        }

    private static void addPatient() {
        System.out.println("Enter the Patient id: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the Patient Name: ");
        String name = sc.nextLine();
        System.out.println("Enter the age of the Patient: ");
        int age =  sc.nextInt();

        Patient patient = new Patient(id,name,age);
        patientService.addPatient(patient);
        System.out.println("Patient added Successfully");
    }

    private static void viewPatient(){
        System.out.println("Enter the patient id to view: ");
        int id = sc.nextInt();
        Patient patient = patientService.getPatientById(id);
        if(patient != null){
            System.out.println("Patient details: " + patient);
        } else {
            System.out.println("Details not found");
        }
    }

    private static void updatePatient(){
        System.out.println("Enter the patient id to update");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the new name: ");
        String name = sc.nextLine();
        System.out.println("Enter the new age: ");
        int age = sc.nextInt();

        boolean updated = patientService.updatePatient(id,name,age);
        if(updated){
            System.out.println("Patient details updated successfully");
        } else {
            System.out.println("patient not found");
        }
    }
    private static void deletePatient(){
        System.out.println("Enter the patient id: ");
        int id = sc.nextInt();

        boolean deleted = patientService.deletePatient(id);
        if(deleted){
            System.out.println("Patient Deleted Successfully");
        } else {
            System.out.println("Patient not found");
        }

    }

    private static void updatePatientName(){
        System.out.println("Enter the Patient id: ");
        int id = sc.nextInt();
        sc.nextLine();
        String name = sc.nextLine();
        boolean updated = patientService.updatePatientName(name, id);
        if(updated){
            System.out.println("name updated successfully");
        } else {
            System.out.println("Patient not found");
        }
    }
    private static void updatePatientAge(){
        System.out.println("Enter the Patient id: ");
        int id = sc.nextInt();
        sc.nextLine();
        int age = sc.nextInt();
        boolean updated = patientService.updatePatientAge(age, id);
        if(updated){
            System.out.println("age updated successfully");
        } else {
            System.out.println("Patient not found");
        }
    }

    }


