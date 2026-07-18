package A1_ADodson;

import java.util.List;

public class Specialist extends HealthProfessional {

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
        return name + " Looks over Patient's records and advises suitable treatment plans.";
    }

    @Override
    public String toString() {
        return name + "(ID: " + id + "|" + consultingRoom + ")";
    }
}