package com.wangchaoStudy.rpcclient;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * 2019/12/24
 * by Wang Chao
 */
public class RpcNetTransprot {
    private int port;
    private String url;

    public RpcNetTransprot(int port, String url) {
        this.port = port;
        this.url = url;
    }

    public Object dualSocket(Object object) throws IOException {
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            Socket socket = new Socket(url,port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(object);
            outputStream.flush();
            inputStream = new ObjectInputStream(socket.getInputStream());
            Object obj = inputStream.readObject();
            return obj;
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(outputStream != null){
                outputStream.close();
            }
            if(inputStream != null){
                inputStream.close();
            }
        }
        return null;
    }
}
