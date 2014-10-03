package com.uawebchallenge.wargaming.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
abstract class AbstractWargamingService<T> {

    protected static final String URL = "https://api.worldoftanks.ru/wot/";

    private static final String VERSION = "?application_id=demo";


    @Autowired
    public RestTemplate restTemplate;

    protected abstract String getSuffix();

    protected abstract String getSelectedFieldList();

    public AbstractWargamingService() {
        getSuffix();
    }

    protected T getObject(Class<T> requestClass, String appender) {
        return getObject(requestClass, appender, 0, 0);
    }

    protected T getObject(Class<T> requestClass, String appender, int limit, int pageOn) {
        StringBuilder query = new StringBuilder(URL);
        query.append(getSuffix());
        query.append(VERSION);
        query.append(appender);
        query.append(limit > 0 ? "&limit={limit}" : "");
        query.append(pageOn > 0 ? "&page_on={page_on}" : "");
        query.append(getSelectedFieldList() != null ? "&fields=" + getSelectedFieldList() : "");
        return restTemplate.getForObject(query.toString(), requestClass, limit, pageOn);
    }

}
