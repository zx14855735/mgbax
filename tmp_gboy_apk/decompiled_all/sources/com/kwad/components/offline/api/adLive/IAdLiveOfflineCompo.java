package com.kwad.components.offline.api.adLive;

import android.content.Context;
import com.kwad.components.offline.api.IOfflineCompo;
import com.kwad.components.offline.api.core.adlive.IAdLiveEndRequest;
import com.kwad.components.offline.api.core.adlive.IAdLiveOfflineView;
import com.kwad.components.offline.api.core.adlive.IAdLivePlayModule;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public interface IAdLiveOfflineCompo extends IOfflineCompo<IAdLiveOfflineCompoInitConfig> {
    public static final String IMPL = "com.kwad.sdk.AdLiveOfflineCompoImpl";
    public static final String PACKAGE_NAME = "com.kwad.components.adLive";

    public enum AdLiveState {
        READY,
        SO_FAIL;

        static {
            bfGlZQ();
        }

        private static /* synthetic */ void bfGlZQ() {
            char[] charArray = "ÆÊÈ\u008bÂÄÈÀ\u008bÇÊÜ\u008bÖÍÀÉÉ\u008bïËÌç×ÌÁÂÀ".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 165);
            }
            String str = new String(charArray);
            char[] charArray2 = "ÆÉÌËÌÑ".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 165);
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    IAdLiveEndRequest getAdLiveEndRequest(String str);

    IAdLivePlayModule getAdLivePlayModule(IAdLiveOfflineView iAdLiveOfflineView, String str, String str2, String str3, long j, int i);

    AdLiveState getState();

    IAdLiveOfflineView getView(Context context, int i);
}
