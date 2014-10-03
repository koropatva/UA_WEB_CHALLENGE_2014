package com.uawebchallenge.wargaming.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.uawebchallenge.wargaming.interfaces.IClanInfoService;
import com.uawebchallenge.wargaming.models.ClanInfo;
import com.uawebchallenge.wargaming.models.response.ClanInfoResponse;

@Service
public class ClanInfoService extends AbstractWargamingService<ClanInfoResponse>
        implements
            IClanInfoService {

    private static final String CLAN_LIST = "clan/list/";

    @Override
    public String getSuffix() {
        return CLAN_LIST;
    }

    @Override
    protected String getSelectedFieldList() {
        return "clan_id,name";
    }

    @Override
    public List<ClanInfo> getClanInfos(Integer limit, Integer pageNo) {
        ClanInfoResponse clanInfoResponse = getObject(ClanInfoResponse.class, "", limit, pageNo);
        return clanInfoResponse.getData();
    }

}
