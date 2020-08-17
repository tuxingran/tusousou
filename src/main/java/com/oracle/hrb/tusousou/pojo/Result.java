package com.oracle.hrb.tusousou.pojo;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Result implements Serializable {

    private boolean ok;
    private String msg;
    private Map<String, Object> map;
    private String name;

    public boolean getOk() {

        return ok;
    }

    public void setOk(boolean ok) {
        this.ok = ok;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void addMap(String key, Object value) {
        map.put(key, value);

    }

    public Result() {
        map = new HashMap<>();

        ok = true;

    }


}
