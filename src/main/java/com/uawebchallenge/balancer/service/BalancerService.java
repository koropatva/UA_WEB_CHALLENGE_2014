package com.uawebchallenge.balancer.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import com.uawebchallenge.balancer.interfaces.IBalancerService;
import com.uawebchallenge.balancer.interfaces.IRandomizerService;
import com.uawebchallenge.balancer.models.BalanceResult;
import com.uawebchallenge.balancer.models.CommingData;
import com.uawebchallenge.balancer.models.Player;
import com.uawebchallenge.balancer.models.Team;
import com.uawebchallenge.wargaming.interfaces.IMemberClanInfoService;
import com.uawebchallenge.wargaming.models.GlobalClanInfo;
import com.uawebchallenge.wargaming.models.Member;

@Service
public class BalancerService implements IBalancerService {

    private static final int ASSUMED_BALANCE_VALUE = 200;

    static final int COUNT_OF_THE_REST_TANKS = 8;

    static final int COUNTS_OF_RANDOM_TANKS = 7;

    @Autowired
    private IRandomizerService iRandomizerService;

    @Autowired
    private IMemberClanInfoService iMemberClanInfoService;

    @Resource
    private ApplicationContext ctx;

    private Team firstTeam;
    private Team secondTeam;

    private void init(final CommingData commingData) {
        System.out.println("Select top clans for battle...");
        for (int i = 0; i < 1; i++) {

            List<GlobalClanInfo> globalClanInfos =
                    iRandomizerService.selectTwoRandomGlobalClan(commingData.getMapName(),
                            commingData.getTopClanCount());

            GlobalClanInfo firstClanInfo = globalClanInfos.get(0);
            GlobalClanInfo secondClanInfo = globalClanInfos.get(1);

            List<Member> firstClanMembers =
                    iMemberClanInfoService.getMembers(firstClanInfo.getClanId());
            List<Member> secondClanMembers =
                    iMemberClanInfoService.getMembers(secondClanInfo.getClanId());

            firstTeam = new Team(firstClanInfo, firstClanMembers);
            secondTeam = new Team(secondClanInfo, secondClanMembers);
        }
    }

    public BalanceResult calculateResult(final CommingData commingData) {
        init(commingData);

        System.out.println("Filling first " + COUNTS_OF_RANDOM_TANKS + " tanks for first team...");
        fillFirstPartOfTeam(commingData, firstTeam);
        System.out.println("Filling first " + COUNTS_OF_RANDOM_TANKS + " tanks for second team...");
        fillFirstPartOfTeam(commingData, secondTeam);

        System.out.println("Random balancer");
        System.out.println(firstTeam.getTeamBalance());
        System.out.println(secondTeam.getTeamBalance());

        System.out.println("Equate teams...");
        fillSecondPartOfTeam(commingData);

        return new BalanceResult(firstTeam, secondTeam);
    }

    private void fillSecondPartOfTeam(final CommingData commingData) {
        for (int i = COUNTS_OF_RANDOM_TANKS; i < COUNTS_OF_RANDOM_TANKS + COUNT_OF_THE_REST_TANKS; i++) {
            System.out.println("Searching " + (i + 1) + " player for the first team...");
            int balance = firstTeam.getTeamBalance() - secondTeam.getTeamBalance();
            System.out.println("Balance abs: " + Math.abs(balance));
            addSearchPLayer(commingData, balance, firstTeam);
            System.out.println("Searching " + (i + 1) + " player for the second team...");
            addSearchPLayer(commingData, -balance, secondTeam);
        }
    }

    private void addSearchPLayer(final CommingData commingData, Integer balance, Team team) {
        Player player;

        if (Math.abs(balance) > ASSUMED_BALANCE_VALUE) {
            int firstMaxPlayerBalance = calculateMaxBalance(balance, team);
            if (balance > 0) {
                player =
                        iRandomizerService.chooseMaxRandomPlayer(commingData, team,
                                firstMaxPlayerBalance);
            } else {
                player =
                        iRandomizerService.chooseMinRandomPlayer(commingData, team,
                                firstMaxPlayerBalance);
            }
        } else {
            player = iRandomizerService.chooseRandomPlayer(commingData, team);
        }
        System.out.println("Selected players balance:" + player.calculateBalance());
        team.addPlayer(player);
    }

    private int calculateMaxBalance(final Integer balance, final Team team) {
        return (team.getTeamBalance() - balance) / team.getPlayers().size();
    }

    /**
     * First part of filling try to fill 7 of needed tanks in random way.
     */
    private void fillFirstPartOfTeam(final CommingData commingData, final Team team) {
        for (int i = 0; i < COUNTS_OF_RANDOM_TANKS; i++) {
            Player player = iRandomizerService.chooseRandomPlayer(commingData, team);
            team.addPlayer(player);
        }
    }


}
