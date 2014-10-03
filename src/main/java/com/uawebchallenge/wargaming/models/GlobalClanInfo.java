package com.uawebchallenge.wargaming.models;

import org.codehaus.jackson.annotate.JsonProperty;


public class GlobalClanInfo extends ClanInfo {
    
    private static final long serialVersionUID = 1L;

    @JsonProperty("wins_count")
    private Integer winsCount;
    
    @JsonProperty("provinces_count")
    private Integer provincesCount;
    
    @JsonProperty("combats_count")
    private Integer combatsCount;

    public Integer getWinsCount() {
        return winsCount;
    }

    public void setWinsCount(Integer winsCount) {
        this.winsCount = winsCount;
    }

    public Integer getProvincesCount() {
        return provincesCount;
    }

    public void setProvincesCount(Integer provincesCount) {
        this.provincesCount = provincesCount;
    }

    public Integer getCombatsCount() {
        return combatsCount;
    }

    public void setCombatsCount(Integer combatsCount) {
        this.combatsCount = combatsCount;
    }
}
