package com.fl.saas.config.utils;

import android.app.Activity;
import com.fl.saas.common.listener.DeepLinkOpenListener;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class DeepLinkJumpUtil {
    public static final int DEEPLINK_OPEN_REQUEST = 10001;
    private DeepLinkOpenListener deepLinkOpenListener;

    public static class Holder {
        private static final DeepLinkJumpUtil INSTANCE = new DeepLinkJumpUtil();

        static {
            bzMgNhH();
        }

        private Holder() {
        }

        private static /* synthetic */ void bzMgNhH() {
            char[] charArray = "ÅÉË\u0088ÁÇËÃ\u0088ÄÉß\u0088ÕÎÃÊÊ\u0088ìÈÏäÔÏÂÁÃ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 166);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÅÊÏÈÏÒ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 166);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    private DeepLinkJumpUtil() {
    }

    public static DeepLinkJumpUtil getInstance() {
        return Holder.INSTANCE;
    }

    public void reportActivityResult(int i, int i2, Activity activity) {
        DeepLinkOpenListener deepLinkOpenListener;
        if (i == 10001 && i2 == 0 && (deepLinkOpenListener = this.deepLinkOpenListener) != null) {
            deepLinkOpenListener.onDeepLinkOpenFailed(activity);
            this.deepLinkOpenListener = null;
        }
    }

    public void setDeepLinkOpenListener(DeepLinkOpenListener deepLinkOpenListener) {
        this.deepLinkOpenListener = deepLinkOpenListener;
    }
}
