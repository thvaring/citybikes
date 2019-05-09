package no.tron.citybikes.changing;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import java.util.HashMap;
import java.util.Map;

public class ChangingDataExtractor {

    /**
     * Parse JSON for changing station information, return a collection keyed by station ID.
     *
     * @param json JSON string to parse
     * @return collection, or null if input is incorrect
     */
    public static Map<String, ChangingStationInfo> getChangingStationInfo(String json) {
        Map<String, ChangingStationInfo> infoMap = new HashMap<>();
        try {
            Stations stations = new Gson().fromJson(json, Stations.class);
            for (Station station : stations.getData().getStations()) {
                ChangingStationInfo info = new ChangingStationInfo(station.getStationId(), station.getNumBikesAvailable(), station.getNumDocksAvailable());
                infoMap.put(info.getId(), info);
            }
        } catch (JsonSyntaxException jse) {
            System.out.println("Syntaksfeil i mottatt JSON-tekst for stasjonsstatus, melding " + jse.toString());
            return null;
        }
        return infoMap;
    }

}
