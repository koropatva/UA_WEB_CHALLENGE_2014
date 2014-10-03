package com.uawebchallenge.wargaming.interfaces;

import java.util.List;

import com.uawebchallenge.wargaming.models.TankStats;

public interface ITankStatsService {
    
    TankStats getTankStats(Integer accountId, Integer tankId);

    List<TankStats> getTankStats(Integer accountId, List<Integer> tanksIds);
}
