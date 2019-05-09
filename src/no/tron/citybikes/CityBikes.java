/**
 * CityBikes -- simple command line app to fetch and display Oslo city bike station information.
 * For each station the following is displayed:
 *
 *      Name
 *      Id
 *      Capacity
 *      Currently available locks
 *      Currently available bikes
 *
 * @author Tron Hvaring
 */
package no.tron.citybikes;


import no.tron.citybikes.changing.ChangingDataExtractor;
import no.tron.citybikes.changing.ChangingStationInfo;
import no.tron.citybikes.fixed.FixedDataExtractor;
import no.tron.citybikes.fixed.FixedStationInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * Main class.
 */
public class CityBikes {

    private static final String FIXED_STATION_INFO_URL = "http://gbfs.urbansharing.com/oslobysykkel.no/station_information.json";
    private static final String CHANGING_STATION_INFO_URL = "http://gbfs.urbansharing.com/oslobysykkel.no/station_status.json";

    private static Set<DisplayItem> items = new TreeSet<>();

    public static void main(String[] args) {

        String json = getJsonFromURL(FIXED_STATION_INFO_URL);
        if (json != null) {
            List<FixedStationInfo> fixedInfoList = FixedDataExtractor.getFixedStationInfo(json);
            if (fixedInfoList != null && !fixedInfoList.isEmpty()) {
                json = getJsonFromURL(CHANGING_STATION_INFO_URL);
                if (json != null) {
                    Map<String, ChangingStationInfo> changingInfoList = ChangingDataExtractor.getChangingStationInfo(json);
                    if (changingInfoList != null && !changingInfoList.isEmpty()) {
                        for (FixedStationInfo fixedInfo : fixedInfoList) {
                            ChangingStationInfo changingInfo = changingInfoList.get(fixedInfo.getId());
                            if (changingInfo != null) {
                                items.add(new DisplayItem(fixedInfo.getId(), fixedInfo.getName(), fixedInfo.getCapacity(), changingInfo.getAvailableBikes(), changingInfo.getAvailableLocks()));
                            }
                        }
                    }
                }
            }
        }

        for (DisplayItem item : items)
            System.out.println(item);
}


    private static String getJsonFromURL(final String urlString) {
        StringBuffer jsonBuffer = new StringBuffer();

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Client-Identifier", "tron_hvaring-citybikes");
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String line;
            while ((line = in.readLine()) != null) {
                jsonBuffer.append(line);
            }
            in.close();
        } catch (MalformedURLException mue) {
            System.out.println("Nettaddressen " + urlString + " er ikke en gyldig addresse, melding " + mue.toString());
            return null;
        } catch (IllegalArgumentException iae) {
            System.out.println("Det er noe galt med nettaddressen " + urlString + ", melding " + iae.toString());
            return null;
        } catch (ProtocolException pe) {
            System.out.println("Nettaddressen " + urlString + " støtter ikke HTTP GET, melding " + pe.toString());
            return null;
        } catch (IOException ioe) {
            System.out.println("Feil under lesing fra url " + urlString + ", melding " + ioe.toString());
            return null;
        }

        return jsonBuffer.toString();
    }
}
