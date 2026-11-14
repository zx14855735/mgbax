package QgOIY0;

import android.graphics.Rect;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public final class BpkvW3 implements Runnable {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final B2KMhB f7655AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final B2KMhB f7656AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final boolean f7657AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public final View f7658AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public final Rect f7659B25kr6;

    public BpkvW3(B2KMhB b2KMhB, B2KMhB b2KMhB2, boolean z, QkAq4X.A4TApA a4TApA, View view, Rect rect) {
        this.f7655AcNBzu = b2KMhB;
        this.f7656AlLFFp = b2KMhB2;
        this.f7657AmA8tU = z;
        this.f7658AzWtSf = view;
        this.f7659B25kr6 = rect;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f7657AmA8tU) {
            this.f7656AlLFFp.getClass();
        } else {
            this.f7655AcNBzu.getClass();
        }
        View view = this.f7658AzWtSf;
        if (view != null) {
            AMqCpz.ASJ6gh(this.f7659B25kr6, view);
        }
    }
}
