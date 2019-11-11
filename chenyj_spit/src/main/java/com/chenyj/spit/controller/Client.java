package com.chenyj.spit.controller;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * @desc:
 * @author: chenyj
 * @date: 2019/10/31
 */
public class Client {
    /*
     * 套接字
     *
     * 理解为电话，拨号，建立联系，麦克风说话，
     * socket输入和输出流，
     * 你输入流对应他输出流，你说话他听
     * 你输出流对应他输入流
     *
     * java,net.Socket;
     * 封装了TCP协议，使用它就可以基于某种TCP协议进行网络通信
     * Socket试运行在客户端的
     */
    private Socket socket;

    public Client() throws Exception {
        /*
         *实例化Socket的时候需要传入两个参数
         * 1 IP：127.0.0.1或localhost本机；
         * 2 端口：0-65535，听服务端的，区用网程序，
         *    一般使用四千以上一万以下，前四千被占用绑定主流应用程序等
         * 通过Ip可以找到服务的那台计算机，通过端口号可以找到服务端计算机上服务端用程序
         *
         * 实例化Socket的过程就是连接的过程，若远端计算机没有响应会抛出异常
         *
         */
        System.out.println("正在连接服务端...");
        socket = new Socket();
        System.out.println("已经和服务端建立联系");
    }

    /*
     * 启动客户端的方法
     */
    public void start() {
        try {
            Scanner scanner = new Scanner(System.in);
            /*
             * 先要求用户创建一个昵称
             */
            //System.out.println("");
            String nickName = null;
            while(true) {
                System.out.println("请用户输入用户名");
                nickName = scanner.nextLine();
                if(nickName.length()>0) {
                    break;
                }
                System.out.println("输入有误");
            }
            System.out.println("欢迎你"+nickName+"!开始聊天吧！");
            /*socket 提供的方法：
             * OutputStream getOutStream
             * 获取一个字节输出流，通过该流写出的数据会被发送至远端计算机。
             */
            OutputStream out = socket.getOutputStream();
            OutputStreamWriter osw = new OutputStreamWriter(out,"UTF-8");
            PrintWriter pw =  new  PrintWriter(osw,true);  //不能指明字节流,所以要加一个转换流，第二参数为true会行刷新

            //先将昵称发给服务器

            pw.println(nickName);

            /*
             * 启动读取服务端发送过来消息的线程
             */
            ServerHandler  handler = new ServerHandler();
            Thread t = new Thread(handler);
            t.start();

            /*
             * 将字符串发送至服务端，加上行刷新，说一句发一句
             * 否则需要用  flush()强制写出
             */
            while(true) {
                pw.println(scanner.nextLine());
                //pw.flush();

            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args) {
        try {
            Client client = new Client();
            client.start();
        }catch(Exception e) {
            e.printStackTrace();
            System.out.println("客户端启动失败！");
        }
    }

    /*
     * 该线程用来读取服务器端发送来的消息，并输出到客户端控制台显示
     */
    class ServerHandler implements Runnable {
        @Override
        public void run() {
            try {
                InputStream in = socket.getInputStream();
                InputStreamReader isr = new InputStreamReader(in,"UTF-8");
                BufferedReader br = new BufferedReader(isr);

                String message = null;
                while ((message = br.readLine())!=null) {
                    System.out.println(message);
                }

            } catch (Exception e) {


            }
        }
    }


}