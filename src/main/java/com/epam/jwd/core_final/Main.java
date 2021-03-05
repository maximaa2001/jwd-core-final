package com.epam.jwd.core_final;

import com.epam.jwd.core_final.context.Application;
import com.epam.jwd.core_final.context.impl.NassaContext;
import com.epam.jwd.core_final.criteria.CrewMemberCriteria;
import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.criteria.FlightMissionCriteria;
import com.epam.jwd.core_final.criteria.SpaceshipCriteria;
import com.epam.jwd.core_final.domain.*;
import com.epam.jwd.core_final.exception.InvalidStateException;
import com.epam.jwd.core_final.service.impl.CrewServiceImpl;
import com.epam.jwd.core_final.service.impl.MissionServiceImpl;
import com.epam.jwd.core_final.service.impl.SpacemapServiceImpl;
import com.epam.jwd.core_final.service.impl.SpaceshipServiceImpl;

import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) throws IOException, InvalidStateException {
       // Application.start();
//        Map<Role,Short> map1 = new TreeMap<>();
//        map1.put(Role.FLIGHT_ENGINEER,(short) 3);
//        map1.put(Role.COMMANDER,(short) 3);
//        Map<Role,Short> map2 = new TreeMap<>();
//        map2.put(Role.COMMANDER,(short) 3);
//        map2.put(Role.FLIGHT_ENGINEER,(short) 3);
//
//        Criteria<Spaceship> a = new SpaceshipCriteria(null,null,map1,null,null);
//        SpaceshipServiceImpl.getInstance().createSpaceship(new Spaceship(null,"q",map1,null));
//        SpaceshipServiceImpl.getInstance().createSpaceship(new Spaceship(null,"w",map2,null));
//      //  System.out.println(SpaceshipServiceImpl.getInstance().findAllSpaceshipsByCriteria(a));
//        SpacemapServiceImpl.getInstance();
//        SpacemapServiceImpl.getInstance().getRandomPlanet();
        NassaContext nassaContext = new NassaContext();
        nassaContext.init();
        System.out.println(nassaContext.retrieveBaseEntityList(Planet.class));
    }
}