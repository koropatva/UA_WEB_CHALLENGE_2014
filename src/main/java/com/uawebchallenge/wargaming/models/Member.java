package com.uawebchallenge.wargaming.models;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Member implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonProperty("account_id")
    private Integer accountId;

    @JsonProperty("account_name")
    private String accountName;

    public Integer getAccountId() {
        return accountId;
    }

    public void setAccountId(Integer accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((accountId == null) ? 0 : accountId.hashCode());
        result = prime * result + ((accountName == null) ? 0 : accountName.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Member other = (Member) obj;
        if (accountId == null) {
            if (other.accountId != null) return false;
        } else if (!accountId.equals(other.accountId)) return false;
        if (accountName == null) {
            if (other.accountName != null) return false;
        } else if (!accountName.equals(other.accountName)) return false;
        return true;
    }
}
