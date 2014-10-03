package com.uawebchallenge.wargaming.models.response;

import java.util.Map;

import com.uawebchallenge.wargaming.models.Tank;

public class TankResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    
    private Map<Integer, Tank> data;

    public Map<Integer, Tank> getData() {
        return data;
    }

    public void setData(Map<Integer, Tank> data) {
        this.data = data;
    }

}
