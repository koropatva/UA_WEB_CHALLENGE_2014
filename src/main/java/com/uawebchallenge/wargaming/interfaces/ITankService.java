package com.uawebchallenge.wargaming.interfaces;

import java.util.List;

import com.uawebchallenge.wargaming.models.Tank;

public interface ITankService {
   
    List<Integer> getListTankIdsWithLevels(Integer... levels);

    Tank chooseRandomTank(Integer... levels);
    
    Tank getTankById(Integer tankId);
}
