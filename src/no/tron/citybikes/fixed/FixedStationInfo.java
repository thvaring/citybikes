package no.tron.citybikes.fixed;

public class FixedStationInfo {

    private String id;
    private Integer capacity;
    private String name;

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
