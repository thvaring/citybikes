package no.tron.citybikes;

/**
 * Printable aggregate of fixed and transient data for a station, sortable by station name.
 */
public class DisplayItem implements Comparable<DisplayItem> {

    private String stationId;
    private String stationName;
    private Integer lockCapacity;
    private Integer availableBikes;
    private Integer freeLocks;

    public DisplayItem(String stationId, String stationName, int lockCapacity, int availableBikes, int freeLocks) {
        this.stationId = stationId;
        this.stationName = stationName;
        this.lockCapacity = lockCapacity;
        this.availableBikes = availableBikes;
        this.freeLocks = freeLocks;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(stationName);
        sb.append("\n\tId: ");
        sb.append(stationId);
        sb.append("\n\tKapasitet: ");
        sb.append(lockCapacity);
        sb.append("\n\tLedige låser: ");
        sb.append(freeLocks);
        sb.append("\n\tLedige sykler: ");
        sb.append(availableBikes);
        sb.append("\n\n");
        return sb.toString();
    }

    @Override
    public int compareTo(DisplayItem o) {
        return stationName.compareTo(o.stationName);
    }

}
