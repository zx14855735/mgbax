package com.bytedance.pangle.u;

import com.bytedance.sdk.openadsdk.api.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    public static String c = "7z_unzip_finish";
    public static String d = "load_finish";
    public static String f = "load_start";
    public static String hf = "download_start";
    public static String kd = "install_finish";
    private static volatile hf p = null;
    public static String tf = "rm_entry_finish";
    public static String u = "install_start";
    public static String w = "download_finish";
    public static String xj = "request_finish";
    public static String y = "7z_unzip_start";

    /* renamed from: pl, reason: collision with root package name */
    private final List<com.bytedance.pangle.u.xj> f10173pl = new ArrayList();

    public static class xj {
        public static int ai = 32008;
        public static int am = 22000;
        public static int c = 12002;
        public static int d = 12004;
        public static int dk = 32004;
        public static int e = 22999;
        public static int en = 42000;
        public static int et = 32005;
        public static int f = 12003;
        public static int ff = 50004;
        public static int g = 21002;
        public static int hf = 2;
        public static int ht = 32002;

        /* renamed from: io, reason: collision with root package name */
        public static int f10174io = 32006;
        public static int j = 41000;
        public static int jk = 32000;
        public static int kd = 12000;
        public static int l = 50000;
        public static int p = 21000;

        /* renamed from: pl, reason: collision with root package name */
        public static int f10175pl = 21001;
        public static int pz = 32001;
        public static int q = 32999;
        public static int qt = 22001;
        public static int ra = 32003;
        public static int tf = 20000;
        public static int u = -2;
        public static int v = 31000;
        public static int w = -1;
        public static int x = 32007;
        public static int xj = 1;
        public static int y = 12001;
        public static int yo = 30000;
        public static int z = 40000;
        public static int zg = 22002;
    }

    private hf() {
    }

    public static hf xj() {
        if (p == null) {
            synchronized (hf.class) {
                p = new hf();
            }
        }
        return p;
    }

    public void xj(com.bytedance.pangle.u.xj xjVar) {
        synchronized (this.f10173pl) {
            this.f10173pl.add(xjVar);
        }
    }

    public void xj(String str, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3) {
        synchronized (this.f10173pl) {
            try {
                Iterator<com.bytedance.pangle.u.xj> it = this.f10173pl.iterator();
                while (it.hasNext()) {
                    try {
                        it.next().xj(str, jSONObject, jSONObject2, jSONObject3);
                    } catch (Throwable th) {
                        y.xj(th);
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }
}
