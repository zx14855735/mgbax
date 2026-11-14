package com.ss.android.downloadlib.kd;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobads.sdk.internal.br;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.socialbase.appdownloader.y.y;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w implements com.ss.android.download.api.hf.xj {

    public static class xj {
        private static w xj = new w();

        static {
            cQiioX();
        }

        private static /* synthetic */ void cQiioX() {
            char[] charArray = "×ÛÙ\u009aÓÕÙÑ\u009aÖÛÍ\u009aÇÜÑØØ\u009aþÚÝöÆÝÐÓÑ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 180);
            }
            String str = new String(charArray);
            char[] charArray2 = "×ØÝÚÝÀ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 180);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static w xj() {
        return xj.xj;
    }

    public void hf(String str) {
        hf(true, str);
    }

    public void hf(boolean z, String str) {
        if (hf()) {
            return;
        }
        if (z) {
            hf(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        g.xj(jSONObject, br.c, str);
        g.xj(jSONObject, "stack", xj(new Throwable()));
        pl.f();
    }

    @Override // com.ss.android.download.api.hf.xj
    public void xj(Throwable th, String str) {
        xj(true, th, str);
    }

    public void xj(boolean z, Throwable th, String str) {
        if (hf()) {
            return;
        }
        if (th == null) {
            th = new Throwable();
        }
        if (z) {
            hf(th);
        }
        JSONObject jSONObject = new JSONObject();
        if (TextUtils.isEmpty(str)) {
            str = th.getMessage();
        }
        g.xj(jSONObject, br.c, str);
        g.xj(jSONObject, "stack", Log.getStackTraceString(th));
        pl.f();
    }

    private void hf(Throwable th) {
        if (y.hf(pl.getContext())) {
            throw new com.ss.android.downloadlib.kd.xj(th);
        }
    }

    private boolean hf() {
        return pl.d().optInt("enable_monitor", 1) != 1;
    }

    public void xj(String str) {
        xj(true, str);
    }

    public void xj(boolean z, String str) {
        if (hf()) {
            return;
        }
        if (z) {
            hf(new RuntimeException(str));
        }
        JSONObject jSONObject = new JSONObject();
        g.xj(jSONObject, br.c, str);
        g.xj(jSONObject, "stack", xj(new Throwable()));
        pl.f();
    }

    public static String xj(Throwable th) {
        try {
            return Log.getStackTraceString(th);
        } catch (Exception unused) {
            return null;
        }
    }
}
