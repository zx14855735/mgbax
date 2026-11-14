package com.ss.android.downloadlib.c;

import android.annotation.TargetApi;
import android.os.AsyncTask;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    static final xj xj = new C0468hf();

    @TargetApi(11)
    /* renamed from: com.ss.android.downloadlib.c.hf$hf, reason: collision with other inner class name */
    public static class C0468hf extends xj {
        private C0468hf() {
            super();
        }

        @Override // com.ss.android.downloadlib.c.hf.xj
        public <T> void xj(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    public static class xj {
        private xj() {
        }

        public <T> void xj(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
            try {
                asyncTask.executeOnExecutor(com.bytedance.sdk.component.tf.u.hf.xj, tArr);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        NftO();
    }

    private static /* synthetic */ void NftO() {
        char[] charArray = "¯£¡â«\u00ad¡©â®£µâ¿¤©  â\u0086¢¥\u008e¾¥¨«©".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 204);
        }
        String str = new String(charArray);
        char[] charArray2 = "¯ ¥¢¥¸".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 204);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static <T> void xj(AsyncTask<T, ?, ?> asyncTask, T... tArr) {
        xj.xj(asyncTask, tArr);
    }
}
