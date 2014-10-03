package com.uawebchallenge.balancer.interfaces;

import java.util.List;

import com.uawebchallenge.balancer.models.CommingData;
import com.uawebchallenge.balancer.models.Player;
import com.uawebchallenge.balancer.models.Team;
import com.uawebchallenge.wargaming.models.GlobalClanInfo;

public interface IRandomizerService {
   
    List<GlobalClanInfo> selectTwoRandomGlobalClan(String map, Integer limit);

    Player chooseRandomPlayer(final CommingData commingData, final Team team);

    Player chooseMaxRandomPlayer(final CommingData commingData, final Team team, int maxPlayerBalance);

    Player chooseMinRandomPlayer(final CommingData commingData, final Team team, int maxPlayerBalance);
}
