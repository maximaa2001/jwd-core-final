package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.domain.Spaceship;
import com.epam.jwd.core_final.exception.SpaceshipIsNotAssignedException;
import com.epam.jwd.core_final.exception.SpaceshipIsNotCreatedException;
import com.epam.jwd.core_final.service.SpaceshipService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SpaceshipServiceImpl implements SpaceshipService {
    private static SpaceshipServiceImpl instance;
    private List<Spaceship> spaceships = new ArrayList<>();

    private SpaceshipServiceImpl(){

    }

    @Override
    public List<Spaceship> findAllSpaceships() {
        return spaceships;
    }

    @Override
    public List<Spaceship> findAllSpaceshipsByCriteria(Criteria<? extends Spaceship> criteria) {
        List<Spaceship> spaceshipsByCriteria = new ArrayList<>();
        spaceshipsByCriteria = findByCriteria(criteria).collect(Collectors.toList());
        return spaceshipsByCriteria;
    }

    @Override
    public Optional<Spaceship> findSpaceshipByCriteria(Criteria<? extends Spaceship> criteria) {
        return findByCriteria(criteria).findAny();
    }

    @Override
    public Spaceship updateSpaceshipDetails(Spaceship spaceship) {
        for(Spaceship ship: spaceships){
            if(ship.getName().equals(spaceship.getName())){
                ship.setId(spaceship.getId());
                ship.setCrew(spaceship.getCrew());
                ship.setFlightDistance(spaceship.getFlightDistance());
                ship.setReadyForNextMissions(spaceship.getReadyForNextMissions());
                return ship;
            }
        }
        return null;
    }

    @Override
    public void assignSpaceshipOnMission(Spaceship spaceship) throws RuntimeException {
        if(!spaceship.getReadyForNextMissions()){
            throw new SpaceshipIsNotAssignedException("Spaceship is not assigned");
        }
    }

    @Override
    public Spaceship createSpaceship(Spaceship spaceship) throws RuntimeException {
        for(Spaceship ship: spaceships){
            if(ship.getName().equals(spaceship.getName())){
                throw new SpaceshipIsNotCreatedException("Spaceship already is exist");
            }
        }
        spaceships.add(spaceship);
        return spaceship;
    }

    public static SpaceshipServiceImpl getInstance(){
        if(instance == null){
            instance = new SpaceshipServiceImpl();
        }
        return instance;
    }

    private Stream<Spaceship> findByCriteria(Criteria<? extends Spaceship> criteria){
        return spaceships.stream()
                .filter(spaceship -> {
                    if(criteria.getId() == null){
                        return true;
                    }else {
                        return spaceship.getId().equals(criteria.getId());
                    }
                })
                .filter(spaceship -> {
                    if(criteria.getName() == null){
                        return true;
                    }else {
                        return spaceship.getName().equals(criteria.getName());
                    }
                })
                .filter(spaceship -> {
                    if(criteria.getCrew() == null){
                        return true;
                    }else {
                        return spaceship.getCrew().equals(criteria.getCrew());
                    }
                })
                .filter(spaceship -> {
                    if(criteria.getFlightDistance() == null){
                        return true;
                    }else {
                        return spaceship.getFlightDistance().equals(criteria.getFlightDistance());
                    }
                })
                .filter(spaceship -> {
                    if(criteria.getReadyForNextMission() == null){
                        return true;
                    }else {
                        return spaceship.getReadyForNextMissions().equals(criteria.getReadyForNextMission());
                    }
                });
    }
}
