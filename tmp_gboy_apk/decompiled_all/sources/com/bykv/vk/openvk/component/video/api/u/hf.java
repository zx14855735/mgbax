package com.bykv.vk.openvk.component.video.api.u;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import java.lang.ref.WeakReference;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface hf<T> extends com.bykv.vk.openvk.component.video.api.hf.xj {

    public enum xj {
        hideCloseBtn,
        alwayShowBackBtn,
        alwayShowMediaView,
        fixedSize,
        hideBackBtn,
        hideTopMoreBtn;

        static {
            ZLbKb();
        }

        private static /* synthetic */ void ZLbKb() {
            char[] charArray = "\u0099\u0095\u0097Ô\u009d\u009b\u0097\u009fÔ\u0098\u0095\u0083Ô\u0089\u0092\u009f\u0096\u0096Ô°\u0094\u0093¸\u0088\u0093\u009e\u009d\u009f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 250);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0099\u0096\u0093\u0094\u0093\u008e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 250);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    void hf();

    View w();

    void xj();

    void xj(int i);

    void xj(Drawable drawable);

    void xj(T t, WeakReference<Context> weakReference, boolean z);

    void xj(boolean z);
}
