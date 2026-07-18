package A1_ADodson;

import java.util.List;

public class Nurse extends HealthProfessional {

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

    @Override
    public String toString() {
        return getName() + "(ID: " + getId() + "|" + ward + ")";
    }    
}