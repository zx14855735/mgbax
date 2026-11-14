package com.bytedance.sdk.component.f.hf.xj.xj.hf;

import ADYaiT.CtFAbx;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj extends c {
    public xj(Context context, com.bytedance.sdk.component.f.hf.u.hf.xj xjVar, com.bytedance.sdk.component.f.xj.kd kdVar) {
        super(context, xjVar, kdVar);
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.c
    public byte hf() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.c
    public byte w() {
        return (byte) 3;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.c, com.bytedance.sdk.component.f.hf.xj.xj.hf.hf
    public String xj() {
        return ((c) this).hf.hf().kd();
    }

    public static String hf(String str) {
        return CtFAbx.BI9f7h("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }

    public static String w(String str) {
        return CtFAbx.BI9f7h("ALTER TABLE ", str, " ADD COLUMN encrypt INTEGER default 0");
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.c, com.bytedance.sdk.component.f.hf.xj.xj
    public boolean xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return com.bytedance.sdk.component.f.hf.w.xj.kd(hfVar);
    }
}
