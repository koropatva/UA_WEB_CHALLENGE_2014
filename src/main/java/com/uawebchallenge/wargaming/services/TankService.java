package com.uawebchallenge.wargaming.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Service;

import com.uawebchallenge.wargaming.interfaces.ITankService;
import com.uawebchallenge.wargaming.models.Tank;
import com.uawebchallenge.wargaming.models.response.TankResponse;

@Service
public class TankService extends AbstractWargamingService<TankResponse> implements ITankService {

    private List<Tank> tanks;

    private static final String CLAN_LIST = "encyclopedia/tanks/";

    @Override
    protected String getSelectedFieldList() {
        return "tank_id,level,nation_i18n,short_name_i18n";
    }

    @Override
    protected String getSuffix() {
        return CLAN_LIST;
    }

    private void init() {
        if (tanks == null) {
            TankResponse response = getObject(TankResponse.class, "");
            tanks = new ArrayList<Tank>(response.getData().values());
        }
    }

    @Override
    public List<Integer> getListTankIdsWithLevels(Integer... levels) {
        init();
        List<Integer> levelTanks = Arrays.asList(levels);
        List<Integer> selectedTanks = new ArrayList<Integer>();
        for (Tank tank : tanks) {
            if (levelTanks.contains(tank.getLevel())) {
                selectedTanks.add(tank.getTankId());
            }
        }
        return selectedTanks;
    }

    @Override
    public Tank chooseRandomTank(Integer... levels) {
        init();

        List<Integer> levelTanks = Arrays.asList(levels);

        // Choose random tank with entered level
        Tank randomTank;
        while (!levelTanks.contains((randomTank = tanks.get(new Random().nextInt(tanks.size())))
                .getLevel())) {}

        return randomTank;
    }

    @Override
    public Tank getTankById(Integer tankId) {
        init();
        for (Tank tank : tanks) {
            if (tank.getTankId().equals(tankId)) {
                return tank;
            }
        }
        return null;
    }

}
