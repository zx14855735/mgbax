package com.bytedance.sdk.openadsdk.ats;

import android.util.Pair;
import android.util.SparseArray;
import com.bytedance.sdk.component.u.p;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class f implements p, Function {
    private static HashMap<String, xj> xj = new HashMap<>();
    private p hf = new com.bytedance.sdk.openadsdk.ats.xj.w();

    public static final class xj {
        int hf;
        boolean u;
        long w;
        String xj;

        private xj() {
        }
    }

    static {
        fdbrRB();
    }

    private static /* synthetic */ void fdbrRB() {
        char[] charArray = "amo,ecog,`m{,qjgnn,Hlk@pkfeg".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 2);
        }
        String str = new String(charArray);
        char[] charArray2 = "anklkv".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 2);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private Pair<xj, Boolean> xj(String str) {
        xj xjVar = xj.get(str);
        if (xjVar != null) {
            return new Pair<>(xjVar, Boolean.FALSE);
        }
        xj xjVar2 = new xj();
        xj.put(str, xjVar2);
        return new Pair<>(xjVar2, Boolean.TRUE);
    }

    @Override // java.util.function.Function
    public Object apply(Object obj) {
        SparseArray sparseArray = (SparseArray) obj;
        int intValue = ((Integer) sparseArray.get(0)).intValue();
        if (intValue == 1) {
            return get((String) sparseArray.get(1));
        }
        if (intValue == 2) {
            return Integer.valueOf(getInt((String) sparseArray.get(1)));
        }
        if (intValue == 3) {
            return Long.valueOf(getLong((String) sparseArray.get(1)));
        }
        if (intValue == 4) {
            return Boolean.valueOf(getBoolean((String) sparseArray.get(1)));
        }
        if (intValue != 5) {
            return null;
        }
        set((String) sparseArray.get(1), (String) sparseArray.get(2));
        return null;
    }

    @Override // com.bytedance.sdk.component.u.p
    public String get(String str) {
        Pair<xj, Boolean> xj2 = xj(str);
        if (((Boolean) xj2.second).booleanValue()) {
            ((xj) xj2.first).xj = this.hf.get(str);
        }
        return ((xj) xj2.first).xj;
    }

    @Override // com.bytedance.sdk.component.u.p
    public boolean getBoolean(String str) {
        Pair<xj, Boolean> xj2 = xj(str);
        if (((Boolean) xj2.second).booleanValue()) {
            ((xj) xj2.first).u = this.hf.getBoolean(str);
        }
        return ((xj) xj2.first).u;
    }

    @Override // com.bytedance.sdk.component.u.p
    public int getInt(String str) {
        Pair<xj, Boolean> xj2 = xj(str);
        if (((Boolean) xj2.second).booleanValue()) {
            ((xj) xj2.first).hf = this.hf.getInt(str);
        }
        return ((xj) xj2.first).hf;
    }

    @Override // com.bytedance.sdk.component.u.p
    public long getLong(String str) {
        Pair<xj, Boolean> xj2 = xj(str);
        if (((Boolean) xj2.second).booleanValue()) {
            ((xj) xj2.first).w = this.hf.getLong(str);
        }
        return ((xj) xj2.first).w;
    }

    @Override // com.bytedance.sdk.component.u.p
    public void set(String str, String str2) {
        this.hf.set(str, str2);
    }
}
