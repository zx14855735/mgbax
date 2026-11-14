package com.bytedance.msdk.kd;

import android.content.Context;
import com.baidu.mobads.sdk.internal.bn;
import com.bytedance.msdk.f.io;
import com.bytedance.msdk.kd.hf;
import com.bytedance.sdk.component.f.xj.xj;
import com.bytedance.sdk.component.utils.pl;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static final AtomicLong hf = new AtomicLong(0);
    private static volatile boolean xj;

    static {
        JVchjk();
    }

    private static /* synthetic */ void JVchjk() {
        char[] charArray = "MAC\u0000IOCK\u0000LAW\u0000]FKBB\u0000d@Gl\\GJIK".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '.');
        }
        String str = new String(charArray);
        char[] charArray2 = "MBG@GZ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '.');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean hf() {
        return xj;
    }

    public static void w() {
        com.bytedance.sdk.component.f.hf.xj.u("csj_mediation");
    }

    public static void xj() {
        xj = true;
    }

    public static void hf(Context context) {
        try {
            List<hf.xj> hf2 = hf.xj().hf();
            if (hf2 != null) {
                for (hf.xj xjVar : hf2) {
                    if (xjVar != null) {
                        xj(context, xjVar.xj(), xjVar.hf());
                    }
                }
            }
            hf.xj().w();
        } catch (Throwable th) {
            pl.xj(th);
        }
    }

    public static void xj(Context context) {
        int io2 = com.bytedance.msdk.core.hf.hf().io();
        com.bytedance.sdk.component.f.hf.xj.xj(new xj.C0111xj().xj(new d()).hf(com.bytedance.sdk.component.f.hf.u.hf.xj.xj(io2, io2, bn.e)).hf(com.bytedance.msdk.core.xj.p().g()).xj(new tf()).xj(p.xj).xj("csj_mediation").xj(context).xj());
        com.bytedance.sdk.component.f.hf.xj.hf("csj_mediation");
    }

    public static void xj(Context context, u uVar, Map<String, Object> map) {
        if (com.bytedance.msdk.core.hf.hf().am()) {
            Context context2 = context == null ? com.bytedance.msdk.core.hf.getContext() : context;
            JSONObject jSONObject = new JSONObject();
            if (map != null) {
                try {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        jSONObject.put(entry.getKey(), entry.getValue());
                    }
                } catch (JSONException unused) {
                }
            }
            jSONObject.put("eventIndex", hf.getAndIncrement());
            jSONObject.put("is_main_process", io.xj(context));
            jSONObject.put("is_cypher_v4", com.bytedance.msdk.core.hf.xj().xj());
            if (com.bytedance.msdk.core.xj.p().d()) {
                jSONObject.put("e2e_test_flag", "1");
            }
            if (uVar != null) {
                uVar.xj("event_id", UUID.randomUUID().toString());
            }
            JSONObject xj2 = xj.xj(uVar, jSONObject);
            if (!xj) {
                hf.xj().xj(uVar, xj2);
            } else {
                xj(context2, uVar, xj2);
            }
        }
    }

    private static void xj(Context context, u uVar, JSONObject jSONObject) {
        if (com.bytedance.sdk.component.f.hf.xj.xj("csj_mediation")) {
            xj(context);
        }
        c xj2 = c.xj(context, uVar, jSONObject);
        com.bytedance.msdk.f.u.hf.xj(xj2, true);
        com.bytedance.sdk.component.f.hf.u.xj.xj xjVar = new com.bytedance.sdk.component.f.hf.u.xj.xj(xj2.xj, xj2);
        xjVar.xj((byte) 3);
        xjVar.hf((byte) 2);
        com.bytedance.sdk.component.f.hf.xj.xj(xjVar, "csj_mediation");
    }
}
