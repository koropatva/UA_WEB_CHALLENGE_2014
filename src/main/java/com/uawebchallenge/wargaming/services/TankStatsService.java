package com.uawebchallenge.wargaming.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uawebchallenge.wargaming.interfaces.ITankStatsService;
import com.uawebchallenge.wargaming.models.TankStats;
import com.uawebchallenge.wargaming.models.response.TankStatsResponse;

@Service
public class TankStatsService extends AbstractWargamingService<TankStatsResponse>
        implements
            ITankStatsService {

    private static final String CLAN_LIST = "tanks/stats/";

    @Override
    protected String getSelectedFieldList() {
        return "tank_id,account_id,mark_of_mastery";
    }

    @Override
    public String getSuffix() {
        return CLAN_LIST;
    }

    @Override
    public TankStats getTankStats(Integer accountId, Integer tankId) {
        List<TankStats> tankStats = getTankStats(accountId, new ArrayList<Integer>(tankId));
        if (tankStats.isEmpty()) {
            return null;
        } else {
            return tankStats.get(0);
        }
    }

    public List<TankStats> getTankStats(Integer accountId, List<Integer> tanksIds) {
        StringBuilder builder = new StringBuilder();
        for (Integer integer : tanksIds) {
            builder.append(integer);
            builder.append(",");
        }
        String appenders = "&account_id=" + accountId + "&tank_id=" + builder.toString();
        TankStatsResponse response = getObject(TankStatsResponse.class, appenders);
        return response.getData().get(accountId) != null
                ? response.getData().get(accountId)
                : new ArrayList<TankStats>();
    }
}
