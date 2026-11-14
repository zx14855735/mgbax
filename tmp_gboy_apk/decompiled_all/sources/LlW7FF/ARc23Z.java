package LlW7FF;

import android.os.Handler;
import okhttp3.Call;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Call f4877A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A5SV6n f4878A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Handler f4879A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public volatile boolean f4880ADYaiT = false;

    public ARc23Z(Call call, A5SV6n a5SV6n, Handler handler) {
        this.f4877A2egSU = call;
        this.f4878A4TApA = a5SV6n;
        this.f4879A5SV6n = handler;
    }

    public void A2egSU() {
        if (this.f4880ADYaiT) {
            return;
        }
        this.f4880ADYaiT = true;
        this.f4879A5SV6n.removeCallbacks(this.f4878A4TApA);
    }
}
