/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital.main;

/**
 *
 * @author SIYANDA
 */
public class Bed {
    // Represents a hospital bed

    private String bedId;
    private Patient patient;

    // Creates an empty bed
    public Bed(String bedId) {
        this.bedId = bedId;
        this.patient = null;
    }

    public String getBedId() {
        return bedId;
    }

    public Patient getPatient() {
        return patient;
    }

    // Checks whether the bed is available
    public boolean isAvailable() {
        return patient == null;
    }

    // Assigns a patient to the bed
    public void allocate(Patient patient) {
        this.patient = patient;
    }

    // Removes the patient from the bed
    public void release() {
        this.patient = null;
    }

    // Displays the current bed status
    public void displayBed() {

        if (isAvailable()) {

            System.out.println(bedId + " - AVAILABLE");

        } else {

            System.out.println(
                    bedId + " - OCCUPIED by "
                            + patient.getPatientId()
                            + " ("
                            + patient.getFirstName()
                            + " "
                            + patient.getLastName()
                            + ")"
            );
        }
    }
}
