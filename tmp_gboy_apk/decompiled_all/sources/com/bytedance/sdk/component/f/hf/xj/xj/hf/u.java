package com.bytedance.sdk.component.f.hf.xj.xj.hf;

import ADYaiT.CtFAbx;
import android.content.Context;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class u extends y {
    public u(Context context, com.bytedance.sdk.component.f.hf.u.hf.xj xjVar, com.bytedance.sdk.component.f.xj.kd kdVar) {
        super(context, xjVar, kdVar);
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.y
    public byte hf() {
        return (byte) 1;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.y
    public byte w() {
        return (byte) 0;
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.y, com.bytedance.sdk.component.f.hf.xj.xj.hf.hf
    public String xj() {
        com.bytedance.sdk.component.f.xj.y hf = ((y) this).hf.hf();
        if (hf != null) {
            return hf.xj();
        }
        return null;
    }

    public static String hf(String str) {
        return CtFAbx.BI9f7h("CREATE TABLE IF NOT EXISTS ", str, " (_id INTEGER PRIMARY KEY AUTOINCREMENT,id TEXT UNIQUE,value TEXT ,gen_time TEXT , retry INTEGER default 0 , encrypt INTEGER default 0)");
    }

    public static String w(String str) {
        return CtFAbx.BI9f7h("ALTER TABLE ", str, " ADD COLUMN encrypt INTEGER default 0");
    }

    @Override // com.bytedance.sdk.component.f.hf.xj.xj.hf.y, com.bytedance.sdk.component.f.hf.xj.xj
    public boolean xj(com.bytedance.sdk.component.f.xj.hf hfVar) {
        return com.bytedance.sdk.component.f.hf.w.xj.xj(hfVar);
    }
}
