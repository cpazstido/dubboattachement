package com.cf.service.dubbo;

import com.cf.annotations.MyAnnotation;
import com.cf.service.ProviderService;
import org.springframework.stereotype.Service;

@Service("providerService")
public class ProviderServiceImpl implements ProviderService {
    @Override
    public String sayHello(String name) {
        return "Hello,"+name;
    }
}
