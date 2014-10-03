package com.uawebchallenge.wargaming.models.response;

import java.util.List;
import java.util.Map;

import com.uawebchallenge.wargaming.models.TankStats;

public class TankStatsResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    
    private Map<Integer, List<TankStats>> data;

    public Map<Integer, List<TankStats>> getData() {
        return data;
    }

    public void setData(Map<Integer, List<TankStats>> data) {
        this.data = data;
    }

}
