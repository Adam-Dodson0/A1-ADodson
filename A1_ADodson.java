/*
    Name: Adam Dodson
    date: 10/07/2026
    Assignment 1 for PROG2004-T3
    Description: This is a Java program that is for a Appointment System for a Health Service.
    This program will allow the user to view, and manage appointments for patients and doctors.
    Viewing existing appointments, and canceling appointments.

*/
package A1_ADodson;

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

        // for (HealthProfessional hp : professionals) {
        //     System.out.println(hp);
        //     System.out.println(" ->" + hp.performSpecialFunction());
        // }

        System.out.println("\n===================== Appointment Demo ===================\n");

        AppointmentSchedule appointment = new AppointmentSchedule();

        System.out.println("------------------- Booking appointments -----------------\n");
        appointment.newAppointment(new Appointment(p1, gp2, "09:30"));
        appointment.newAppointment(new Appointment(p2, sp1, "09:30"));
        appointment.newAppointment(new Appointment(p3, sg1, "09:30"));
        appointment.newAppointment(new Appointment(p4, nurse1, "09:30"));
        appointment.newAppointment(new Appointment(p1, gp4, "09:30"));
        System.out.println("Appointments successfully booked.\n");
        System.out.print("All Appointments: " + appointment.appointments + "\n");

        System.out.println("-------------------Appointment for -------------------------\n");
        System.out.println(professionals + performSpecialFunction + " on " + p1);

        System.out.println("\n------------------- Booking appointment Error: Double Booking -----------------\n");
        boolean rejected = appointment.newAppointment(new Appointment(p2, gp2, "09:30"));
        System.out.println("Result of double-booking attempt: " + (rejected ? "added" : "rejected") + "\n");

        System.out.println("------------------- All Appointments sorted by time -------------------");
        appointment.displayAppoinments(appointment.sortByTime(appointment.getAllAppointments()));

        System.out.println("\n------------------- Final list of appointments, sorted by time -------------------");
        appointment.displayAppoinments(appointment.sortByTime(appointment.getAllAppointments()));
    
    }
}