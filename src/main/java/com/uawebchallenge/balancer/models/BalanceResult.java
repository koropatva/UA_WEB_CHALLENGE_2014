package com.uawebchallenge.balancer.models;

public class BalanceResult {

    public BalanceResult(Team firstTeam , Team secondTeam) {
        this.firstTeam = firstTeam;
        this.secondTeam = secondTeam;
    }
    
    private Team firstTeam;

    private Team secondTeam;

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

}
