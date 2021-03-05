package com.epam.jwd.core_final.criteria;

import com.epam.jwd.core_final.domain.BaseEntity;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;

/**
 * Should be a builder for {@link com.epam.jwd.core_final.domain.CrewMember} fields
 */
public class CrewMemberCriteria extends Criteria<CrewMember> {
    private Role role;
    private Rank rank;
    private Boolean isReadyForNextMission;

    public CrewMemberCriteria(Long id,Role role, String name, Rank rank, Boolean isReadyForNextMission) {
        super(id, name);
        this.role = role;
        this.rank = rank;
        this.isReadyForNextMission = isReadyForNextMission;
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
        return "CrewMemberCriteria{" +
                "role=" + role +
                ", rank=" + rank +
                ", isReadyForNextMission=" + isReadyForNextMission +"  "+ getId() + "  " + getName()+
                '}';
    }

    public static class CrewMemberCriteriaBuilder extends CriteriaBuilder<CrewMember>{
        private Role role;
        private Rank rank;
        private boolean isReadyForNextMission;

        public void setRole(Role role){
            this.role = role;
        }

        public void setRank(Rank rank) {
            this.rank = rank;
        }

        public void setReadyForNextMission(boolean readyForNextMission) {
            isReadyForNextMission = readyForNextMission;
        }

        public CrewMemberCriteria build(){
            return new CrewMemberCriteria(id,role,name,rank,isReadyForNextMission);
        }

    }
}
