package com.sumit.gps.nmea;

import org.json.JSONObject;

import java.io.Serializable;

public class GPSPosition implements Serializable {
    public float time = 0.0f;
    public float lat = 0.0f;
    public float lon = 0.0f;
    public boolean fixed = false;
    public int quality = 0;
    public float dir = 0.0f;
    public float altitude = 0.0f;
    public float velocity = 0.0f;

    public float getTime() {
        return time;
    }

    public void setTime(float time) {
        this.time = time;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public boolean isFixed() {
        return fixed;
    }

    public void setFixed(boolean fixed) {
        this.fixed = fixed;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public float getDir() {
        return dir;
    }

    public void setDir(float dir) {
        this.dir = dir;
    }

    public float getAltitude() {
        return altitude;
    }

    public void setAltitude(float altitude) {
        this.altitude = altitude;
    }

    public float getVelocity() {
        return velocity;
    }

    public void setVelocity(float velocity) {
        this.velocity = velocity;
    }

    public void updatefix() {
        fixed = quality > 0;
    }

    public String toString() {
        return String.format("POSITION: lat: %f, lon: %f, time: %f, Q: %d, dir: %f, alt: %f, vel: %f", lat, lon, time, quality, dir, altitude, velocity);
    }

    public JSONObject getJson() {
        return new JSONObject().put("time", time).put("lat", lat).put("lon", lon).put("fixed", fixed).put("quality", quality).put("dir", dir).put("altitude", altitude).put("velocity", velocity);
    }
}
