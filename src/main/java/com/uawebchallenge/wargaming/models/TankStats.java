package com.uawebchallenge.wargaming.models;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

public class TankStats implements Serializable{

    private static final long serialVersionUID = 1L;

    @JsonProperty("tank_id")
    private Integer tankId;

    @JsonProperty("account_id")
    private Integer accountId;

    @JsonProperty("mark_of_mastery")
    private Integer markOfMastery;

    public Integer getTankId() {
        return tankId;
    }

    public void setTankId(Integer tankId) {
        this.tankId = tankId;
    }

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public Integer getMarkOfMastery() {
        return markOfMastery;
    }

    public void setMarkOfMastery(Integer markOfMastery) {
        this.markOfMastery = markOfMastery;
    }

}
