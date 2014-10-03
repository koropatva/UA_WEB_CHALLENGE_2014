package com.uawebchallenge;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.uawebchallenge.balancer.interfaces.IBalancerService;
import com.uawebchallenge.balancer.interfaces.IPrintService;
import com.uawebchallenge.balancer.models.BalanceResult;
import com.uawebchallenge.balancer.models.CommingData;

public class Standalone {

    private static final String MAP_NAME_GLOBALMAP = "globalmap";
    private static final Integer TOP_CLAN_COUNTS = 10;
    private static final Integer[] TANK_LEVELS = {4,5,6};
    private static ApplicationContext ctx;

    public static void main(String[] args) {
        ctx = new ClassPathXmlApplicationContext("spring-context.xml");

        CommingData commingData = new CommingData(args, MAP_NAME_GLOBALMAP, TOP_CLAN_COUNTS, TANK_LEVELS);

        IBalancerService iBalancerService = ctx.getBean(IBalancerService.class);
        IPrintService iPrintService = ctx.getBean(IPrintService.class);
        BalanceResult balanceResult = iBalancerService.calculateResult(commingData);
        
        iPrintService.print(balanceResult);
    }

}
