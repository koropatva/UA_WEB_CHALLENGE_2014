package com.uawebchallenge.wargaming.models.response;

import java.util.Map;

import com.uawebchallenge.wargaming.models.MembersClanInfo;

public class MembersClanInfoResponse extends BaseResponse{
    
    private static final long serialVersionUID = 1L;
    
    private Map<Integer, MembersClanInfo> data;

    public Map<Integer, MembersClanInfo> getData() {
        return data;
    }

    public void setData(Map<Integer, MembersClanInfo> data) {
        this.data = data;
    }

}
