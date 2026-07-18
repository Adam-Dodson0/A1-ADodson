package A1_ADodson;

public class Patient {

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