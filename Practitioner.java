package A1_ADodson;

import java.util.List;

class Practitoner extends HealthProfessional {

    private final String consultingRoom;

    public Practitoner (String id, String name, List<String> weekDays,
                        List<String> availableSlots, String consultingRoom) {
            super(id, name, weekDays, availableSlots, consultingRoom);
            this.consultingRoom = (consultingRoom == null || consultingRoom.trim().isEmpty())
            ? "" : consultingRoom;
    }

    public String getConsultingRoom() {
        return consultingRoom;
    }

    public String performSpecialFunction() {
        return getName() + " Performs Health Check on patient and prescribes necessary medications.";
    }

    @Override
    public String toString() {
        return name + "(ID: " + id + "|" + consultingRoom + ")";
    }
}