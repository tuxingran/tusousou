package com.oracle.hrb.tusousou.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ThreadTest {


    public static void main(String[] args) {
        List<Socket> list = new ArrayList<>();
        Scanner S1 = new Scanner(System.in);
        try {
            ServerSocket ss = new ServerSocket(8000);
            System.out.println("服务端启动");
            while (true) {
                Socket s = ss.accept();
                System.out.println("有新用户链接");
                list.add(s);
                new Thread() {
                    @Override
                    public void run() {

                        try {
                            DataInputStream in = new DataInputStream(s.getInputStream());
                            while (true) {

                                String str = in.readUTF();
                                for (Socket so : list) {
                                    if (so != s) {
                                        DataOutputStream out = new DataOutputStream(so.getOutputStream());
                                        out.writeUTF(str);
                                        out.flush();

                                    }
                                }
                            }
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                }.start();


            }


        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
