package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.*;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * Should be a builder for {@link BaseEntity} fields
 */
public abstract class Criteria<T extends BaseEntity> {
    private Long id;
    private String name;

    public Criteria(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Role getRole() {
        return null;
    }

    public Rank getRank() {
        return null;
    }

    public Boolean getReadyForNextMission() {
        return null;
    }

    public LocalDateTime getStartDate() {
        return null;
    }

    public LocalDateTime getEndDate() {
        return null;
    }

    public Long getDistance() {
        return null;
    }

    public Spaceship getAssignedSpaceShift() {
        return null;
    }

    public List<CrewMember> getAssignedCrew() {
        return null;
    }

    public MissionResult getMissionResult() {
        return null;
    }

    public Planet getFromPlanet() {
        return null;
    }

    public Planet getToPlanet() {
        return null;
    }

    public Map<Role, Short> getCrew() {
        return null;
    }

    public Long getFlightDistance() {
        return null;
    }


    public static class CriteriaBuilder<T extends BaseEntity> {
        protected Long id;
        protected String name;

        public void setId(Long id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }

        public CrewMemberCriteria buildCrewMemberCriteria() {
            return new CrewMemberCriteria(id, null, name, null, null);
        }

        public FlightMissionCriteria buildFlightMissionCriteria() {
            return new FlightMissionCriteria(id, name, null, null, null, null, null,
                    null, null, null);
        }

        public SpaceshipCriteria buildSpaceshipCriteria() {
            return new SpaceshipCriteria(id, name, null, null, null);
        }
    }
}
