package com.sumit.gps.controller;

import com.sumit.gps.nmea.GPSPosition;
import com.sumit.gps.GpsService;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GpsController {

    @Autowired
    private GpsService gpsService;

    @RequestMapping("/index")
    @ResponseBody
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/process")
    @ResponseBody
    public String process(@RequestParam final String path) {
        System.out.println("path: " + path);
        JSONArray array = gpsService.readAndParseGps(path);
        System.out.println("this is array " + array);
        return array.toString();
    }

    @RequestMapping("/process1")
    @ResponseBody
    public List<GPSPosition> process1(@RequestParam final String path) {
        System.out.println("path: " + path);
        return gpsService.readAndParseGps1(path);
    }
}
