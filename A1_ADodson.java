/*
    Name: Adam Dodson
    date: 10/07/2026
    Assignment 1 for PROG2004-T3
    Description: This is a Java program that is for a Appointment System for a Health Service.
    This program will allow the user to view, and manage appointments for patients and doctors.
    Viewing existing appointments, and canceling appointments.

*/

    //List of Imports
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;

    enum weekDay { 
        Monday, Tuesday, Wednesday, Thursday, Friday;
    }

class A1_ADodson {
    public static void main(String[] args) {

        //Days available to work
        List<weekDay> mtw = Arrays.asList(weekDay.Monday, weekDay.Tuesday, weekDay.Wednesday);
        List<weekDay> mwf = Arrays.asList(weekDay.Monday, weekDay.Wednesday, weekDay.Friday);
        List<weekDay> tt = Arrays.asList(weekDay.Tuesday, weekDay.Thursday);
        List<weekDay> WeekDays = Arrays.asList(weekDay.Monday, weekDay.Tuesday, weekDay.Wednesday, weekDay.Thursday,
                                            weekDay.Friday);

        List<String> availableSlots = new ArrayList<>(Arrays.asList(
        "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30",
        "11:00", "11:30", "12:00", "12:30", "01:00", "01:30", "02:00", "02:30",
        "03:00", "03:30", "04:00"
        ));
 
        //Nurse/Receptionist
        Nurse nurse1 = new Nurse("1010", "Betty Sanchez", WeekDays);
        Nurse nurse2 = new Nurse("1025", "Harry Rumble", tt);
        Nurse nurse3 = new Nurse("1097","Melanie Cherkov", mwf);

        //Doctors grouped by ID, Name, Days they work, AssignedRoom
        Practitoner gp1 = new Practitoner("1000", "Dr. Anthony Reed", WeekDays, "Room 3", new ArrayList<>(availableSlots));
        Practitoner gp2 = new Practitoner("2003", "Dr. Greg House", tt, "Room 1", new ArrayList<>(availableSlots));
        Practitoner gp3 = new Practitoner("3006", "Dr. JD", mtw, "Room 5", new ArrayList<>(availableSlots));
        Practitoner gp4 = new Practitoner("4245", "Dr. Candice Robin", mwf, "Room 4", new ArrayList<>(availableSlots));

        //Patients
        Patient p1 = new Patient ("Tyler Craddle", "0410123111");
        Patient p2 = new Patient ("John Nolan", "0412342199");
        Patient p3 = new Patient ("Jimmy Barnes", "0414852745");
        Patient p4 = new Patient ("Alicia Dixon", "0451846852");

    }
}

class Practitoner {

    private String id;
    private String name;
    public List<weekDay> WeekDays;
    private final String consultingRoom;
    private final List<String> availableSlots;

    public Practitoner(String id, String name, List<weekDay> WeekDays, String consultingRoom, List<String> availableSlots) {
            this.consultingRoom = (consultingRoom == null || consultingRoom.trim().isEmpty())
            ? " " : consultingRoom;
            this.availableSlots = availableSlots;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<weekDay> getWeekDays() {
        return new ArrayList<>(WeekDays);
    }

    public String getConsultingRoom() {
        return consultingRoom;
    }

    public List<String> getAvailableSlots(){
        return availableSlots;
    }

    @Override
    public String toString() {
        return name + "(ID: " + id + "|" + consultingRoom + ")";
    }
}

class Patient {

    private String name;
    private String phoneNumber;

    public Patient(String name, String phoneNumber) {
        if (name == null) {
            throw new IllegalArgumentException("Patients name cannot be empty");
        }
        if (phoneNumber == null || phoneNumber.trim().isEmpty()
        || !phoneNumber.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("Phone Number cannot be empty and can only be numbers");
        }
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName(){
            return name;
    }

    public String getPhoneNumber() {
            return phoneNumber;
    }

    @Override
    public String toString() {
            return "Patient: " + name + " | Phone: " + phoneNumber;
    }
}

abstract class Appointment implements Comparable<Appointment> {

    final Patient patient;
    final Practitoner practitoner;
    final availableSlots slot;

    public Appointment(Patient patient, Practitoner practitoner, availableSlots slot) {
        if (patient == null) {
            throw new IllegalArgumentException("Appointment must have a patient");
        }
        if (practitoner == null) {
            throw new IllegalArgumentException("Appointment need a Doctor");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Appointments must be alloted a time slot");
        }
        this.patient = patient;
        this.practitoner = practitoner;
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public Practitoner getPractitoner() {
        return practitoner;
    }

    public availableSlots getSlot() {
        return slot;
    }

    @Override
    public String toString() {
        return "[" + slot + "] " + patient + "\n"
        + " With ->" + practitoner + "\n";
    }
}
    }
}