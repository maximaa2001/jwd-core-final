package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.FlightMission;
import com.epam.jwd.core_final.service.MissionService;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MissionServiceImpl implements MissionService {
    private static MissionServiceImpl instance;
    private List<FlightMission> missions = new ArrayList<>();

    private MissionServiceImpl(){

    }
    @Override
    public List<FlightMission> findAllMissions() {
        return missions;
    }

    @Override
    public List<FlightMission> findAllMissionsByCriteria(Criteria<? extends FlightMission> criteria) {
        List<FlightMission> missionsByCriteria;
        missionsByCriteria = findByCriteria(criteria).collect(Collectors.toList());
        return missionsByCriteria;
    }

    @Override
    public Optional<FlightMission> findMissionByCriteria(Criteria<? extends FlightMission> criteria) {
        return findByCriteria(criteria).findAny();
    }

    @Override
    public FlightMission updateSpaceshipDetails(FlightMission flightMission) {
        for(FlightMission mission: missions){
            if(mission.getName().equals(flightMission.getName())){
                mission.setId(flightMission.getId());
                mission.setStartDate(flightMission.getStartDate());
                mission.setAssignedSpaceShift(flightMission.getAssignedSpaceShift());
                mission.setAssignedCrew(flightMission.getAssignedCrew());
                mission.setMissionResult(flightMission.getMissionResult());
                mission.setFromPlanet(flightMission.getFromPlanet());
                mission.setToPlanet(flightMission.getToPlanet());
                mission.setDistance();
                mission.setEndDate();
                return mission;
            }
        }
        return null;
    }

    @Override
    public FlightMission createMission(FlightMission flightMission) {
        for(FlightMission mission: missions){
            if(mission.getName().equals(flightMission.getName())){
                return mission;
            }
        }
        missions.add(flightMission);
        return flightMission;
    }

    public static MissionServiceImpl getInstance() throws IOException {
        if(instance == null){
            instance = new MissionServiceImpl();
        }
        return instance;
    }

    private Stream<FlightMission> findByCriteria(Criteria<? extends FlightMission> criteria){
        return missions.stream()
                .filter(mission ->{
                    if(criteria.getId() == null){
                        return true;
                    }else {
                        return mission.getId().equals(criteria.getId());
                    }
                })
                .filter(mission ->{
                    if(criteria.getName() == null){
                        return true;
                    }else {
                        return mission.getName().equals(criteria.getName());
                    }
                })
                .filter(mission ->{
                    if(criteria.getStartDate() == null){
                        return true;
                    }else {
                        return mission.getStartDate() == criteria.getStartDate();
                    }
                })
                .filter(mission ->{
                    if(criteria.getEndDate() == null){
                        return true;
                    }else {
                        return mission.getEndDate() == criteria.getEndDate();
                    }
                })
                .filter(mission ->{
                    if(criteria.getDistance() == null){
                        return true;
                    }else {
                        return mission.getDistance() == criteria.getDistance();
                    }
                })
                .filter(mission ->{
                    if(criteria.getAssignedSpaceShift() == null){
                        return true;
                    }else {
                        return mission.getAssignedSpaceShift() == criteria.getAssignedSpaceShift();
                    }
                })
                .filter(mission ->{
                    if(criteria.getAssignedCrew() == null){
                        return true;
                    }else {
                        return mission.getAssignedCrew() == criteria.getAssignedCrew();
                    }
                })
                .filter(mission ->{
                    if(criteria.getMissionResult() == null){
                        return true;
                    }else {
                        return mission.getMissionResult() == criteria.getMissionResult();
                    }
                })
                .filter(mission ->{
                    if(criteria.getFromPlanet() == null){
                        return true;
                    }else {
                        return mission.getFromPlanet() == criteria.getFromPlanet();
                    }
                })
                .filter(mission ->{
                    if(criteria.getToPlanet() == null){
                        return true;
                    }else {
                        return mission.getToPlanet() == criteria.getToPlanet();
                    }
                });
    }
}
