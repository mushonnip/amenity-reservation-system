package tech.mushonnip.ars.model;

public enum AmenityType {
    POOL("POOL"), SAUNA("SAUNA"), GYM("GYM");

    private String name;

    AmenityType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
