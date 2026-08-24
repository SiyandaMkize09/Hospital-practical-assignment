/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.main;

    // Inpatient inherits information from the Patient class
public class Inpatient extends Patient {

    // Creates an inpatient
    public Inpatient(String patientId, String firstName, String lastName,
                     int age, String gender, String medicalCondition) {

        super(patientId, firstName, lastName, age, gender,
                medicalCondition, PatientCategory.INPATIENT);
    }

    // Displays inpatient information
    @Override
    public void displayPatient() {
        System.out.println(" INPATIENT ");
        super.displayPatient();
    }
}
    

