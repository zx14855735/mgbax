package okhttp3.internal.http;

import com.baidu.mobads.sdk.internal.an;
import com.sigmob.sdk.downloader.core.c;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class ARc23Z {
    private ARc23Z() {
    }

    public static boolean A2egSU(String str) {
        return str.equals(an.b) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE");
    }

    public static boolean A4TApA(String str) {
        return (str.equals(an.c) || str.equals(c.f13360a)) ? false : true;
    }
}
