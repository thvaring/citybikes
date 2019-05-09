package no.tron.citybikes.fixed;

/**
 * Fixed bike station information record. Fields are not expected to change very often (if ever).
 */
public class FixedStationInfo {

    private String id;
    private String name;
    private Integer capacity;

    public FixedStationInfo(String id, Integer capacity, String name) {
        this.id = id;
        this.capacity = capacity;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getName() {
        return name;
    }

}
