package com.bytedance.sdk.openadsdk.core.ugeno.express.xj;

import android.content.Context;
import android.text.TextUtils;
import com.bytedance.adsdk.ugeno.hf.w;
import com.bytedance.adsdk.ugeno.kd.y;
import com.bytedance.sdk.openadsdk.core.nativeexpress.tf;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ugeno.component.interact.c;
import com.bytedance.sdk.openadsdk.core.v.xj.v;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    public static final HashSet<String> xj = new HashSet<>(Arrays.asList("interactiveFinish", "nextVideoCancel", "haptic", "closeWidget", "dismiss"));

    static {
        xZQOcf();
    }

    private static /* synthetic */ void xZQOcf() {
        char[] charArray = "^RP\u0013Z\\PX\u0013_RD\u0013NUXQQ\u0013wST\u007fOTYZX".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '=');
        }
        String str = new String(charArray);
        char[] charArray2 = "^QTSTI".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '=');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(tf tfVar, hf hfVar, ws wsVar, Context context, String str, y.xj xjVar, c cVar, w wVar) {
        Map<String, String> w;
        int i = 0;
        if (xjVar == null) {
            return;
        }
        w = xjVar.w();
        str.getClass();
        switch (str) {
            case "nextVideoCancel":
                if (hfVar != null) {
                    hfVar.xj();
                    break;
                }
                break;
            case "haptic":
                if (w != null) {
                    String str2 = w.get("params");
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            com.bytedance.sdk.openadsdk.core.ugeno.component.interact.xj.w.xj(new JSONObject(str2), context, wsVar);
                            break;
                        } catch (JSONException unused) {
                            return;
                        }
                    }
                }
                break;
            case "closeWidget":
                if (cVar != null) {
                    cVar.kd();
                    break;
                }
                break;
            case "interactiveFinish":
                if (w != null) {
                    try {
                        i = v.xj(wsVar, Integer.parseInt(w.get("reduce_duration")));
                    } catch (NumberFormatException unused2) {
                    }
                }
                if (tfVar != null) {
                    tfVar.hf(i);
                    break;
                }
                break;
            case "dismiss":
                if (wVar != null) {
                    wVar.hf(8);
                    break;
                }
                break;
        }
    }
}
