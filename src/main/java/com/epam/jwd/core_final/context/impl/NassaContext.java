package com.epam.jwd.core_final.context.impl;

import com.epam.jwd.core_final.context.ApplicationContext;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.fasterxml.jackson.databind.util.ISO8601Utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// todo
public class NassaContext implements ApplicationContext {

    // no getters/setters for them
    private Collection<CrewMember> crewMembers = new ArrayList<>();
    private Collection<Spaceship> spaceships = new ArrayList<>();
    private Collection<Planet> planetMap = new ArrayList<>();

    @Override
    public <T extends BaseEntity> Collection<T> retrieveBaseEntityList(Class<T> tClass) {
        String[] type = tClass.getTypeName().split("\\.");
        if (type[5].equals("CrewMember")) {
            return (Collection<T>) crewMembers;
        } else if (type[5].equals("Spaceship")) {
            return (Collection<T>) spaceships;
        } else if (type[5].equals("Planet")) {
            return (Collection<T>) planetMap;
        }
        return null;
    }

    /**
     * You have to read input files, populate collections
     *
     * @throws InvalidStateException
     */
    @Override
    public void init() throws InvalidStateException, IOException {
        Long id = 1l;
        FileReader reader_crew = new FileReader("src/main/resources/input/crew");
        BufferedReader bufferedReader = new BufferedReader(reader_crew);
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.matches("#.*")) {
                String[] creMembers = line.split(";");
                for (int i = 0; i < creMembers.length; i++) {
                    String[] member = creMembers[i].split(",");
                    crewMembers.add(new CrewMember(id++, Role.resolveRoleById(Integer.parseInt(member[0]))
                            , member[1], Rank.resolveRankById(Integer.parseInt(member[2]))));
                }
            }
        }

        FileReader reader_spaceship = new FileReader("src/main/resources/input/spaceships");
        bufferedReader = new BufferedReader(reader_spaceship);
        while ((line = bufferedReader.readLine()) != null) {
            if (!line.matches("#.*")) {
                String[] ship = line.split(";");
                String crew = ship[2];
                crew = crew.substring(1, crew.length() - 1);
                Map<Role, Short> map = new TreeMap<>();
                String[] forMap = crew.split(",");
                for (int i = 0; i < forMap.length; i++) {
                    String[] numbers = forMap[i].split(":");
                    map.put(Role.resolveRoleById(Integer.parseInt(numbers[0])), Short.parseShort(numbers[1]));
                }
                spaceships.add(new Spaceship(id++, ship[0], map, Long.parseLong(ship[1])));
            }
        }

        FileReader reader_planet = new FileReader("src/main/resources/input/spacemap");
        bufferedReader = new BufferedReader(reader_planet);
        String str;
        Long y = 0l;
        while ((str = bufferedReader.readLine()) != null) {
            y++;
            String[] oneLine = str.split(",");
            for (int i = 0; i < oneLine.length; i++) {
                if (!oneLine[i].equals("null")) {
                    planetMap.add(new Planet(id++, oneLine[i], new Point((long) i + 1, y)));
                }
            }
        }
    }
}
