package com.sumit.gps.nmea;

class GPVTG implements SentenceParser {
    public boolean parse(String[] tokens, GPSPosition position) {
        position.dir = Float.parseFloat(tokens[3]);
        return true;
    }
}
