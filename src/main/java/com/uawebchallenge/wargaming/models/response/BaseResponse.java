package com.uawebchallenge.wargaming.models.response;

import java.io.Serializable;

public class BaseResponse implements Serializable{

    private static final long serialVersionUID = 1L;

    private String error;
    
    private String status;

    private Integer count;

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}
