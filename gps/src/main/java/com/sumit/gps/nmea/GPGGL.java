package com.sumit.gps.nmea;

class GPGGL implements SentenceParser {
    public boolean parse(String[] tokens, GPSPosition position) {
        position.lat = NMEA.Latitude2Decimal(tokens[1], tokens[2]);
        position.lon = NMEA.Longitude2Decimal(tokens[3], tokens[4]);
        position.time = Float.parseFloat(tokens[5]);
        return true;
    }
}
