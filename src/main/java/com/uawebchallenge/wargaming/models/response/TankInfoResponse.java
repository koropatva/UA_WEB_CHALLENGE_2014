package com.uawebchallenge.wargaming.models.response;

import java.util.Map;

import com.uawebchallenge.wargaming.models.TankInfo;

public class TankInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    
    private Map<Integer, TankInfo> data;

    public Map<Integer, TankInfo> getData() {
        return data;
    }

    public void setData(Map<Integer, TankInfo> data) {
        this.data = data;
    }

}
