package com.bytedance.embedapplog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.SystemClock;
import java.lang.reflect.Method;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class zm {
    private static xv<db> xj = new xv<db>() { // from class: com.bytedance.embedapplog.zm.1
        @Override // com.bytedance.embedapplog.xv
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public db xj(Object... objArr) {
            return new db((Context) objArr[0]);
        }
    };

    static {
        AmDi();
    }

    private static /* synthetic */ void AmDi() {
        char[] charArray = "\u0098\u0094\u0096Õ\u009c\u009a\u0096\u009eÕ\u0099\u0094\u0082Õ\u0088\u0093\u009e\u0097\u0097Õ±\u0095\u0092¹\u0089\u0092\u009f\u009c\u009e".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 251);
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0098\u0097\u0092\u0095\u0092\u008f".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 251);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static void xj(Context context) {
        xj.hf(context).hf();
    }

    public static String xj(SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        return mg.xj(sharedPreferences);
    }

    public static Map<String, String> xj(Context context, SharedPreferences sharedPreferences) {
        SystemClock.elapsedRealtime();
        db hf = xj.hf(context);
        return hf.xj(hf.xj() instanceof vw ? 200 : 100);
    }

    public static String xj(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optString(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a, null);
        }
        return null;
    }

    public static void xj(kd kdVar) {
        db.xj(kdVar);
    }
}
