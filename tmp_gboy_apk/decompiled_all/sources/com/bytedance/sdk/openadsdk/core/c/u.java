package com.bytedance.sdk.openadsdk.core.c;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.tools.LogAdapter;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    private static u kd = new u();
    private int hf;
    private volatile com.bytedance.sdk.component.xj u;
    private int w;
    private ws xj;

    static {
        qqqs();
    }

    private boolean hf() {
        this.u = LogAdapter.xj;
        return this.u != null;
    }

    private static /* synthetic */ void qqqs() {
        char[] charArray = "846u<:6>u94\"u(3>77u\u001152\u0019)2?<>".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '[');
        }
        String str = new String(charArray);
        char[] charArray2 = "87252/".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '[');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private String w() {
        ws wsVar = this.xj;
        return wsVar != null ? com.bytedance.sdk.component.utils.xj.xj(wsVar.ac()).toString() : "";
    }

    public static u xj() {
        return kd;
    }

    public u xj(ws wsVar) {
        if (hf()) {
            this.xj = wsVar;
        }
        return this;
    }

    public u hf(int i) {
        if (hf()) {
            this.w = i;
        }
        return this;
    }

    public u xj(int i) {
        if (hf()) {
            this.hf = i;
        }
        return this;
    }

    public void xj(Thread thread, Throwable th) {
        String str;
        if (hf()) {
            if (thread != null) {
                str = thread.getName() + "-" + thread.getId();
            } else {
                str = "";
            }
            this.u.xj(str, "-------fatal----------");
            this.u.xj(str, "last show rit:" + this.w);
            this.u.xj(str, "last show adtype:" + this.hf);
            this.u.xj(str, w());
            this.u.xj(str, th);
            this.u.xj(str, "-------finish----------");
            LogAdapter.xj.xj().xj();
        }
    }
}
