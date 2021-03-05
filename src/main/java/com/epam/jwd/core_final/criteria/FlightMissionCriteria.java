package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.FlightMission} fields
 */
public class FlightMissionCriteria extends Criteria<FlightMission> {
    private String name;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long distance;
    private Spaceship assignedSpaceShift;
    private List<CrewMember> assignedCrew;
    private MissionResult missionResult;
    private Planet fromPlanet;
    private Planet toPlanet;

    public FlightMissionCriteria(Long id, String name, LocalDateTime startDate, LocalDateTime endDate,
                                 Long distance, Spaceship assignedSpaceShift, List<CrewMember> assignedCrew,
                                 MissionResult missionResult, Planet fromPlanet, Planet toPlanet) {
        super(id, name);
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.distance = distance;
        this.assignedSpaceShift = assignedSpaceShift;
        this.assignedCrew = assignedCrew;
        this.missionResult = missionResult;
        this.fromPlanet = fromPlanet;
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



    @Override
    public String toString() {
        return "FlightMissionCriteria{" +
                "name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", distance=" + distance +
                ", assignedSpaceShift=" + assignedSpaceShift +
                ", assignedCrew=" + assignedCrew +
                ", missionResult=" + missionResult +
                ", fromPlanet=" + fromPlanet +
                ", toPlanet=" + toPlanet + "  "+ getId() + "  " + getName()+
                '}';
    }



    public static class FlightMissionCriteriaBuilder extends CriteriaBuilder<FlightMission>{
        private String name;
        private LocalDateTime startDate;
        private LocalDateTime endDate;
        private Long distance;
        private Spaceship assignedSpaceShift;
        private List<CrewMember> assignedCrew;
        private MissionResult missionResult;
        private Planet fromPlanet;
        private Planet toPlanet;

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

        public FlightMissionCriteria build(){
            return new FlightMissionCriteria(id,name,startDate,endDate,distance,assignedSpaceShift,assignedCrew,missionResult,
                    fromPlanet,toPlanet);
        }

    }
}
