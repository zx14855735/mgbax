package androidx.fragment.app;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class CQhlFr extends CNPG0E {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final FragmentActivity f8811AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final FragmentActivity f8812AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final Handler f8813AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final D8MqeW f8814AzWtSf;

    public CQhlFr(FragmentActivity fragmentActivity) {
        Handler handler = new Handler();
        this.f8814AzWtSf = new D8MqeW();
        this.f8811AcNBzu = fragmentActivity;
        this.f8812AlLFFp = fragmentActivity;
        this.f8813AmA8tU = handler;
    }

    public Activity getActivity() {
        return this.f8811AcNBzu;
    }

    public Context getContext() {
        return this.f8812AlLFFp;
    }
}
