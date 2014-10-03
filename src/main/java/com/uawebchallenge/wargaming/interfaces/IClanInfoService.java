package com.uawebchallenge.wargaming.interfaces;

import java.util.List;

import com.uawebchallenge.wargaming.models.ClanInfo;

public interface IClanInfoService {

    List<ClanInfo> getClanInfos(Integer limit, Integer pageNo);
}
