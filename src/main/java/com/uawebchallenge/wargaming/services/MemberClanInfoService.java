package com.uawebchallenge.wargaming.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import com.uawebchallenge.wargaming.interfaces.IMemberClanInfoService;
import com.uawebchallenge.wargaming.models.Member;
import com.uawebchallenge.wargaming.models.response.MembersClanInfoResponse;

@Service
public class MemberClanInfoService extends AbstractWargamingService<MembersClanInfoResponse>
        implements
            IMemberClanInfoService {

    private static final String CLAN_LIST = "clan/info/";

    @Override
    protected String getSelectedFieldList() {
        return "members,members.account_id,members.account_name";
    }

    @Override
    public String getSuffix() {
        return CLAN_LIST;
    }
    
    @Override
    public List<Member> getMembers(Integer clanId) {
        return getMembers(clanId, 0);
    }
    
    @Override
    public List<Member> getMembers(Integer clanId, Integer limit) {
        String appenders = "&clan_id=" + clanId;
        MembersClanInfoResponse response =
                getObject(MembersClanInfoResponse.class, appenders, limit, 0);
        Collection<Member> collection = response.getData().get(clanId).getMembers().values();
        return new ArrayList<Member>(collection);
    }
}
