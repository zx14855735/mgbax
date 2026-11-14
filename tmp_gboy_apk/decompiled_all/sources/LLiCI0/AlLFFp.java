package LLiCI0;

import android.widget.ImageView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AlLFFp implements IhMMDv.ARc23Z {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4698AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ ImageView f4699AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final /* synthetic */ String f4700AmA8tU;

    public AlLFFp(int i, ImageView imageView, String str) {
        this.f4698AcNBzu = i;
        this.f4699AlLFFp = imageView;
        this.f4700AmA8tU = str;
    }

    @Override // IhMMDv.ARc23Z
    public final boolean A2egSU(HXc4pW.BI9f7h bI9f7h) {
        if (this.f4698AcNBzu >= 3) {
            return false;
        }
        this.f4699AlLFFp.postDelayed(new LLYwnm.AMqCpz(5, this), ((long) Math.min(Math.pow(2.0d, r0 + 1), 8.0d)) * 1000);
        return true;
    }

    @Override // IhMMDv.ARc23Z
    public final /* bridge */ /* synthetic */ void A5SV6n(Object obj) {
    }
}
