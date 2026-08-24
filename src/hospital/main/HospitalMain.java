/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital.main;

import java.util.ArrayList;
import java.util.Scanner;
public class HospitalMain {
    // Stores patients and hospital beds
    private static final Scanner scanner = new Scanner(System.in);
    private static final ArrayList<Patient> patients = new ArrayList<>();
    private static final ArrayList<Bed> beds = new ArrayList<>();

    public static void main(String[] args) {

        // Create the 20 hospital beds
        initialiseBeds();

        int choice;

        // Display the menu until the user chooses to exit
        do {

            displayMenu();
            choice = readInt("Enter your choice: ");

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    searchPatient();
                    break;

                case 3:
                    updatePatient();
                    break;

                case 4:
                    deletePatient();
                    break;

                case 5:
                    displayAllPatients();
                    break;

                case 6:
                    allocateBed();
                    break;

                case 7:
                    releaseBed();
                    break;

                case 8:
                    displayWardLayout();
                    break;

                case 9:
                    displayAvailableBeds();
                    break;

                case 10:
                    displayOccupiedBeds();
                    break;

                case 11:
                    displayReports();
                    break;

                case 0:
                    System.out.println(
                            "Exiting Hospital Patient Admission System..."
                    );
                    break;

                default:
                    System.out.println(
                            "Invalid choice. Please try again."
                    );
            }

        } while (choice != 0);

        scanner.close();
    }

    // Creates 20 beds for the hospital ward
    private static void initialiseBeds() {

        for (int i = 1; i <= 20; i++) {
            beds.add(new Bed(String.format("B%02d", i)));
        }
    }

    // Displays the main menu
    private static void displayMenu() {

        System.out.println();
        System.out.println("  ");
        System.out.println("      MEDICARE HOSPITAL ADMISSION SYSTEM");
        System.out.println("   ");

        System.out.println("1. Register new patient");
        System.out.println("2. Search patient by ID");
        System.out.println("3. Update patient");
        System.out.println("4. Delete patient");
        System.out.println("5. Display all patients");
        System.out.println("6. Allocate bed");
        System.out.println("7. Release bed");
        System.out.println("8. Display complete ward layout");
        System.out.println("9. Display available beds");
        System.out.println("10. Display occupied beds");
        System.out.println("11. Generate ward reports");
        System.out.println("0. Exit");

        System.out.println("   ");
    }

    // Registers a new patient
    private static void registerPatient() {

        System.out.println();
        System.out.println("--- Register New Patient ---");

        String id = readNonEmpty("Patient ID: ");

        if (findPatient(id) != null) {
            System.out.println("A patient with that ID already exists.");
            return;
        }

        String firstName = readNonEmpty("First Name: ");
        String lastName = readNonEmpty("Last Name: ");
        int age = readPositiveInt("Age: ");
        String gender = readNonEmpty("Gender: ");
        String condition = readNonEmpty("Medical Condition: ");

        PatientCategory category = readCategory();

        Patient patient;

        // Create an Inpatient object when required
        if (category == PatientCategory.INPATIENT) {

            patient = new Inpatient(
                    id, firstName, lastName, age,
                    gender, condition
            );

        } else {

            patient = new Patient(
                    id, firstName, lastName, age,
                    gender, condition, category
            );
        }

        patients.add(patient);

        System.out.println("Patient registered successfully.");
    }

    // Searches for a patient using their ID
    private static void searchPatient() {

        System.out.println();
        System.out.println("--- Search Patient ---");

        String id = readNonEmpty("Enter Patient ID: ");

        Patient patient = findPatient(id);

        if (patient == null) {

            System.out.println("Patient not found.");

        } else {

            patient.displayPatient();

            Bed bed = findBedByPatient(id);

            if (bed != null) {
                System.out.println("Bed: " + bed.getBedId());
            } else {
                System.out.println("Bed: No bed allocated");
            }
        }
    }

    // Updates an existing patient's details
    private static void updatePatient() {

        System.out.println();
        System.out.println("--- Update Patient ---");

        String id = readNonEmpty("Enter Patient ID: ");

        Patient patient = findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        System.out.println(
                "Leave a field blank to keep the current value."
        );

        String input;

        input = readLine(
                "First Name [" + patient.getFirstName() + "]: "
        );

        if (!input.isEmpty()) {
            patient.setFirstName(input);
        }

        input = readLine(
                "Last Name [" + patient.getLastName() + "]: "
        );

        if (!input.isEmpty()) {
            patient.setLastName(input);
        }

        input = readLine(
                "Age [" + patient.getAge() + "]: "
        );

        if (!input.isEmpty()) {

            try {

                int age = Integer.parseInt(input);

                if (age > 0) {
                    patient.setAge(age);
                } else {
                    System.out.println("Invalid age. Old age kept.");
                }

            } catch (NumberFormatException e) {

                System.out.println("Invalid age. Old age kept.");
            }
        }

        input = readLine(
                "Gender [" + patient.getGender() + "]: "
        );

        if (!input.isEmpty()) {
            patient.setGender(input);
        }

        input = readLine(
                "Medical Condition [" +
                        patient.getMedicalCondition() + "]: "
        );

        if (!input.isEmpty()) {
            patient.setMedicalCondition(input);
        }

        System.out.println("Patient updated successfully.");
    }

    // Deletes a patient and releases their bed
    private static void deletePatient() {

        System.out.println();
        System.out.println("--- Delete Patient ---");

        String id = readNonEmpty("Enter Patient ID: ");

        Patient patient = findPatient(id);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        Bed bed = findBedByPatient(id);

        if (bed != null) {
            bed.release();
            System.out.println(
                    "Allocated bed " + bed.getBedId() + " released."
            );
        }

        patients.remove(patient);

        System.out.println("Patient deleted successfully.");
    }

    // Displays all registered patients
    private static void displayAllPatients() {

        System.out.println();
        System.out.println("--- All Registered Patients ---");

        if (patients.isEmpty()) {
            System.out.println("No patients are registered.");
            return;
        }

        for (Patient patient : patients) {
            patient.displayPatient();
            System.out.println("");
        }
    }

    // Allocates an available bed to an inpatient
    private static void allocateBed() {

        System.out.println();
        System.out.println("Allocate Bed");

        String patientId = readNonEmpty("Enter inpatient ID: ");

        Patient patient = findPatient(patientId);

        if (patient == null) {
            System.out.println("Patient not found.");
            return;
        }

        if (patient.getCategory() != PatientCategory.INPATIENT) {
            System.out.println(
                    "Only inpatients may be allocated a hospital bed."
            );
            return;
        }

        if (findBedByPatient(patientId) != null) {
            System.out.println("This patient already has a bed.");
            return;
        }

        Bed availableBed = findFirstAvailableBed();

        if (availableBed == null) {
            System.out.println("No beds are currently available.");
            return;
        }

        availableBed.allocate(patient);

        System.out.println(
                "Bed " + availableBed.getBedId()
                        + " allocated to "
                        + patient.getFirstName()
                        + " "
                        + patient.getLastName() + "."
        );
    }

    // Releases a patient's allocated bed
    private static void releaseBed() {

        System.out.println();
        System.out.println("--- Release Bed ---");

        String patientId = readNonEmpty("Enter Patient ID: ");

        Bed bed = findBedByPatient(patientId);

        if (bed == null) {
            System.out.println(
                    "No bed is allocated to this patient."
            );
            return;
        }

        bed.release();

        System.out.println(
                "Bed " + bed.getBedId() +
                        " released successfully."
        );
    }

    // Displays all 20 beds and their current status
    private static void displayWardLayout() {

        System.out.println();
        System.out.println("--- Complete Ward Layout ---");

        for (int i = 0; i < beds.size(); i++) {

            beds.get(i).displayBed();

            if ((i + 1) % 5 == 0) {
                System.out.println();
            }
        }
    }

    // Displays all beds that are available
    private static void displayAvailableBeds() {

        System.out.println();
        System.out.println("--- Available Beds ---");

        boolean found = false;

        for (Bed bed : beds) {

            if (bed.isAvailable()) {
                System.out.println(bed.getBedId());
                found = true;
            }
        }

        if (!found) {
            System.out.println("No beds are available.");
        }
    }

    // Displays all occupied beds
    private static void displayOccupiedBeds() {

        System.out.println();
        System.out.println("--- Occupied Beds ---");

        boolean found = false;

        for (Bed bed : beds) {

            if (!bed.isAvailable()) {
                bed.displayBed();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No beds are occupied.");
        }
    }

    // Generates the ward report
    private static void displayReports() {

        int totalPatients = patients.size();
        int occupiedBeds = countOccupiedBeds();
        int availableBeds = beds.size() - occupiedBeds;

        // Calculate the percentage of occupied beds
        double occupancyPercentage =
                (occupiedBeds / (double) beds.size()) * 100;

        System.out.println();
        System.out.println("==============================================");
        System.out.println("             WARD REPORT");
        System.out.println("==============================================");

        System.out.println(
                "Registered Patients: " + totalPatients
        );

        System.out.println();
        System.out.println("--- Registered Patients ---");

        if (patients.isEmpty()) {

            System.out.println("None");

        } else {

            for (Patient patient : patients) {

                System.out.println(
                        patient.getPatientId() +
                                " - " +
                                patient.getFirstName() +
                                " " +
                                patient.getLastName() +
                                " - " +
                                patient.getCategory()
                );
            }
        }

        System.out.println();
        System.out.println(
                "Available Beds: " + availableBeds
        );

        displayAvailableBeds();

        System.out.println();
        System.out.println(
                "Occupied Beds: " + occupiedBeds
        );

        displayOccupiedBeds();

        System.out.println();
        System.out.println(
                "Total Number of Registered Patients: "
                        + totalPatients
        );

        System.out.println(
                "Total Number of Occupied Beds: "
                        + occupiedBeds
        );

        System.out.printf(
                "Ward Occupancy Percentage: %.2f%%%n",
                occupancyPercentage
        );

        System.out.println(
                "   "
        );
    }

    // Finds a patient using their ID
    private static Patient findPatient(String id) {

        for (Patient patient : patients) {

            if (patient.getPatientId()
                    .equalsIgnoreCase(id)) {

                return patient;
            }
        }

        return null;
    }

    // Finds the bed allocated to a patient
    private static Bed findBedByPatient(
            String patientId) {

        for (Bed bed : beds) {

            if (!bed.isAvailable()
                    && bed.getPatient()
                    .getPatientId()
                    .equalsIgnoreCase(patientId)) {

                return bed;
            }
        }

        return null;
    }

    // Finds the first available bed
    private static Bed findFirstAvailableBed() {

        for (Bed bed : beds) {

            if (bed.isAvailable()) {
                return bed;
            }
        }

        return null;
    }

    // Counts the number of occupied beds
    private static int countOccupiedBeds() {

        int count = 0;

        for (Bed bed : beds) {

            if (!bed.isAvailable()) {
                count++;
            }
        }

        return count;
    }

    // Gets the patient's category
    private static PatientCategory readCategory() {

        while (true) {

            System.out.println("Patient Category:");
            System.out.println("1. Inpatient");
            System.out.println("2. Outpatient");
            System.out.println("3. Emergency");

            int choice =
                    readInt("Choose category: ");

            switch (choice) {

                case 1:
                    return PatientCategory.INPATIENT;

                case 2:
                    return PatientCategory.OUTPATIENT;

                case 3:
                    return PatientCategory.EMERGENCY;

                default:
                    System.out.println(
                            "Invalid category."
                    );
            }
        }
    }

    // Reads an integer from the user
    private static int readInt(String message) {

        while (true) {

            try {

                return Integer.parseInt(
                        readNonEmpty(message)
                );

            } catch (NumberFormatException e) {

                System.out.println(
                        "Please enter a valid number."
                );
            }
        }
    }

    // Reads a positive integer
    private static int readPositiveInt(
            String message) {

        while (true) {

            int value = readInt(message);

            if (value > 0) {
                return value;
            }

            System.out.println(
                    "Please enter a number greater than 0."
            );
        }
    }

    // Makes sure the user enters a value
    private static String readNonEmpty(
            String message) {

        while (true) {

            String value = readLine(message);

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println(
                    "This field cannot be empty."
            );
        }
    }

    // Reads a line of input
    private static String readLine(
            String message) {

        System.out.print(message);

        return scanner.nextLine().trim();
    }
}


   