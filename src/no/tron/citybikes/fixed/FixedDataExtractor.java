package no.tron.citybikes.fixed;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.ArrayList;
import java.util.List;

public class FixedDataExtractor {

    /**
     * Parse JSON for fixed station information, return a list of entries.
     *
     * @param json JSON string to parse
     * @return collection, or null if input is incorrect
     */
    public static List<FixedStationInfo> getFixedStationInfo(String json) {
        List<FixedStationInfo> fixedStationInfoList = new ArrayList<>();
        try {
            Stations stations = new Gson().fromJson(json, Stations.class);
            for (Station station : stations.getData().getStations()) {
                FixedStationInfo info = new FixedStationInfo(station.getStationId(), station.getCapacity(), station.getName());
                fixedStationInfoList.add(info);
            }
        } catch (JsonSyntaxException jse) {
            System.out.println("Syntaksfeil i mottatt JSON-tekst for stasjonsinfo, melding " + jse.toString());
            return null;
        }
        return fixedStationInfoList;
    }

}
