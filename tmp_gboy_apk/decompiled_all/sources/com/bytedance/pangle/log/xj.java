package com.bytedance.pangle.log;

import J3FDQU.A2egSU;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private String hf;
    private long kd;
    private long u;
    private String w;
    private String xj;

    private xj(String str, String str2, String str3) {
        this.xj = str;
        this.hf = str2;
        this.w = str3;
        long currentTimeMillis = System.currentTimeMillis();
        this.kd = currentTimeMillis;
        this.u = currentTimeMillis;
        String str4 = this.xj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.hf);
        sb.append(" watcher[" + str3 + "]-start");
        ZeusLogger.i(str4, sb.toString());
    }

    public static xj xj(String str, String str2, String str3) {
        return new xj(str, str2, str3);
    }

    public long xj(String str) {
        long currentTimeMillis = System.currentTimeMillis() - this.kd;
        long currentTimeMillis2 = System.currentTimeMillis() - this.u;
        String str2 = this.xj;
        StringBuilder sb = new StringBuilder();
        sb.append(this.hf);
        StringBuilder BChYOn2 = A2egSU.BChYOn(" watcher[", this.w, "]-", str, " cost=");
        BChYOn2.append(currentTimeMillis);
        BChYOn2.append(", total=");
        BChYOn2.append(currentTimeMillis2);
        sb.append(BChYOn2.toString());
        ZeusLogger.i(str2, sb.toString());
        return currentTimeMillis2;
    }

    public long xj() {
        return System.currentTimeMillis() - this.u;
    }
}
