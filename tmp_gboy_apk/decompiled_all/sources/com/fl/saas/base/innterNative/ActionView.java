package com.fl.saas.base.innterNative;

import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public interface ActionView {

    public enum Type {
        Spread,
        Interstitial,
        Template,
        Banner;

        static {
            qcRqTE();
        }

        private static /* synthetic */ void qcRqTE() {
            char[] charArray = "fjh+bdh`+gj|+vm`ii+OklGwlab`".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 5);
            }
            String str = new String(charArray);
            char[] charArray2 = "filklq".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 5);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    View bindActionView(Type type);
}
