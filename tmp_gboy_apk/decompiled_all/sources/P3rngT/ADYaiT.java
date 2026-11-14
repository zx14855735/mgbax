package P3rngT;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextPaint;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class ADYaiT extends ARc23Z {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ Context f6938A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ TextPaint f6939A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final /* synthetic */ ARc23Z f6940A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public final /* synthetic */ AMqCpz f6941ADYaiT;

    public ADYaiT(AMqCpz aMqCpz, Context context, TextPaint textPaint, ARc23Z aRc23Z) {
        this.f6941ADYaiT = aMqCpz;
        this.f6938A2egSU = context;
        this.f6939A4TApA = textPaint;
        this.f6940A5SV6n = aRc23Z;
    }

    @Override // P3rngT.ARc23Z
    public final void A2egSU(int i) {
        this.f6940A5SV6n.A2egSU(i);
    }

    @Override // P3rngT.ARc23Z
    public final void A4TApA(Typeface typeface, boolean z) {
        this.f6941ADYaiT.ARc23Z(this.f6938A2egSU, this.f6939A4TApA, typeface);
        this.f6940A5SV6n.A4TApA(typeface, z);
    }
}
