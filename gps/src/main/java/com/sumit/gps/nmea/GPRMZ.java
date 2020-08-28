package com.sumit.gps.nmea;

class GPRMZ implements SentenceParser {
    public boolean parse(String[] tokens, GPSPosition position) {
        position.altitude = Float.parseFloat(tokens[1]);
        return true;
    }
}
