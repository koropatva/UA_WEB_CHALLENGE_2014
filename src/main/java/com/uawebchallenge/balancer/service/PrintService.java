package com.uawebchallenge.balancer.service;

import org.springframework.stereotype.Service;

import com.uawebchallenge.balancer.interfaces.IPrintService;
import com.uawebchallenge.balancer.models.BalanceResult;
import com.uawebchallenge.balancer.models.Player;

@Service
public class PrintService implements IPrintService {

    @Override
    public void print(BalanceResult balanceResult) {
        int memberCount =
                BalancerService.COUNT_OF_THE_REST_TANKS + BalancerService.COUNTS_OF_RANDOM_TANKS;
        System.out
                .println("==============================================================================================================================================================");
        System.out
                .println("============================================================================RESULT============================================================================");
        System.out
                .println("==============================================================================================================================================================");
        System.out.println();
        System.out.printf("%-75s%s\n", "FIRST CLAN NAME", "SECOND CLAN NAME");
        System.out.printf("%-75s%s\n", balanceResult.getFirstTeam().getClanInfo().getName(),
                balanceResult.getSecondTeam().getClanInfo().getName());
        System.out.println();
        System.out.printf("%-25s %15s %3s %-15s%-7s%6s         %-25s %15s %3s %-15s%-7s%6s\n",
                "Member name", "Country", "LVL", "Name", "TankId", "Power", "Member name",
                "Country", "LVL", "Name", "TankId", "Power");
        System.out.println();
        for (int i = 0; i < memberCount; i++) {
            Player firstPlayer = balanceResult.getFirstTeam().getPlayers().get(i);
            Player secondPlayer = balanceResult.getSecondTeam().getPlayers().get(i);
            System.out.printf("%-25s %15s %3d %-15s%-7d%6d         %-25s %15s %3d %-15s%-7d%6d\n",
                    firstPlayer.getMember().getAccountName(), firstPlayer.getTankInfo()
                            .getNationName(), firstPlayer.getTankInfo().getLevel(), firstPlayer
                            .getTankInfo().getShortName(), firstPlayer.getTankInfo().getTankId(),
                    firstPlayer.calculateBalance(), secondPlayer.getMember().getAccountName(),
                    secondPlayer.getTankInfo().getNationName(), secondPlayer.getTankInfo()
                            .getLevel(), secondPlayer.getTankInfo().getShortName(), secondPlayer
                            .getTankInfo().getTankId(), secondPlayer.calculateBalance());
        }
        System.out.println();
        System.out.printf("%74s%83s\n", "Team balance:"
                + balanceResult.getFirstTeam().getTeamBalance(), "Team balance:"
                + balanceResult.getSecondTeam().getTeamBalance());
        System.out.println();
        System.out
                .println("==============================================================================================================================================================");
    }
}
