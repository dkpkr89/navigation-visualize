package com.sumit.gps;

import com.sumit.gps.nmea.GPSPosition;
import com.sumit.gps.nmea.NMEA;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

@SpringBootApplication
@ComponentScan(basePackages = {"com.sumit.gps"})
public class Main {
    public static void main(String[] a){
        SpringApplication.run(Main.class, a);
    }

    private static void processNmea(String path1) {
        try {
            NMEA nmea = new NMEA();
            String path = path1;
            Files.lines(new File(path).toPath()).forEach(line->{
                System.out.println(line);
                GPSPosition position = nmea.parse(line);
                System.out.println(position);
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
