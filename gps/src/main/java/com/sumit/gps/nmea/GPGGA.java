package com.sumit.gps.nmea;

// parsers
class GPGGA implements SentenceParser {
    public boolean parse(String[] tokens, GPSPosition position) {
        position.time = Float.parseFloat(tokens[1]);
        position.lat = NMEA.Latitude2Decimal(tokens[2], tokens[3]);
        position.lon = NMEA.Longitude2Decimal(tokens[4], tokens[5]);
        position.quality = Integer.parseInt(tokens[6]);
        position.altitude = Float.parseFloat(tokens[9]);
        return true;
    }
}
