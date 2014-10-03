package com.uawebchallenge.balancer.models;

import com.uawebchallenge.wargaming.models.Member;
import com.uawebchallenge.wargaming.models.TankInfo;

public class Player {

    private Member member;

    private TankInfo tankInfo;

    private Integer mastery;

    public Integer calculateBalance() {
        return (int) ((tankInfo.getMaxHealth() * 0.4 + tankInfo.getGunDamageMax() * 0.4 + tankInfo
                .getGunDamageMin() * 0.2) * (1.0 + mastery / 10));
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Integer getMastery() {
        return mastery;
    }

    public void setMastery(Integer mastery) {
        this.mastery = mastery;
    }

    public TankInfo getTankInfo() {
        return tankInfo;
    }

    public void setTankInfo(TankInfo tankInfo) {
        this.tankInfo = tankInfo;
    }
}
