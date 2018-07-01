package com.cf.service.impl;

import com.cf.annotations.MyAnnotation;
import com.cf.service.ConsumerService;
import com.cf.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConsumerServiceImpl implements ConsumerService {
    @Autowired
    private ProviderService providerService;

    @Override
    @MyAnnotation
    public String getDubboStr(String name) {
        return providerService.sayHello(name);
    }
}
