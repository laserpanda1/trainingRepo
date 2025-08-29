package com.laserpanda1;

import org.springframework.stereotype.Service;

@Service
public class AppService {

    private AppProperties appProperties;

    public AppService(AppProperties appProperties) {
        this.appProperties = appProperties;
    }

    public AppProperties getAppProperties() {
        return this.appProperties;
    }

}
