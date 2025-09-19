import java.util.*;

class Patient {
    private String name;

    public Patient(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Doctor {
    private String name;
    private List<Patient> patients;

    public Doctor(String name) {
        this.name = name;
        this.patients = new ArrayList<>();
    }

    public void consult(Patient patient) {
        patients.add(patient);
        System.out.println("Doctor " + name + " is consulting patient " + patient.getName());
    }

    public void showPatients() {
        System.out.println("Doctor " + name + " has consulted:");
        for (Patient p : patients) {
            System.out.println(" - " + p.getName());
        }
    }
}

class Hospital {
    private String name;
    private List<Doctor> doctors;
    private List<Patient> patients;

    public Hospital(String name) {
        this.name = name;
        this.doctors = new ArrayList<>();
        this.patients = new ArrayList<>();
    }

    public void addDoctor(Doctor doctor) {
        doctors.add(doctor);
    }

    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    public void showHospital() {
        System.out.println("Hospital: " + name);
        System.out.println("Doctors: " + doctors.size() + ", Patients: " + patients.size());
    }
}

public class HospitalData {
    public static void main(String[] args) {
        Hospital hospital = new Hospital("Sarkaari Hospital");

        Doctor d1 = new Doctor("Dr. Tinku Tejpuriya");
        Doctor d2 = new Doctor("Dr. Tillu Badmosh");

        Patient p1 = new Patient("RamPrasad");
        Patient p2 = new Patient("PhulanDevi");

        hospital.addDoctor(d1);
        hospital.addDoctor(d2);
        hospital.addPatient(p1);
        hospital.addPatient(p2);

        d1.consult(p1);
        d1.consult(p2);
        d2.consult(p2);

        d1.showPatients();
        d2.showPatients();
    }
}
