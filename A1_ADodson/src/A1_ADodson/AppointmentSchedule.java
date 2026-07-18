//this is the Appointment creation and View section
package A1_ADodson;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class AppointmentSchedule {

    private final List<Appointment> appointments = new ArrayList<>();

    public boolean newAppointment(Appointment appointment) {
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
    public List<Appointment> sortByTime(List<Appointment> toSort) {
        List<Appointment> sorted = new ArrayList<>(toSort);
        Collections.sort(sorted);
        return sorted;
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