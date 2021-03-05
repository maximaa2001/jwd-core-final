package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.domain.Spaceship;

import java.util.Locale;
import java.util.Map;

/**
 * Should be a builder for {@link Spaceship} fields
 */
public class SpaceshipCriteria extends Criteria<Spaceship> {
    private Map<Role, Short> crew;
    private Long flightDistance;
    private Boolean isReadyForNextMissions;

    public SpaceshipCriteria(Long id, String name, Map<Role, Short> crew, Long flightDistance, Boolean isReadyForNextMissions) {
        super(id, name);
        this.crew = crew;
        this.flightDistance = flightDistance;
        this.isReadyForNextMissions = isReadyForNextMissions;
    }

    public static class SpaceshipCriteriaBuilder extends CriteriaBuilder<Spaceship> {
        private Map<Role, Short> crew;
        private Long flightDistance;
        private boolean isReadyForNextMissions;

        public void setCrew(Map<Role, Short> crew) {
            this.crew = crew;
        }

        public void setFlightDistance(Long flightDistance) {
            this.flightDistance = flightDistance;
        }

        public void setReadyForNextMissions(boolean readyForNextMissions) {
            isReadyForNextMissions = readyForNextMissions;
        }

        public SpaceshipCriteria build() {
            return new SpaceshipCriteria(id, name, crew, flightDistance, isReadyForNextMissions);
        }
    }
}
