package PCV8se;

import android.graphics.Path;
import android.graphics.RectF;
import android.widget.FrameLayout;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class BTvldC {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public B2KMhB f7142A5SV6n;

    /* renamed from: A2egSU, reason: collision with root package name */
    public boolean f7140A2egSU = false;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f7141A4TApA = false;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public RectF f7143ADYaiT = new RectF();
    public final Path AMqCpz = new Path();

    public abstract void A2egSU(FrameLayout frameLayout);

    public abstract boolean A4TApA();

    public final void A5SV6n() {
        B2KMhB b2KMhB;
        RectF rectF = this.f7143ADYaiT;
        if (rectF.left > rectF.right || rectF.top > rectF.bottom || (b2KMhB = this.f7142A5SV6n) == null) {
            return;
        }
        B4ZgIw.f7105A2egSU.A2egSU(b2KMhB, null, 1.0f, rectF, null, this.AMqCpz);
    }
}
