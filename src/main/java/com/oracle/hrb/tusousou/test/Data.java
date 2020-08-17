package com.oracle.hrb.tusousou.test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Data {

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String a = formatter.format(date);


    }

}



