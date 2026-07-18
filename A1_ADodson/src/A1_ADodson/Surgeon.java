package A1_ADodson;

import java.util.List;

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
        return name + " Is performing an operation in " + getConsultingRoom() + ".";
    }

    @Override
    public String toString() {
        return name + "(ID: " + id + "|" + consultingRoom + ")";
    }   
}