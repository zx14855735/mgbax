package com.baidu.mobads.sdk.internal;

import android.content.Context;
import android.text.TextUtils;
import java.lang.reflect.Method;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class at {

    /* renamed from: a, reason: collision with root package name */
    private static final String f9745a = x.q;
    private static final String b = "pauseDlByPk";
    private static final String c = "cancelDlByPk";
    private static final String d = "resumeDownload";
    private static final String e = "getDownloadStatus";
    private static at g;
    private au f;

    static {
        TAqkx();
    }

    private at(Context context) {
        this.f = au.a(context, f9745a);
    }

    private static /* synthetic */ void TAqkx() {
        char[] charArray = "}qs0y\u007fs{0|qg0mv{rr0Tpw\\lwzy{".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 30);
        }
        String str = new String(charArray);
        char[] charArray2 = "}rwpwj".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 30);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static at a(Context context) {
        if (g == null) {
            synchronized (at.class) {
                try {
                    if (g == null) {
                        g = new at(context);
                    }
                } finally {
                }
            }
        }
        return g;
    }

    public void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, c, str);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f.a(null, b, str, 1);
    }

    public boolean a(Context context, JSONObject jSONObject, String str, String str2) {
        if (context != null && jSONObject != null) {
            Object b2 = this.f.b(null, d, context, jSONObject, str, str2);
            if (b2 instanceof Boolean) {
                return ((Boolean) b2).booleanValue();
            }
        }
        return false;
    }

    public int a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        if (bw.a(context, str)) {
            return 103;
        }
        Object b2 = this.f.b(null, e, str);
        if (b2 instanceof Integer) {
            return ((Integer) b2).intValue();
        }
        return -1;
    }
}
