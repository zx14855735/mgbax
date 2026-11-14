package com.bytedance.sdk.component.hf.xj.xj;

import com.bytedance.sdk.component.hf.xj.pl;
import com.bytedance.sdk.component.hf.xj.xj.hf.w;
import com.bytedance.sdk.component.hf.xj.xj.xj.y;
import java.lang.reflect.Method;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static AtomicBoolean hf = new AtomicBoolean(true);
    private static volatile xj xj;

    static {
        gGvI();
    }

    private xj() {
    }

    private static /* synthetic */ void gGvI() {
        char[] charArray = "\u0013\u001f\u001d^\u0017\u0011\u001d\u0015^\u0012\u001f\t^\u0003\u0018\u0015\u001c\u001c^:\u001e\u00192\u0002\u0019\u0014\u0017\u0015".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'p');
        }
        String str = new String(charArray);
        char[] charArray2 = "\u0013\u001c\u0019\u001e\u0019\u0004".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'p');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj = new xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public boolean hf() {
        AtomicBoolean atomicBoolean = hf;
        if (atomicBoolean == null) {
            return true;
        }
        return atomicBoolean.get();
    }

    public static pl hf(pl.xj xjVar) {
        return new y(xjVar);
    }

    public void xj(boolean z) {
        com.bytedance.sdk.component.utils.pl.xj("NetClientAdapter", "set useOkHttp:".concat(String.valueOf(z)));
        hf.set(z);
    }

    public static pl xj(pl.xj xjVar) {
        return new w(xjVar);
    }
}
