package com.oracle.hrb.tusousou.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class GetDate {
    public static  String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(System.currentTimeMillis());
        String a = formatter.format(date);
        return a;


    }

}
