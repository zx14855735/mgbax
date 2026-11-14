package com.bytedance.sdk.component.adexpress.xj.xj;

import com.bytedance.sdk.component.y.ht;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static xj kd = new xj();
    private volatile u hf;
    private volatile ht u;
    private volatile w w;
    private volatile hf xj;
    private volatile kd y;

    static {
        DmqsdsK();
    }

    private xj() {
    }

    private static /* synthetic */ void DmqsdsK() {
        char[] charArray = "R^\\\u001fVP\\T\u001fS^H\u001fBYT]]\u001f{_XsCXUVT".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ '1');
        }
        String str = new String(charArray);
        char[] charArray2 = "R]X_XE".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ '1');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static xj xj() {
        return kd;
    }

    public hf hf() {
        return this.xj;
    }

    public ht kd() {
        return this.u;
    }

    public u u() {
        return this.hf;
    }

    public w w() {
        return this.w;
    }

    public kd y() {
        return this.y;
    }

    public void xj(hf hfVar) {
        this.xj = hfVar;
    }

    public void xj(w wVar) {
        this.w = wVar;
    }

    public void xj(u uVar) {
        this.hf = uVar;
    }

    public void xj(ht htVar) {
        this.u = htVar;
    }

    public void xj(kd kdVar) {
        this.y = kdVar;
    }
}
