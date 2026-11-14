package com.baidu.mobads.sdk.internal.concrete;

import COJEAR.DG07BK;
import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import com.baidu.mobads.sdk.api.IAdInterListener;
import com.baidu.mobads.sdk.internal.a.a;
import com.baidu.mobads.sdk.internal.a.c;
import com.baidu.mobads.sdk.internal.av;
import com.baidu.mobads.sdk.internal.bn;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ViewCompatDelegate implements a {
    private final c c;
    private static final AtomicInteger b = new AtomicInteger(100000);

    /* renamed from: a, reason: collision with root package name */
    private static final String f9799a = "generateViewId";
    private static final boolean d = av.a((Class<?>) DG07BK.class, f9799a, (Class<?>[]) new Class[0]);

    static {
        XMAvQ();
    }

    public ViewCompatDelegate(IAdInterListener iAdInterListener) {
        this.c = c.a(iAdInterListener, this);
    }

    private static /* synthetic */ void XMAvQ() {
        char[] charArray = "ÌÀÂ\u0081ÈÎÂÊ\u0081ÍÀÖ\u0081ÜÇÊÃÃ\u0081åÁÆíÝÆËÈÊ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 175);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÌÃÆÁÆÛ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 175);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    @SuppressLint({"NewApi"})
    public static int generateViewId() {
        AtomicInteger atomicInteger;
        int i;
        int i2;
        if (d) {
            WeakHashMap weakHashMap = DG07BK.f1680A2egSU;
            return View.generateViewId();
        }
        if (bn.a((Context) null).a() >= 17) {
            return View.generateViewId();
        }
        do {
            atomicInteger = b;
            i = atomicInteger.get();
            i2 = i + 1;
            if (i2 > 16777215) {
                i2 = 1;
            }
        } while (!atomicInteger.compareAndSet(i, i2));
        return i;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public int getCode() {
        return this.c.getCode();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Map<String, Object> getData() {
        return this.c.getData();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public IAdInterListener getDelegator() {
        return this.c.getDelegator();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getMessage() {
        return this.c.getMessage();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public Object getTarget() {
        return this.c.getTarget();
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public String getType() {
        return this.c.getType();
    }

    @Override // com.baidu.mobads.sdk.internal.a.a
    public Object handleEvent(String str, String str2, Object[] objArr) {
        if (f9799a.equals(str2)) {
            return Integer.valueOf(generateViewId());
        }
        return null;
    }

    @Override // com.baidu.mobads.sdk.api.IOAdEvent
    public void setTarget(Object obj) {
        this.c.setTarget(obj);
    }
}
