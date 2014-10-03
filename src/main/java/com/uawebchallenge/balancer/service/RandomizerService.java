package com.uawebchallenge.balancer.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uawebchallenge.balancer.interfaces.IRandomizerService;
import com.uawebchallenge.balancer.models.CommingData;
import com.uawebchallenge.balancer.models.Player;
import com.uawebchallenge.balancer.models.Team;
import com.uawebchallenge.wargaming.interfaces.IGlobalClanInfoService;
import com.uawebchallenge.wargaming.interfaces.IMemberClanInfoService;
import com.uawebchallenge.wargaming.interfaces.ITankInfoService;
import com.uawebchallenge.wargaming.interfaces.ITankService;
import com.uawebchallenge.wargaming.interfaces.ITankStatsService;
import com.uawebchallenge.wargaming.models.GlobalClanInfo;
import com.uawebchallenge.wargaming.models.Member;
import com.uawebchallenge.wargaming.models.Tank;
import com.uawebchallenge.wargaming.models.TankStats;

@Service
public class RandomizerService implements IRandomizerService {

    private static final int CHOOSE_RANDOM_PLAYERS = 10;

    private static final String GLOBAL_CLAN_ORDER_BY = "provinces_count";

    @Autowired
    private IGlobalClanInfoService iGlobalClanInfoService;

    @Autowired
    private ITankStatsService iTankStatsService;

    @Autowired
    private ITankInfoService iTankInfoService;

    @Autowired
    private ITankService iTankService;

    @Autowired
    private IMemberClanInfoService iMemberClanInfoService;

    @Override
    public List<GlobalClanInfo> selectTwoRandomGlobalClan(String map, Integer limit) {
        List<GlobalClanInfo> randomList = new ArrayList<GlobalClanInfo>();
        List<GlobalClanInfo> globalClanInfos =
                iGlobalClanInfoService.getGlobalClanInfos(map, limit, GLOBAL_CLAN_ORDER_BY);

        randomList.add(chooseClan(globalClanInfos));
        randomList.add(chooseClan(globalClanInfos));

        return randomList;
    }

    private GlobalClanInfo chooseClan(List<GlobalClanInfo> globalClanInfos) {
        GlobalClanInfo firstClan;
        while (true) {
            if(globalClanInfos.size() == 0) {
                throw new RuntimeException("Can't search two clans with more then 15 members");
            }
            int index = new Random().nextInt(globalClanInfos.size());
            firstClan = globalClanInfos.get(index);
            globalClanInfos.remove(index);

            if (iMemberClanInfoService.getMembers(firstClan.getClanId()).size() >= 15) {
                break;
            }
        }
        return firstClan;
    }

    @Override
    public Player chooseMaxRandomPlayer(CommingData commingData, Team team, int maxPlayerBalance) {
        int counter = 0;
        Player player;
        do {
            player = chooseRandomPlayer(commingData, team);
            counter++;
        } while (player.calculateBalance() > maxPlayerBalance && counter < CHOOSE_RANDOM_PLAYERS);
        return player;
    }
    @Override
    public Player chooseMinRandomPlayer(CommingData commingData, Team team, int minPlayerBalance) {
        int counter = 0;
        Player player;
        do {
            player = chooseRandomPlayer(commingData, team);
            counter++;
        } while (player.calculateBalance() < minPlayerBalance && counter < CHOOSE_RANDOM_PLAYERS);
        return player;
    }

    public Player chooseRandomPlayer(final CommingData commingData, final Team team) {
        Member member;
        TankStats tankStats;
        Tank tank;
        do {
            tank = iTankService.chooseRandomTank(commingData.getTankLevels());
            member = team.getReadyMember();

            tankStats = iTankStatsService.getTankStats(member.getAccountId(), tank.getTankId());
        } while (tankStats == null);

        Player player = fillPlayer(member, tankStats, tank);
        return player;
    }

    private Player fillPlayer(final Member member, final TankStats tankStats, final Tank tank) {
        Player player = new Player();
        player.setTankInfo(iTankInfoService.getTankInfo(tank.getTankId()));
        player.setMember(member);
        player.setMastery(tankStats.getMarkOfMastery());
        return player;
    }

}
