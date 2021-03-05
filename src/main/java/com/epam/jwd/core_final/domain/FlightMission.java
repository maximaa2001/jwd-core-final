package com.epam.jwd.core_final.domain;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Expected fields:
 * <p>
 * missions name {@link String}
 * start date {@link java.time.LocalDate}
 * end date {@link java.time.LocalDate}
 * distance {@link Long} - missions distance
 * assignedSpaceShift {@link Spaceship} - not defined by default
 * assignedCrew {@link java.util.List<CrewMember>} - list of missions members based on ship capacity - not defined by default
 * missionResult {@link MissionResult}
 * from {@link Planet}
 * to {@link Planet}
 */
public class FlightMission extends AbstractBaseEntity {

    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long distance;
    private Spaceship assignedSpaceShift;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;
    private Planet fromPlanet;
    private Planet toPlanet;

    public FlightMission(Long id, String name, LocalDateTime startDate,Spaceship assignedSpaceShift, List<CrewMember> assignedCrew,
                         Planet fromPlanet,Planet toPlanet  ) {
        super(id, name);
        this.name = name;
        this.startDate = startDate;
        this.assignedSpaceShift = assignedSpaceShift;
        this.assignedCrew = assignedCrew;
        this.fromPlanet = fromPlanet;
        this.toPlanet = toPlanet;
        missionResult = MissionResult.PLANNED;
        if(fromPlanet != null && toPlanet != null) {
            distance = (long) Math.sqrt(Math.pow(toPlanet.getLocation().getX() - fromPlanet.getLocation().getX(), 2) +
                    Math.pow(toPlanet.getLocation().getY() - fromPlanet.getLocation().getY(), 2));
            endDate = startDate.plusSeconds(distance);
        }
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public void setStartDate(LocalDateTime startDate) {
        this.startDate = startDate;
    }

    public void setEndDate() {
        if(startDate != null && distance != null){
            endDate = startDate.plusSeconds(distance);
        }
    }

    public void setDistance() {
        if(fromPlanet != null && toPlanet != null) {
            distance = (long) Math.sqrt(Math.pow(toPlanet.getLocation().getX() - fromPlanet.getLocation().getX(), 2) +
                    Math.pow(toPlanet.getLocation().getY() - fromPlanet.getLocation().getY(), 2));
        }
    }

    public void setAssignedSpaceShift(Spaceship assignedSpaceShift) {
        this.assignedSpaceShift = assignedSpaceShift;
    }

    public void setAssignedCrew(List<CrewMember> assignedCrew) {
        this.assignedCrew = assignedCrew;
    }

    public void setMissionResult(MissionResult missionResult) {
        this.missionResult = missionResult;
    }

    public void setFromPlanet(Planet fromPlanet) {
        this.fromPlanet = fromPlanet;
    }

    public void setToPlanet(Planet toPlanet) {
        this.toPlanet = toPlanet;
    }

    @Override
    public String getName() {
        return name;
    }

    public LocalDateTime getStartDate() {
        return startDate;
    }

    public LocalDateTime getEndDate() {
        return endDate;
    }

    public Long getDistance() {
        return distance;
    }

    public Spaceship getAssignedSpaceShift() {
        return assignedSpaceShift;
    }

    public List<CrewMember> getAssignedCrew() {
        return assignedCrew;
    }

    public MissionResult getMissionResult() {
        return missionResult;
    }

    public Planet getFromPlanet() {
        return fromPlanet;
    }

    public Planet getToPlanet() {
        return toPlanet;
    }
    // todo
}
