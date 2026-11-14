package com.bytedance.sdk.component.w.hf.xj.w;

import com.bytedance.sdk.component.w.hf.io;
import com.bytedance.sdk.component.w.hf.v;
import java.net.Proxy;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class d {
    private static boolean hf(io ioVar, Proxy.Type type) {
        return !ioVar.f() && type == Proxy.Type.HTTP;
    }

    public static String xj(io ioVar, Proxy.Type type) {
        StringBuilder sb = new StringBuilder();
        sb.append(ioVar.hf());
        sb.append(' ');
        if (hf(ioVar, type)) {
            sb.append(ioVar.xj());
        } else {
            sb.append(xj(ioVar.xj()));
        }
        sb.append(" HTTP/1.1");
        return sb.toString();
    }

    public static String xj(v vVar) {
        String d = vVar.d();
        try {
            String p = vVar.p();
            if (p != null) {
                return d + '?' + p;
            }
        } catch (OutOfMemoryError unused) {
        }
        return d;
    }
}
