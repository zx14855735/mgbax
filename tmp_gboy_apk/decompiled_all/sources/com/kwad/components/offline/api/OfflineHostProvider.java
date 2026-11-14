package com.kwad.components.offline.api;

import android.content.Context;
import com.kwad.components.offline.api.core.IOfflineHostApi;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class OfflineHostProvider {
    private Context mContext;
    private IOfflineHostApi mOfflineHostApi;

    public static final class Holder {
        private static final OfflineHostProvider sInstance = new OfflineHostProvider();

        static {
            kQvfMDH();
        }

        private Holder() {
        }

        private static /* synthetic */ void kQvfMDH() {
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

    private OfflineHostProvider() {
    }

    public static OfflineHostProvider get() {
        return Holder.sInstance;
    }

    public static IOfflineHostApi getApi() {
        return get().mOfflineHostApi;
    }

    public Context getContext() {
        return this.mContext;
    }

    public void init(Context context, IOfflineHostApi iOfflineHostApi) {
        this.mContext = context;
        this.mOfflineHostApi = iOfflineHostApi;
    }
}
