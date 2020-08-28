package com.sumit.gps;

import com.sumit.gps.nmea.GPSPosition;
import com.sumit.gps.nmea.NMEA;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.LinkedList;
import java.util.List;

@Service
public class GpsService {
    public JSONArray readAndParseGps(String path) {
//        String gps = "C:\\Users\\sumit\\Pictures\\14er\\dashcam\\GPSDATA\\asdads.nmea";
        return processNmea(path);
    }

    public List<GPSPosition> readAndParseGps1(String path) {
//        String gps = "C:\\Users\\sumit\\Pictures\\14er\\dashcam\\GPSDATA\\asdads.nmea";
        return processNmea1(path);
    }

    private JSONArray processNmea(String path) {
        JSONArray array = new JSONArray();
        try {
            NMEA nmea = new NMEA();
            Files.lines(new File(path).toPath()).forEach(line -> {
//                System.out.println(line);
                GPSPosition position = nmea.parse(line);
                JSONObject json = position.getJson();
//                System.out.println(json);
                array.put(json);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }

    private List<GPSPosition> processNmea1(String path) {
        List<GPSPosition> array = new LinkedList<>();
        try {
            NMEA nmea = new NMEA();
            Files.lines(new File(path).toPath()).forEach(line -> {
                GPSPosition position = nmea.parse(line);
                array.add(position);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        return array;
    }
}
