package Oay4Bh;

import android.content.Context;
import android.text.TextPaint;
import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class BniPrB {

    /* renamed from: A5SV6n, reason: collision with root package name */
    public float f6601A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public float f6602ADYaiT;

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final WeakReference f6603ARc23Z;

    /* renamed from: ASJ6gh, reason: collision with root package name */
    public P3rngT.AMqCpz f6604ASJ6gh;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final TextPaint f6599A2egSU = new TextPaint(1);

    /* renamed from: A4TApA, reason: collision with root package name */
    public final OLvDpK.A4TApA f6600A4TApA = new OLvDpK.A4TApA(1, this);
    public boolean AMqCpz = true;

    public BniPrB(BmvVmW bmvVmW) {
        this.f6603ARc23Z = new WeakReference(null);
        this.f6603ARc23Z = new WeakReference(bmvVmW);
    }

    public final float A2egSU(String str) {
        if (!this.AMqCpz) {
            return this.f6601A5SV6n;
        }
        A4TApA(str);
        return this.f6601A5SV6n;
    }

    public final void A4TApA(String str) {
        TextPaint textPaint = this.f6599A2egSU;
        this.f6601A5SV6n = str == null ? 0.0f : textPaint.measureText((CharSequence) str, 0, str.length());
        this.f6602ADYaiT = str != null ? Math.abs(textPaint.getFontMetrics().ascent) : 0.0f;
        this.AMqCpz = false;
    }

    public final void A5SV6n(P3rngT.AMqCpz aMqCpz, Context context) {
        if (this.f6604ASJ6gh != aMqCpz) {
            this.f6604ASJ6gh = aMqCpz;
            if (aMqCpz != null) {
                TextPaint textPaint = this.f6599A2egSU;
                OLvDpK.A4TApA a4TApA = this.f6600A4TApA;
                aMqCpz.AMqCpz(context, textPaint, a4TApA);
                BmvVmW bmvVmW = (BmvVmW) this.f6603ARc23Z.get();
                if (bmvVmW != null) {
                    textPaint.drawableState = bmvVmW.getState();
                }
                aMqCpz.ADYaiT(context, textPaint, a4TApA);
                this.AMqCpz = true;
            }
            BmvVmW bmvVmW2 = (BmvVmW) this.f6603ARc23Z.get();
            if (bmvVmW2 != null) {
                bmvVmW2.A2egSU();
                bmvVmW2.onStateChange(bmvVmW2.getState());
            }
        }
    }
}
