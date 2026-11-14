package com.bytedance.sdk.openadsdk.core.et;

import android.os.SystemClock;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.hf.xj.am;
import com.bytedance.sdk.component.hf.xj.d;
import com.bytedance.sdk.component.hf.xj.e;
import com.bytedance.sdk.component.hf.xj.zg;
import com.czhj.sdk.common.Constants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj {
    private static volatile String hf = "0";
    private static volatile long xj;

    /* renamed from: com.bytedance.sdk.openadsdk.core.et.xj$xj, reason: collision with other inner class name */
    public static class C0164xj implements d {
        @Override // com.bytedance.sdk.component.hf.xj.d
        public zg xj(d.xj xjVar) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            am xj = xjVar.xj();
            zg xj2 = xjVar.xj(xj);
            if (an.c.equalsIgnoreCase(xj.w())) {
                e y = xj2.y();
                if (y == null) {
                    return xj2;
                }
                long xj3 = y.xj();
                long elapsedRealtime2 = SystemClock.elapsedRealtime() - elapsedRealtime;
                if (elapsedRealtime2 > 0 && xj3 > 10240) {
                    String unused = xj.hf = String.format("%.2f", Double.valueOf(((xj3 / 1024.0d) / elapsedRealtime2) * 1000.0d));
                    long unused2 = xj.xj = System.currentTimeMillis();
                    String unused3 = xj.hf;
                }
            }
            return xj2;
        }
    }

    public static String xj() {
        if (System.currentTimeMillis() - xj < 7200000) {
            return hf;
        }
        return Constants.FAIL;
    }
}
