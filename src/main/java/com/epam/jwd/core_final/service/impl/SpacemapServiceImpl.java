package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.domain.Planet;
import com.epam.jwd.core_final.domain.Point;
import com.epam.jwd.core_final.service.SpacemapService;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SpacemapServiceImpl implements SpacemapService {
    private static SpacemapServiceImpl instance;
    private Long id = 1l;
    private List<Planet> planets = new ArrayList<>();
    private SpacemapServiceImpl() throws IOException {
        FileReader fileReader = new FileReader("src/main/resources/input/spacemap");
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String str;
        Long y = 0l;
        while ((str = bufferedReader.readLine()) != null){
            y++;
            String[] oneLine = str.split(",");
            for(int i = 0; i < oneLine.length; i++){
                if(!oneLine[i].equals("null")){
                    planets.add(new Planet(id++,oneLine[i],new Point((long)i+1,y)));
                }
            }
        }
    }
    @Override
    public Planet getRandomPlanet() {
        int index = (int) (Math.random() * planets.size());
        return planets.get(index);
    }

    @Override
    public int getDistanceBetweenPlanets(Planet first, Planet second) {
        int distance = (int)Math.sqrt(Math.pow(first.getLocation().getX()-second.getLocation().getX(),2) +
                Math.pow(first.getLocation().getY()-second.getLocation().getY(),2));
        return distance;
    }

    public static SpacemapServiceImpl getInstance() throws IOException {
        if(instance == null){
            instance = new SpacemapServiceImpl();
        }
        return instance;
    }
}
