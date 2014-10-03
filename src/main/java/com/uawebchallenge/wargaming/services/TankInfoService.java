package com.uawebchallenge.wargaming.services;

import org.springframework.stereotype.Service;

import com.uawebchallenge.wargaming.interfaces.ITankInfoService;
import com.uawebchallenge.wargaming.models.TankInfo;
import com.uawebchallenge.wargaming.models.response.TankInfoResponse;

@Service
public class TankInfoService extends AbstractWargamingService<TankInfoResponse>
        implements
            ITankInfoService {

    private static final String CLAN_LIST = "encyclopedia/tankinfo/";

    @Override
    protected String getSelectedFieldList() {
        return "gun_damage_min,gun_damage_max,max_health,tank_id,level,nation_i18n,short_name_i18n";
    }
    
    @Override
    public String getSuffix() {
        return CLAN_LIST;
    }

    @Override
    public TankInfo getTankInfo(Integer tankId) {
        String appenders = "&tank_id=" + tankId;
        TankInfoResponse response = getObject(TankInfoResponse.class, appenders);
        return response.getData().get(tankId);
    }

}
