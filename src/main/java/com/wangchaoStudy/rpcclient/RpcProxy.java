package com.wangchaoStudy.rpcclient;

import java.lang.reflect.Proxy;

/**
 * 2019/12/24
 * by Wang Chao
 */
public class RpcProxy {
    public <T> T clientProxy(final Class<T> interfaceclass, int port, String localhost){
        return (T) Proxy.newProxyInstance(interfaceclass.getClassLoader(),new Class<?>[]{interfaceclass},new ProcessHandler(port,localhost,interfaceclass));
    }
}
