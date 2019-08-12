package javaSE;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by futuration on 2019/8/12.
 */
public class netDemo {
    public static void main(String[] args) {
        String serveName = "localhost";
        int port = 8000;
        try {

            System.out.println("连接的服务器名称：" + serveName + ", 端口： " + port);
            Socket client = new Socket(serveName,port);
            System.out.println("连接的服务器的地址为：" + client.getRemoteSocketAddress());
            OutputStream outputStream = client.getOutputStream();
            DataOutputStream out = new DataOutputStream(outputStream);
            out.writeUTF("hello from " + client.getLocalAddress());
            InputStream inputStream = client.getInputStream();
            DataInputStream in = new DataInputStream(inputStream);
            System.out.println("服务器响应： " + in.readUTF());
            client.close();

        }catch (Exception e){
            e.printStackTrace();
        }

    }


}

class serveClient extends Thread{
    private ServerSocket serverSocket;
    public serveClient(int port) throws IOException {
            serverSocket = new ServerSocket(port);
            serverSocket.setSoTimeout(100000);
    }

    @Override
    public void run() {
        super.run();

        while (true) try {
            System.out.println("等待远程连接，端口号为：" + serverSocket.getLocalPort());
            Socket serve = serverSocket.accept();
            System.out.println("远程主机号为：" + serve.getRemoteSocketAddress());
            DataInputStream in = new DataInputStream(serve.getInputStream());
            System.out.println(in.readUTF());
            DataOutputStream out = new DataOutputStream(serve.getOutputStream());
            out.writeUTF("谢谢你连接我：" + serve.getLocalSocketAddress()+"\n Goodybye!");
            serve.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        int port = 8000;
        try {
            Thread t = new serveClient(port);
            t.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
