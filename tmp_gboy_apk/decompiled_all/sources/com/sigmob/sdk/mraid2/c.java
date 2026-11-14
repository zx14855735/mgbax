package com.sigmob.sdk.mraid2;

import android.text.TextUtils;
import java.lang.reflect.Method;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class c {
    private static final c b = new c();

    /* renamed from: a, reason: collision with root package name */
    private final HashMap<String, e> f13538a = new HashMap<>();

    static {
        OPQFjAP();
    }

    private c() {
    }

    private static /* synthetic */ void OPQFjAP() {
        char[] charArray = "\u001a\u0016\u0014W\u001e\u0018\u0014\u001cW\u001b\u0016\u0000W\n\u0011\u001c\u0015\u0015W3\u0017\u0010;\u000b\u0010\u001d\u001e\u001c".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'y');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u001a\u0015\u0010\u0017\u0010\r".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'y');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static c a() {
        return b;
    }

    public e b(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f13538a.get(str);
    }

    public e a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        e eVar = this.f13538a.get(str);
        this.f13538a.remove(str);
        return eVar;
    }

    public void a(String str, e eVar) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f13538a.put(str, eVar);
    }
}
