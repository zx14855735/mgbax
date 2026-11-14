package com.bytedance.sdk.component.p.c;

import com.bytedance.sdk.component.p.u.u;
import com.bytedance.sdk.component.p.xj.hf;
import com.bytedance.sdk.component.p.xj.xj.w;
import java.util.HashMap;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static volatile xj hf;
    private Map<String, com.bytedance.sdk.component.p.xj.xj.xj> xj = new HashMap();

    private xj() {
    }

    public static xj xj() {
        if (hf != null) {
            return hf;
        }
        synchronized (xj.class) {
            try {
                if (hf != null) {
                    return hf;
                }
                xj xjVar = new xj();
                hf = xjVar;
                return xjVar;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void xj(String str, com.bytedance.sdk.component.p.xj.xj.xj xjVar) {
        this.xj.put(str, xjVar);
    }

    public void xj(String str, com.bytedance.sdk.component.p.xj.xj xjVar, com.bytedance.sdk.component.p.u.xj xjVar2) {
        com.bytedance.sdk.component.p.xj.xj.xj xjVar3 = this.xj.get(str);
        if (xjVar3 == null || xjVar == null) {
            return;
        }
        Map<String, Object> xj = xjVar.xj();
        u kd = xjVar.kd();
        if (kd instanceof hf) {
            Map<String, Object> xj2 = com.bytedance.sdk.component.p.kd.xj.xj().xj(String.valueOf(kd.hashCode()));
            xj.putAll(xj2);
            xj2.clear();
            com.bytedance.sdk.component.p.y.xj xj3 = com.bytedance.sdk.component.p.y.xj.xj();
            xjVar3 = xj3.xj(xjVar3);
            HashMap hashMap = new HashMap();
            hashMap.putAll(xjVar.hf());
            hashMap.putAll(xj);
            xj3.xj(xjVar3, hashMap);
        }
        if (xjVar3 instanceof w) {
            ((w) xjVar3).xj(xjVar.hf(), xjVar.xj(), xjVar);
        } else if (xjVar3 instanceof com.bytedance.sdk.component.p.xj.xj.hf) {
            ((com.bytedance.sdk.component.p.xj.xj.hf) xjVar3).xj(xjVar.hf(), xjVar.xj(), xjVar);
        }
    }
}
