package com.uawebchallenge.wargaming.models.response;

import java.util.List;

import com.uawebchallenge.wargaming.models.GlobalClanInfo;

public class GlobalClanInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    
    private List<GlobalClanInfo> data;

    public List<GlobalClanInfo> getData() {
        return data;
    }

    public void setData(List<GlobalClanInfo> data) {
        this.data = data;
    }
}
