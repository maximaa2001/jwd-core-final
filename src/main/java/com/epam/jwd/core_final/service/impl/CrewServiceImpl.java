package com.epam.jwd.core_final.service.impl;

import com.epam.jwd.core_final.criteria.Criteria;
import com.epam.jwd.core_final.domain.CrewMember;
import com.epam.jwd.core_final.domain.Rank;
import com.epam.jwd.core_final.domain.Role;
import com.epam.jwd.core_final.exception.CrewMemberIsNotAssignedException;
import com.epam.jwd.core_final.exception.CrewMemberIsNotCreatedException;
import com.epam.jwd.core_final.service.CrewService;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CrewServiceImpl implements CrewService {
    private static CrewServiceImpl instance;
    private List<CrewMember> crewMembers = new ArrayList<>();

    private CrewServiceImpl()throws IOException{

    }
    @Override
    public List<CrewMember> findAllCrewMembers()  {
        return crewMembers;
    }

    @Override
    public List<CrewMember> findAllCrewMembersByCriteria(Criteria<? extends CrewMember> criteria) {
        List<CrewMember> membersByCriteria;
        membersByCriteria = findByCriteria(criteria).collect(Collectors.toList());
        return membersByCriteria;
    }

    @Override
    public Optional<CrewMember> findCrewMemberByCriteria(Criteria<? extends CrewMember> criteria) {
        return findByCriteria(criteria).findAny();
    }

    @Override
    public CrewMember updateCrewMemberDetails(CrewMember crewMember) {
        for(CrewMember member: crewMembers){
            if(member.getName().equals(crewMember.getName())){
                member.setId(crewMember.getId());
                member.setRole(crewMember.getRole());
                member.setRank(crewMember.getRank());
                member.setReadyForNextMission(crewMember.getReadyForNextMission());
                return member;
            }
        }
        return null;
    }

    @Override
    public void assignCrewMemberOnMission(CrewMember crewMember) throws RuntimeException {
        if(!crewMember.getReadyForNextMission()){
            throw new CrewMemberIsNotAssignedException("Member is not assigned");
        }
    }

    @Override
    public CrewMember createCrewMember(CrewMember crewMember) throws RuntimeException {
        for(CrewMember member: crewMembers){
            if(member.getName().equals(crewMember.getName())){
                throw new CrewMemberIsNotCreatedException("Member already is exist");
            }
        }
        crewMembers.add(crewMember);
        return crewMember;
    }

    public static CrewServiceImpl getInstance() throws IOException {
        if(instance == null){
            instance = new CrewServiceImpl();
        }
        return instance;
    }

    private Stream<CrewMember> findByCriteria(Criteria<? extends CrewMember> criteria){
        return crewMembers.stream()
                .filter(member ->{
                    if(criteria.getId() == null){
                        return true;
                    }else {
                        return member.getId().equals(criteria.getId());
                    }
                })
                .filter(member ->{
                    if(criteria.getName() == null){
                        return true;
                    }else {
                        return member.getName().equals(criteria.getName());
                    }
                })
                .filter(member ->{
                    if(criteria.getRole() == null){
                        return true;
                    }else {
                        return member.getRole() == criteria.getRole();
                    }
                })
                .filter(member ->{
                    if(criteria.getRank() == null){
                        return true;
                    }else {
                        return member.getRank() == criteria.getRank();
                    }
                })
                .filter(member ->{
                    if(criteria.getReadyForNextMission() == null){
                        return true;
                    }else {
                        return member.getReadyForNextMission() == criteria.getReadyForNextMission();
                    }
                });
    }
}
