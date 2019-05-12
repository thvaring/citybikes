package no.tron.citybikes.changing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("is_installed")
    private Integer isInstalled;
    @SerializedName("is_renting")
    private Integer isRenting;
    @SerializedName("num_bikes_available")
    private Integer numBikesAvailable;
    @SerializedName("num_docks_available")
    private Integer numDocksAvailable;
    @SerializedName("last_reported")
    private Integer lastReported;
    @SerializedName("is_returning")
    private Integer isReturning;
    @SerializedName("station_id")
    private String stationId;

    public Integer getNumBikesAvailable() {
        return numBikesAvailable;
    }

    public Integer getNumDocksAvailable() {
        return numDocksAvailable;
    }

    public String getStationId() {
        return stationId;
    }
}