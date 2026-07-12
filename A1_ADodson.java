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

class A1_ADodson {
    public static void main(String[] args) {

        //Days available to work
        List<String> mtw = Arrays.asList("Monday", "Tuesday", "Wednesday");
        List<String> mwf = Arrays.asList("Monday", "Wednesday", "Friday");
        List<String> tt = Arrays.asList("Tuesday", "Thursday");
        List<String> weekDays = Arrays.asList("Monday", "Tuesday", "Wednesday",
                                           "Thursday", "Friday");

        List<String> availableSlots = new ArrayList<>(Arrays.asList(
        "07:00", "07:30", "08:00", "08:30", "09:00", "09:30", "10:00", "10:30",
        "11:00", "11:30", "12:00", "12:30", "01:00", "01:30", "02:00", "02:30",
        "03:00", "03:30", "04:00"
        ));
 
        //Medical Professionals grouped by ID, Name, Days they work, AssignedRoom
        Nurse nurse1 = new Nurse("9010", "Norelle Sanchez", weekDays, new ArrayList<>(availableSlots),"");
        Nurse nurse2 = new Nurse("9025", "Harry Rumble", tt, new ArrayList<>(availableSlots),"Operating Ward");
        Nurse nurse3 = new Nurse("9097","Melanie Cherkov", mwf, new ArrayList<>(availableSlots),"Emergency Ward");
        Nurse nurse4 = new Nurse("9845", "Betty Suarez", mtw,new ArrayList<>(availableSlots),"Children's Ward");

        Practitoner gp1 = new Practitoner("1126", "Dr. Anthony Reed", weekDays, new ArrayList<>(availableSlots), "Room 3");
        Practitoner gp2 = new Practitoner("1175", "Dr. Greg House", tt, new ArrayList<>(availableSlots), "Room 1");
        Practitoner gp3 = new Practitoner("1257", "Dr. JD", mtw, new ArrayList<>(availableSlots), "Room 5");
        Practitoner gp4 = new Practitoner("1245", "Dr. Candice Robin", mwf, new ArrayList<>(availableSlots), "Room 4");

        Specialist sp1 = new Specialist("2423","Dr. Shannon Templeton ",tt, new ArrayList<> (availableSlots),"Room 2");
        Specialist sp2 = new Specialist("2256","Dr. Ethan Holmes ",mwf, new ArrayList<> (availableSlots),"Room 10");
        Specialist sp3 = new Specialist("2912","Dr. Tuesday Addams",mtw, new ArrayList<> (availableSlots),"Room 9");

        Surgeon sg1 = new Surgeon("3725", "Dr. Jordan", tt, new ArrayList<>(availableSlots),"Operating Room 1");
        Surgeon sg2 = new Surgeon("3982", "Dr. Ophelia", mwf, new ArrayList<>(availableSlots),"Operating Room 2");
        
        //Patients
        Patient p1 = new Patient ("Tyler Craddle", "0410123111");
        Patient p2 = new Patient ("John Nolan", "0412342199");
        Patient p3 = new Patient ("Jimmy Barnes", "0414852745");
        Patient p4 = new Patient ("Alicia Dixon", "0451846852");

        List<HealthProfessional> professionals = new ArrayList<>();
        professionals.add(nurse1);
        professionals.add(nurse2);
        professionals.add(nurse3);
        professionals.add(nurse4);
        professionals.add(gp1);
        professionals.add(gp2);
        professionals.add(gp3);
        professionals.add(gp4);
        professionals.add(sp1);
        professionals.add(sp2);
        professionals.add(sp3);
        professionals.add(sg1);
        professionals.add(sg2);

        for (HealthProfessional hp : professionals) {
            System.out.println(hp);
            System.out.println(" ->" + hp.performSpecialFunction());
        }

    }
}

abstract class HealthProfessional {
    
    final String id;
    final String name;
    private final List<String> weekDays;
    private final List<String> availableSlots;

    public HealthProfessional(String id, String name, List<String> weekDays, List<String> availableSlots) {
        if (id == null || id.isEmpty() || !id.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("ID can only be numbers.");
        }
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Name cannot be empty.");
        }
        if (weekDays == null || weekDays.isEmpty()) {
            throw new IllegalArgumentException("Health Professionals must be on Roster.");
        }
        if (availableSlots == null || availableSlots.isEmpty()) {
            throw new IllegalArgumentException("Health Professionals must have Appointments.");
        }
        this.id = id;
        this.name = name;
        this.weekDays = weekDays;
        this.availableSlots = availableSlots;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getWeekDays() {
        return weekDays;
    }

    public List<String> getAvailableSlots() {
        return availableSlots;
    }

    abstract String performSpecialFunction();
}

class Nurse extends HealthProfessional{

    private final String ward;

    public Nurse (String id, String name, List<String> weekDays,
                  List<String> availableSlots, String ward) {
                    super(id, name, weekDays, availableSlots);
        this.ward = (ward == null || ward.trim().isEmpty()) ? "General Ward" : ward;
    }

    public String getWard() {
        return ward;
    }

    @Override
    public String performSpecialFunction() {
        return getName() + " Takes a blood sample, monitors vitals and gives fluid in " + ward + ".";
    }
    }

class Practitoner extends HealthProfessional {

    private final String consultingRoom;

    public Practitoner (String id, String name, List<String> weekDays,
                        List<String> availableSlots, String consultingRoom) {
            super(id, name, weekDays, availableSlots);
            this.consultingRoom = (consultingRoom == null || consultingRoom.trim().isEmpty())
            ? "" : consultingRoom;
    }

    public String getConsultingRoom() {
        return consultingRoom;
    }

    @Override
    public String performSpecialFunction() {
        return getName() + " Performs Health Check on patient and prescribes necessary medications.";
    }

    // @Override
    // public String toString() {
    //     return name + "(ID: " + id + "|" + consultingRoom + ")";
    // }
}

class Specialist extends HealthProfessional {
    
    private final String consultingRoom;

    public Specialist(String id, String name, List<String> weekDays,
                      List<String> availableSlots, String consultingRoom) {
        super(id, name, weekDays, availableSlots);    
        this.consultingRoom = (consultingRoom == null || consultingRoom.trim().isEmpty())
            ? "Room" : consultingRoom;
    }

    public String getConsultingRoom() {
        return consultingRoom;
    }

    @Override
    public String performSpecialFunction() {
        return getName() + "Looks over Patient's records and advises suitable treatment plans.";
    }

    // @Override
    // public String toString() {
    //     return name + "(ID: " + id + "|" + consultingRoom + ")";
    // }
}

class Surgeon extends HealthProfessional{
    
    private final String consultingRoom; //the consulting Room is the Operating Room

    public Surgeon (String id, String name, List<String> weekDays,
                   List<String> availableSlots, String consultingRoom) {
        super(id, name, weekDays, availableSlots);
        this.consultingRoom = (consultingRoom == null || consultingRoom.trim().isEmpty())
            ? "Operating Room" : consultingRoom;    
    }

    public String getConsultingRoom() {
        return consultingRoom;
    }

    @Override
    public String performSpecialFunction() {
        return getName() + " Is performing an operation in " + getConsultingRoom() + ".";
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
    final HealthProfessional professionals;
    final String slot;

    public Appointment(Patient patient, HealthProfessional professionals, String slot) {
        if (patient == null) {
            throw new IllegalArgumentException("Appointment must have a patient");
        }
        if (professionals == null) {
            throw new IllegalArgumentException("Appointment need a Doctor");
        }
        if (slot == null) {
            throw new IllegalArgumentException("Appointments must be alloted a time slot");
        }
        this.patient = patient;
        this.professionals = professionals;
        this.slot = slot;
    }

    public Patient getPatient() {
        return patient;
    }

    public HealthProfessional getProfessional() {
        return professionals;
    }

    public String getSlot() {
        return slot;
    }

    @Override
    public int compareTo(Appointment taken) {
        return this.slot.compareTo(taken.slot);
    }

    @Override
    public String toString() {
        return "[" + slot + "] " + patient + "\n"
        + " With ->" + professionals + "\n";
    }

//this is the Appointment creation and View section
class AppointmentSchedule {

    private final List<Appointment> appointments = new ArrayList<>();

    public boolean addAppointment(Appointment appointment) {
        if (appointment == null) {
            System.out.println ("Error: Cannot add this appointment.");
            return false;
        }
        for (Appointment existing : appointments) {
            if (existing.getProfessional().equals(appointment.getProfessional())
            && existing.getSlot().equals(appointment.getSlot())) {
            System.out.println("Error: " + appointment.getProfessional().getName()
        + " (ID" + appointment.getProfessional().getId() + ") is already booked at "
        + appointment.getSlot() + ". Appointment was not made.");
            return false;
            }
        }
        appointments.add(appointment);
        return true;
    }

    public List<Appointment> viewByProfessionalId(String professionalId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment approved : appointments) {
            if (approved.getProfessional().getId().equals(professionalId)) {
                result.add(approved);
            }
        }
        if (result.isEmpty()) {
            System.out.println
            ("Error: No appointments found for Health Professional ID "
                + professionalId + ".");
        }
        return result;
    }
    public List<Appointment> getAllAppointments() {
        return new ArrayList<>(appointments);
    }
    public void displayAppoinments(List<Appointment> toDisplay) {
        if (toDisplay.isEmpty()) {
            System.out.println("(No appointments available to display.)");
            return;
            }
        for (Appointment approved : toDisplay) {
            System.out.println(approved);
            System.out.println("-----------------------------------------------");
            }
        }
    }
}