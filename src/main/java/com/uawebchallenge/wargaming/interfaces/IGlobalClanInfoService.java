package com.uawebchallenge.wargaming.interfaces;

import java.util.List;

import com.uawebchallenge.wargaming.models.GlobalClanInfo;

public interface IGlobalClanInfoService {

    List<GlobalClanInfo> getGlobalClanInfos(String mapId, Integer limit, String orderBy);
}
