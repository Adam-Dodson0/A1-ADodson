package A1_ADodson;

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
