package no.tron.citybikes.changing;

/**
 * Transient bike station information record. Fields change as bikes are taken out and returned.
 */
public class ChangingStationInfo {

    private String id;
    private Integer availableBikes;
    private Integer availableLocks;

    public ChangingStationInfo(String id, Integer availableBikes, Integer availableLocks) {
        this.id = id;
        this.availableBikes = availableBikes;
        this.availableLocks = availableLocks;
    }

    public String getId() {
        return id;
    }

    public Integer getAvailableBikes() {
        return availableBikes;
    }

    public Integer getAvailableLocks() {
        return availableLocks;
    }

}
