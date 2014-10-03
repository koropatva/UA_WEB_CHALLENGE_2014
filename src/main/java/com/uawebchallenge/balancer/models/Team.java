package com.uawebchallenge.balancer.models;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import com.uawebchallenge.wargaming.models.ClanInfo;
import com.uawebchallenge.wargaming.models.Member;

public class Team {

    public Team(ClanInfo clanInfo, List<Member> members) {
        this.clanInfo = clanInfo;
        this.members = members;
        this.players = new ArrayList<Player>();
    }

    private ClanInfo clanInfo;

    private List<Player> players;

    private List<Member> members;

    public Integer getTeamBalance() {
        Integer teamBalance = 0;
        for (Player player : players) {
            teamBalance += player.calculateBalance();
        }

        return teamBalance;
    }

    public Member getReadyMember() {
        List<Member> readyMemmbers = new ArrayList<Member>(members);
        Collections.copy(readyMemmbers, members);
        for (Player player : players) {
            readyMemmbers.remove(player.getMember());
        }

        return readyMemmbers.get(new Random().nextInt(readyMemmbers.size()));
    }

    public void addPlayer(Player player) {
        players.add(player);
    }

    public ClanInfo getClanInfo() {
        return clanInfo;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setClanInfo(ClanInfo clanInfo) {
        this.clanInfo = clanInfo;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public void setPlayers(List<Player> players) {
        this.players = players;
    }

}
