package GJee0v;

import ADYaiT.DUi7mC;
import android.content.Context;
import okhttp3.OkHttpClient;
import okhttp3.Request;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AYUAbz {

    /* renamed from: A4TApA, reason: collision with root package name */
    public static AYUAbz f3037A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final OkHttpClient f3038A2egSU = new OkHttpClient();

    public static AYUAbz A2egSU() {
        if (f3037A4TApA == null) {
            f3037A4TApA = new AYUAbz();
        }
        return f3037A4TApA;
    }

    public final void A4TApA(Context context, String str, String str2, ASJ6gh aSJ6gh) {
        this.f3038A2egSU.newCall(new Request.Builder().url(str).build()).enqueue(new DUi7mC(aSJ6gh, context, str2));
    }
}
