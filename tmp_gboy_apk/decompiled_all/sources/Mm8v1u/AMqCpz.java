package Mm8v1u;

import android.graphics.Rect;
import android.text.TextPaint;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AMqCpz {

    /* renamed from: A2egSU, reason: collision with root package name */
    public String f5475A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public float f5476A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f5477A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f5478ADYaiT;
    public int AMqCpz;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public int f5479ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public Rect f5480ASJ6gh;

    /* renamed from: AYUAbz, reason: collision with root package name */
    public float f5481AYUAbz;

    /* renamed from: AZOQYO, reason: collision with root package name */
    public boolean f5482AZOQYO;

    public final void A2egSU(TextPaint textPaint) {
        if (this.f5482AZOQYO) {
            return;
        }
        this.f5480ASJ6gh = new Rect();
        String str = this.f5475A2egSU;
        textPaint.getTextBounds(str, 0, str.length(), this.f5480ASJ6gh);
        this.f5481AYUAbz = ((this.f5480ASJ6gh.height() / 2.0f) + this.f5477A5SV6n) - this.f5480ASJ6gh.bottom;
        this.f5482AZOQYO = true;
    }
}
