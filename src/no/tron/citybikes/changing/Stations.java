package no.tron.citybikes.changing;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Stations {

    @SerializedName("last_updated")
    private Integer lastUpdated;
    private Data data;

    public Data getData() {
        return data;
    }

}