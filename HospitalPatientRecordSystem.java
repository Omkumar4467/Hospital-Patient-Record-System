
import java.util.*;
import java.io.*;

class Patient {
    String patientId;
    String name;
    int age;
    String disease;

    Patient(String patientId, String name, int age, String disease) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.disease = disease;
    }

    void display() {
        System.out.println(patientId + " | " + name + " | " + age + " | " + disease);
    }
}

public class HospitalPatientRecordSystem {

    static ArrayList<Patient> patients = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    static final String FILE_NAME = "patients.txt";
    static int nextId = 101;

    static void loadPatients() {
        try {
            File file = new File(FILE_NAME);

            if (!file.exists()) {
                return;
            }

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;

            while ((line = br.readLine()) != null) {
                String[] data = line.split("\\|");

                if (data.length == 4) {
                    String id = data[0].trim();
                    String name = data[1].trim();
                    int age = Integer.parseInt(data[2].trim());
                    String disease = data[3].trim();

                    patients.add(new Patient(id, name, age, disease));

                    int idNumber = Integer.parseInt(id.substring(2));

                    if (idNumber >= nextId) {
                        nextId = idNumber + 1;
                    }
                }
            }

            br.close();

        } catch (Exception e) {
            System.out.println("Error loading patient records.");
        }
    }

    static void registerPatient() {

        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine().trim();

        if (name.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        System.out.print("Enter Age: ");
        int age;

        try {
            age = Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Invalid age.");
            return;
        }

        if (age < 0 || age > 120) {
            System.out.println("Invalid age. Age must be between 0 and 120.");
            return;
        }

        System.out.print("Enter Disease: ");
        String disease = sc.nextLine().trim();

        if (disease.isEmpty()) {
            System.out.println("Disease cannot be empty.");
            return;
        }

        String id = "PT" + nextId;

        Patient p = new Patient(id, name, age, disease);

        patients.add(p);

        nextId++;

        System.out.println("Patient registered.");
        System.out.print("ID: ");
        p.display();
    }

    static void displayAllPatients() {

        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        System.out.println("\n----- All Patient Records -----");

        for (int i = 0; i < patients.size(); i++) {
            System.out.print((i + 1) + ". ");
            patients.get(i).display();
        }
    }

    static void searchPatient() {

        System.out.print("Enter patient name to search: ");
        String searchName = sc.nextLine().trim();

        if (searchName.isEmpty()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        boolean found = false;

        for (int i = 0; i < patients.size(); i++) {

            Patient p = patients.get(i);

            if (p.name.toLowerCase().contains(searchName.toLowerCase())) {

                System.out.print("Found: ");
                p.display();

                found = true;
            }
        }

        if (!found) {
            System.out.println("Patient not found.");
        }
    }

    static void sortPatientsByAge() {

        if (patients.isEmpty()) {
            System.out.println("No patient records found.");
            return;
        }

        int n = patients.size();

        for (int i = 0; i < n - 1; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (patients.get(j).age > patients.get(j + 1).age) {

                    Patient temp = patients.get(j);

                    patients.set(j, patients.get(j + 1));

                    patients.set(j + 1, temp);
                }
            }
        }

        System.out.println("\nPatients sorted by age (low to high):");

        displayAllPatients();
    }

    static void savePatients() {

        try {
            PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME));

            for (Patient p : patients) {

                pw.println(
                    p.patientId + " | " +
                    p.name + " | " +
                    p.age + " | " +
                    p.disease
                );
            }

            pw.close();

            System.out.println("Patient records saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving patient records.");
        }
    }

    public static void main(String[] args) {

        loadPatients();

        int choice=0;

        do {
            System.out.println("\n===== HOSPITAL PATIENT RECORD SYSTEM =====");
            System.out.println("1. Register Patient");
            System.out.println("2. Display All Patients");
            System.out.println("3. Search by Name");
            System.out.println("4. Sort by Age (Low to High)");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");

            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid menu choice.");
                continue;
            }

            switch (choice) {

                case 1:
                    registerPatient();
                    break;

                case 2:
                    displayAllPatients();
                    break;

                case 3:
                    searchPatient();
                    break;

                case 4:
                    sortPatientsByAge();
                    break;

                case 5:
                    savePatients();
                    System.out.println("Thank you for using the system.");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 5);
    }
}
