package com.epam.jwd.core_final.domain;

import com.epam.jwd.core_final.criteria.CrewMemberCriteria;

/**
 * Expected fields:
 * <p>
 * role {@link Role} - member role
 * rank {@link Rank} - member rank
 * isReadyForNextMissions {@link Boolean} - true by default. Set to false, after first failed mission
 */
public class CrewMember extends AbstractBaseEntity {

    private Role role;
    private Rank rank;
    private Boolean isReadyForNextMission;

    public CrewMember(Long id,Role role, String name, Rank rank){
        super(id,name);
        this.role = role;
        this.rank = rank;
        isReadyForNextMission = true;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setRank(Rank rank) {
        this.rank = rank;
    }

    public void setReadyForNextMission(Boolean readyForNextMission) {
        isReadyForNextMission = readyForNextMission;
    }

    public Role getRole() {
        return role;
    }

    public Rank getRank() {
        return rank;
    }

    public Boolean getReadyForNextMission() {
        return isReadyForNextMission;
    }

    @Override
    public String toString() {
        return "CrewMember{" +
                "role=" + role +
                ", rank=" + rank +
                ", isReadyForNextMission=" + isReadyForNextMission +
                '}';
    }
    // todo
}
