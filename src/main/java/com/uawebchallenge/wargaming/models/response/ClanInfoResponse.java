package com.uawebchallenge.wargaming.models.response;

import java.util.List;

import com.uawebchallenge.wargaming.models.ClanInfo;

public class ClanInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 1L;
    
    private List<ClanInfo> data;

    public List<ClanInfo> getData() {
        return data;
    }

    public void setData(List<ClanInfo> data) {
        this.data = data;
    }
}
