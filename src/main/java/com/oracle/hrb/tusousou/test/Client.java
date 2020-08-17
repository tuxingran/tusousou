package com.oracle.hrb.tusousou.test;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try {
            Socket s = new Socket("127.0.0.1", 8000);
            new In(s).start();
            new Out(s).start();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

class In extends Thread {
    Socket s;

    public In(Socket s) {
        this.s = s;


    }

    @Override
    public void run() {
        try {
            DataInputStream in = new DataInputStream(s.getInputStream());
            while (true) {
                String str = in.readUTF();
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Out extends Thread {

    Socket s;

    public Out(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        Scanner S1 = new Scanner(System.in);
        while (true) {
            String str = S1.nextLine();
            try {
                DataOutputStream out = new DataOutputStream(s.getOutputStream());
                out.writeUTF(str);
                out.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
