package A1_ADodson;

class Appointment implements Comparable<Appointment> {

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
}   