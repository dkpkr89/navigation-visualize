package com.sumit.gps.nmea;

// fucking java interfaces
interface SentenceParser {
    boolean parse(String[] tokens, GPSPosition position);
}
