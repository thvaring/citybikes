package no.tron.citybikes.changing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Station {

    @SerializedName("is_installed")
    @Expose
    private Integer isInstalled;
    @SerializedName("is_renting")
    @Expose
    private Integer isRenting;
    @SerializedName("num_bikes_available")
    @Expose
    private Integer numBikesAvailable;
    @SerializedName("num_docks_available")
    @Expose
    private Integer numDocksAvailable;
    @SerializedName("last_reported")
    @Expose
    private Integer lastReported;
    @SerializedName("is_returning")
    @Expose
    private Integer isReturning;
    @SerializedName("station_id")
    @Expose
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