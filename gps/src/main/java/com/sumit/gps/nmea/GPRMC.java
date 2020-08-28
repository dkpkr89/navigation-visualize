package com.sumit.gps.nmea;

class GPRMC implements SentenceParser {
    public boolean parse(String[] tokens, GPSPosition position) {
        position.time = Float.parseFloat(tokens[1]);
        position.lat = NMEA.Latitude2Decimal(tokens[3], tokens[4]);
        position.lon = NMEA.Longitude2Decimal(tokens[5], tokens[6]);
        position.velocity = Float.parseFloat(tokens[7]);
        position.dir = Float.parseFloat(tokens[8]);
        return true;
    }
}
