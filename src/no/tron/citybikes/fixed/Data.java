package no.tron.citybikes.fixed;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {

    private List<Station> stations = null;

    public List<Station> getStations() {
        return stations;
    }
}
