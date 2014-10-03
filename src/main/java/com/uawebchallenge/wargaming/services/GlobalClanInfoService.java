package com.uawebchallenge.wargaming.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uawebchallenge.wargaming.interfaces.IGlobalClanInfoService;
import com.uawebchallenge.wargaming.models.GlobalClanInfo;
import com.uawebchallenge.wargaming.models.response.GlobalClanInfoResponse;

@Service
public class GlobalClanInfoService extends AbstractWargamingService<GlobalClanInfoResponse>
        implements
            IGlobalClanInfoService {

    private static final String CLAN_LIST = "globalwar/top/";

    @Override
    public String getSuffix() {
        return CLAN_LIST;
    }

    @Override
    protected String getSelectedFieldList() {
        return "wins_count,provinces_count,combats_count,name,clan_id";
    }

    @Override
    public List<GlobalClanInfo> getGlobalClanInfos(String mapId, Integer limit, String orderBy) {
        String appenders = "&map_id=" + mapId + "&order_by=" + orderBy;
        GlobalClanInfoResponse response =
                getObject(GlobalClanInfoResponse.class, appenders, limit, 0);
        return response.getData();
    }
}
