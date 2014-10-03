package com.uawebchallenge.wargaming.models;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TankInfo extends Tank{

    private static final long serialVersionUID = 1L;

    @JsonProperty("gun_damage_min")
    private Integer gunDamageMin;

    @JsonProperty("gun_damage_max")
    private Integer gunDamageMax;

    @JsonProperty("max_health")
    private Integer maxHealth;

    public Integer getGunDamageMin() {
        return gunDamageMin;
    }

    public void setGunDamageMin(Integer gunDamageMin) {
        this.gunDamageMin = gunDamageMin;
    }

    public Integer getGunDamageMax() {
        return gunDamageMax;
    }

    public void setGunDamageMax(Integer gunDamageMax) {
        this.gunDamageMax = gunDamageMax;
    }

    public Integer getMaxHealth() {
        return maxHealth;
    }

    public void setMaxHealth(Integer maxHealth) {
        this.maxHealth = maxHealth;
    }
}
