package com.cf.context;

import com.alibaba.dubbo.common.json.JSON;
import com.alibaba.dubbo.rpc.RpcContext;

import java.lang.reflect.Method;

public class DubboContext {
    private static final String DUBBO_PARAM = "dubbo_param";
    public static String get() {

        String context = RpcContext.getContext().getAttachment(DUBBO_PARAM);


        return context;
    }

    public static void set(String param) {

        RpcContext.getContext().setAttachment(DUBBO_PARAM, param);
    }
}
