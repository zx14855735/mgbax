package com.kwad.components.offline.api.adWaynePlayer;

import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adWaynePlayer.IAdWaynePlayerPlayModule;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IAdWaynePlayerOfflineCompo extends IOfflineCompo<IAdWaynePlayerOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdWaynePlayerOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adWaynePlayer";

    public enum AdWaynePlayerState {
        READY,
        SO_FAIL;

        static {
            RCnz();
        }

        private static /* synthetic */ void RCnz() {
            char[] charArray = "P\\^\u001dTR^V\u001dQ\\J\u001d@[V__\u001dy]ZqAZWTV".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ '3');
            }
            String str = new String(charArray);
            char[] charArray2 = "P_Z]ZG".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ '3');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    IAdWaynePlayerPlayModule getAdWaynePlayerPlayModule(String str, boolean z);

    AdWaynePlayerState getState();
}
