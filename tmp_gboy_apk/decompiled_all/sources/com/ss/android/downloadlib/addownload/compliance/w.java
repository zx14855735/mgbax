package com.ss.android.downloadlib.addownload.compliance;

import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class w extends com.ss.android.socialbase.downloader.tf.f<Long, com.ss.android.downloadlib.addownload.hf.hf> {

    public static class xj {
        private static w xj = new w();

        static {
            omrP();
        }

        private static /* synthetic */ void omrP() {
            char[] charArray = "øôöµüúöþµùôâµèóþ÷÷µÑõòÙéòÿüþ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 155);
            }
            String str = new String(charArray);
            char[] charArray2 = "ø÷òõòï".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 155);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public static w xj() {
        return xj.xj;
    }

    private w() {
        super(16, 16);
    }

    public void xj(com.ss.android.downloadlib.addownload.hf.hf hfVar) {
        if (hfVar == null) {
            return;
        }
        put(Long.valueOf(hfVar.xj()), hfVar);
    }

    public com.ss.android.downloadlib.addownload.hf.hf xj(long j, long j2) {
        return get(get(Long.valueOf(j)) != null ? Long.valueOf(j) : Long.valueOf(j2));
    }

    public com.ss.android.downloadlib.addownload.hf.hf xj(long j) {
        return get(Long.valueOf(j));
    }
}
