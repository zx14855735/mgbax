package com.kwad.components.offline.api.adInnerEc;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adInnerEc.IAdInnerEcExternalModule;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IAdInnerEcOfflineCompo extends IOfflineCompo<IAdInnerEcOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdInnerEcOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adInnerEc";

    public enum AdInnerEcState {
        READY,
        SO_FAIL;

        static {
            eAaf();
        }

        private static /* synthetic */ void eAaf() {
            char[] charArray = "\u0089\u0085\u0087Ä\u008d\u008b\u0087\u008fÄ\u0088\u0085\u0093Ä\u0099\u0082\u008f\u0086\u0086Ä \u0084\u0083¨\u0098\u0083\u008e\u008d\u008f".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 234);
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0089\u0086\u0083\u0084\u0083\u009e".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 234);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    IAdInnerEcExternalModule getAdInnerEcExternalModule();

    AdInnerEcState getState();
}
