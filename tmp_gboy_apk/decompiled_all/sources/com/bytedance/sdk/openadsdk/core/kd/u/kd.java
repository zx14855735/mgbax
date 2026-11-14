package com.bytedance.sdk.openadsdk.core.kd.u;

import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.kd.u.y;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd {
    private final y d;
    private static final kd xj = new kd(7);
    private static final kd hf = new kd(8);
    private static final kd w = new kd(3);
    private static final kd u = new kd(1);
    private static final kd kd = new kd(5);
    private static final kd y = new kd(9);
    private static final kd c = new kd(6);
    private static final kd f = new kd(0);

    static {
        olzU();
    }

    private kd(int i) {
        this.d = new y(i);
    }

    private static /* synthetic */ void olzU() {
        char[] charArray = "\u0011\u001d\u001f\\\u0015\u0013\u001f\u0017\\\u0010\u001d\u000b\\\u0001\u001a\u0017\u001e\u001e\\8\u001c\u001b0\u0000\u001b\u0016\u0015\u0017".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'r');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0011\u001e\u001b\u001c\u001b\u0006".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'r');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static kd xj(int i) {
        if (i == 1) {
            return u;
        }
        if (i == 3) {
            return w;
        }
        switch (i) {
            case 5:
                return kd;
            case 6:
                return c;
            case 7:
                return xj;
            case 8:
                return hf;
            case 9:
                return y;
            default:
                return f;
        }
    }

    public void hf(String str) {
        this.d.hf(str);
    }

    public void w(String str) {
        this.d.w(str);
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar, ws wsVar, boolean z) {
        if (hfVar == null || wsVar == null) {
            return;
        }
        if ((wsVar.m7if() != null ? wsVar.m7if().optInt("save_type") : 0) == 1) {
            return;
        }
        String u2 = hfVar.u();
        String hf2 = com.bytedance.sdk.component.utils.xj.hf(wsVar.ac().toString());
        long currentTimeMillis = ((((System.currentTimeMillis() / 1000) / 60) / 60) / 3) + wo.qt(wsVar);
        long o = wsVar.o();
        if (wsVar.hx() > 0) {
            o = Math.min(o, wsVar.hx());
        }
        this.d.xj(u2, new y.hf(hf2, wsVar.nu(), o * 1000, wsVar.qa()), z, currentTimeMillis);
    }

    public ws xj(String str, boolean z, long j) {
        System.currentTimeMillis();
        y.hf xj2 = this.d.xj(str, z, j);
        if (xj2 == null) {
            System.currentTimeMillis();
            return null;
        }
        System.currentTimeMillis();
        try {
            ws xj3 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(com.bytedance.sdk.component.utils.xj.w(xj2.w)));
            xj3.f(true);
            xj3.r(101);
            xj3.c(xj2.xj);
            xj3.et(xj2.kd);
            xj3.rz().hf(2);
            return xj3;
        } catch (Exception unused) {
            return null;
        }
    }

    public List<ws> xj(String str, boolean z, long j, int i) {
        System.currentTimeMillis();
        List<y.hf> xj2 = this.d.xj(str, z, j, i);
        if (xj2 != null && !xj2.isEmpty()) {
            System.currentTimeMillis();
            ArrayList arrayList = new ArrayList();
            for (y.hf hfVar : xj2) {
                try {
                    ws xj3 = com.bytedance.sdk.openadsdk.core.xj.xj(new JSONObject(com.bytedance.sdk.component.utils.xj.w(hfVar.w)));
                    xj3.f(true);
                    xj3.r(101);
                    xj3.c(hfVar.xj);
                    xj3.et(hfVar.kd);
                    xj3.rz().hf(2);
                    arrayList.add(xj3);
                } catch (Exception unused) {
                }
            }
            return arrayList;
        }
        System.currentTimeMillis();
        return Collections.EMPTY_LIST;
    }

    public void xj(String str) {
        this.d.xj(str);
    }

    public void xj(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.d.xj(str, str2);
    }

    public void xj(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        this.d.xj(str, str2, z);
    }

    public void xj() {
        this.d.xj();
    }

    public static boolean xj(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        return (wsVar.m7if() != null ? wsVar.m7if().optInt("save_type") : 0) != 1;
    }
}
