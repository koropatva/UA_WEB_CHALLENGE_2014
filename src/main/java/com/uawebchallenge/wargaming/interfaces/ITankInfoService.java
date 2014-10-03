package com.uawebchallenge.wargaming.interfaces;

import com.uawebchallenge.wargaming.models.TankInfo;

public interface ITankInfoService {
    TankInfo getTankInfo(Integer tankId);
}
