package com.uawebchallenge.wargaming.interfaces;

import java.util.List;

import com.uawebchallenge.wargaming.models.Member;

public interface IMemberClanInfoService {

    List<Member> getMembers(Integer clanId);
    
    List<Member> getMembers(Integer clanId, Integer limit);
}
