package com.cf.controller;

import com.cf.service.ConsumerService;
import com.cf.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("")
public class IndexController {
    @Autowired
    private ConsumerService consumerService;

    @RequestMapping("index")
    @ResponseBody
    public String index(String name){
        return consumerService.getDubboStr(name);
    }
}
