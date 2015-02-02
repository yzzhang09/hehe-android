package org.cl.hehe.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import android.test.InstrumentationTestCase;
import android.util.Log;

/**
 * @author yongzhi.zhang
 * @version $Id: GsonTest.java, v 0.1 2015-1-23 下午3:29:22 yongzhi.zhang Exp $
 */
public class GsonTest extends InstrumentationTestCase {

    static {
        System.loadLibrary("Egret");
    }

    @Override
    protected void setUp() throws Exception {

    }

    public void testExec() throws IOException {

        Process p = Runtime.getRuntime().exec("/system/bin/sh echo hello");
        BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String out = "";
        String line;
        while ((line = input.readLine()) != null) {
            out = out.concat(line + "\r\n");
        }
        Log.i("GsonTestLog", out);
    }

    /**
     * 单元测试
     */
    public void testFromJson() {
        Model m = new Model();
        m.setName("a");
        Gson gson = new Gson();
        Log.i("GsonTestLog", gson.toJson(m));
        Log.i("GsonTestLog", gson.fromJson(gson.toJson(m), Model.class).toString());
    }
}
