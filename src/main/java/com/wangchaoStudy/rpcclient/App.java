package com.wangchaoStudy.rpcclient;

import com.wangchao.studyDemo.IHelloService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ){
        IHelloService helloService = new RpcProxy().clientProxy(IHelloService.class,8080,"localhost");
        System.out.println("client ready to say hello");
        String message = helloService.sayHello("wangchao");
        System.out.println(message);
    }
}
