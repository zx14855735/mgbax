package DG07BK;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import com.sigmob.sdk.base.views.r;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A4TApA {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final IntentFilter f2060A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final BroadcastReceiver f2061A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public boolean f2062A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f2063ADYaiT;

    public A4TApA(IntentFilter intentFilter, BroadcastReceiver broadcastReceiver) {
        this.f2060A2egSU = intentFilter;
        this.f2061A4TApA = broadcastReceiver;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder(r.b.d);
        sb.append("Receiver{");
        sb.append(this.f2061A4TApA);
        sb.append(" filter=");
        sb.append(this.f2060A2egSU);
        if (this.f2063ADYaiT) {
            sb.append(" DEAD");
        }
        sb.append("}");
        return sb.toString();
    }
}
