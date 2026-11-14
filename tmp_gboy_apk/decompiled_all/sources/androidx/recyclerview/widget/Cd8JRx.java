package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class Cd8JRx {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final RecyclerView.ARc23Z f9325A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9326A4TApA = Integer.MIN_VALUE;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final Rect f9327A5SV6n = new Rect();

    public Cd8JRx(RecyclerView.ARc23Z aRc23Z) {
        this.f9325A2egSU = aRc23Z;
    }

    public static Cd8JRx A2egSU(RecyclerView.ARc23Z aRc23Z, int i) {
        if (i == 0) {
            return new CTkVKb(aRc23Z);
        }
        if (i == 1) {
            return new CcAIMM(aRc23Z);
        }
        throw new IllegalArgumentException("invalid orientation");
    }

    public abstract int A4TApA(View view);

    public abstract int A5SV6n(View view);

    public abstract int ADYaiT(View view);

    public abstract int AMqCpz(View view);

    public abstract int ARc23Z();

    public abstract int ASJ6gh();

    public abstract int AYUAbz();

    public abstract int AZOQYO();

    public abstract int AZkASS();

    public abstract int AaHO0E();

    public abstract int AcNBzu();

    public abstract int AlLFFp(View view);

    public abstract int AmA8tU(View view);

    public abstract void AzWtSf(int i);
}
