package no.tron.citybikes.changing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Data {

    @SerializedName("stations")
    @Expose
    private List<Station> stations = new ArrayList<Station>();

    public List<Station> getStations() {
        return stations;
    }

}
