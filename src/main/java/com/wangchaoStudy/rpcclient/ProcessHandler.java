package com.wangchaoStudy.rpcclient;

import com.wangchao.studyDemo.RpcRequest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 2019/12/24
 * by Wang Chao
 */
public class ProcessHandler implements InvocationHandler {
    private int port;
    private String url;
    private Class<?> interfaceclass;
    public ProcessHandler(int port, String url, Class<?> interfaceclass) {
        this.port = port;
        this.url = url;
        this.interfaceclass = interfaceclass;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setMethod(method.getName());
        rpcRequest.setArgs(args);
        rpcRequest.setClazz(interfaceclass.getName());
        RpcNetTransprot rpcNetTransprot = new RpcNetTransprot(port,url);
        Object obj = rpcNetTransprot.dualSocket(rpcRequest);

        return obj;
    }
}
