package com.uawebchallenge.wargaming.models;

import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MembersClanInfo extends ClanInfo {

    private static final long serialVersionUID = 1L;
    
    private Map<Integer, Member> members;

    public Map<Integer, Member> getMembers() {
        return members;
    }

    public void setMembers(Map<Integer, Member> members) {
        this.members = members;
    }

}
