package no.tron.citybikes.fixed;

import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("station_id")
    private String stationId;
    private String name;
    private String address;
    private Double lat;
    private Double lon;
    private Integer capacity;

    public String getStationId() {
        return stationId;
    }

    public String getName() {
        return name;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
