import java.util.ArrayList;
import java.util.List;

// Abstraction & Encapsulation
abstract class Patient {
    private String patientId;
    private String name;
    private int age;

    // Abstraction
    public abstract double calculateBill();

    public Patient(String patientId, String name, int age) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
    }

    // Concrete method for patient details
    public void getPatientDetails() {
        System.out.println("Patient ID: " + patientId);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    // Encapsulation
    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}

// Abstraction
interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

// Inheritance & Abstraction
class InPatient extends Patient implements MedicalRecord {
    private double dailyRoomCharge;
    private int daysAdmitted;
    // Encapsulation
    private List<String> medicalHistory = new ArrayList<>();

    public InPatient(String patientId, String name, int age, double dailyRoomCharge, int daysAdmitted) {
        super(patientId, name, age);
        this.dailyRoomCharge = dailyRoomCharge;
        this.daysAdmitted = daysAdmitted;
    }

    // Abstraction
    @Override
    public double calculateBill() {
        return dailyRoomCharge * daysAdmitted;
    }

    // Abstraction
    @Override
    public void addRecord(String record) {
        this.medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Patient Type: In-Patient");
        System.out.println("Days Admitted: " + daysAdmitted);
    }
}

// Inheritance & Abstraction
class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    // Encapsulation
    private List<String> medicalHistory = new ArrayList<>();

    public OutPatient(String patientId, String name, int age, double consultationFee) {
        super(patientId, name, age);
        this.consultationFee = consultationFee;
    }

    // Abstraction
    @Override
    public double calculateBill() {
        return consultationFee;
    }

    // Abstraction
    @Override
    public void addRecord(String record) {
        this.medicalHistory.add(record);
    }

    @Override
    public List<String> viewRecords() {
        return medicalHistory;
    }

    @Override
    public void getPatientDetails() {
        super.getPatientDetails();
        System.out.println("Patient Type: Out-Patient");
    }
}

// Main class to demonstrate the hospital system
public class HospitalPatientManagement {
    public static void main(String[] args) {
        // Polymorphism
        List<Patient> patients = new ArrayList<>();

        // Creating instances of concrete classes
        InPatient patient1 = new InPatient("P-001", "Jane Smith", 45, 250.00, 5);
        OutPatient patient2 = new OutPatient("P-002", "Mark Johnson", 32, 120.00);

        // Add records using polymorphism
        patient1.addRecord("Admitted for pneumonia.");
        patient1.addRecord("Started IV antibiotics.");
        patient2.addRecord("Diagnosed with common cold.");

        // Adding patients to the list
        patients.add(patient1);
        patients.add(patient2);

        System.out.println("--- Hospital Patient List ---");
        // Polymorphism
        for (Patient patient : patients) {
            patient.getPatientDetails();
            System.out.println("Total Bill: $" + String.format("%.2f", patient.calculateBill()));

            // Polymorphism with the MedicalRecord interface
            if (patient instanceof MedicalRecord) {
                MedicalRecord patientRecord = (MedicalRecord) patient;
                System.out.println("Medical Records: " + patientRecord.viewRecords());
            }

            System.out.println("---------------------------------");
        }
    }
}