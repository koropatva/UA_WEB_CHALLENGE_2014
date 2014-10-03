package com.uawebchallenge.balancer.interfaces;

import com.uawebchallenge.balancer.models.BalanceResult;
import com.uawebchallenge.balancer.models.CommingData;

public interface IBalancerService {

    BalanceResult calculateResult(CommingData commingData);
}
