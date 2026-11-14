package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class BniPrB {

    /* renamed from: A2egSU, reason: collision with root package name */
    public Cd8JRx f9300A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9301A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9302A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public boolean f9303ADYaiT;
    public boolean AMqCpz;

    public BniPrB() {
        ADYaiT();
    }

    public final void A2egSU() {
        this.f9302A5SV6n = this.f9303ADYaiT ? this.f9300A2egSU.ASJ6gh() : this.f9300A2egSU.AaHO0E();
    }

    public final void A4TApA(int i, View view) {
        if (this.f9303ADYaiT) {
            int A4TApA2 = this.f9300A2egSU.A4TApA(view);
            Cd8JRx cd8JRx = this.f9300A2egSU;
            this.f9302A5SV6n = (Integer.MIN_VALUE == cd8JRx.f9326A4TApA ? 0 : cd8JRx.AcNBzu() - cd8JRx.f9326A4TApA) + A4TApA2;
        } else {
            this.f9302A5SV6n = this.f9300A2egSU.AMqCpz(view);
        }
        this.f9301A4TApA = i;
    }

    public final void A5SV6n(int i, View view) {
        Cd8JRx cd8JRx = this.f9300A2egSU;
        int AcNBzu2 = Integer.MIN_VALUE == cd8JRx.f9326A4TApA ? 0 : cd8JRx.AcNBzu() - cd8JRx.f9326A4TApA;
        if (AcNBzu2 >= 0) {
            A4TApA(i, view);
            return;
        }
        this.f9301A4TApA = i;
        if (!this.f9303ADYaiT) {
            int AMqCpz = this.f9300A2egSU.AMqCpz(view);
            int AaHO0E2 = AMqCpz - this.f9300A2egSU.AaHO0E();
            this.f9302A5SV6n = AMqCpz;
            if (AaHO0E2 > 0) {
                int ASJ6gh2 = (this.f9300A2egSU.ASJ6gh() - Math.min(0, (this.f9300A2egSU.ASJ6gh() - AcNBzu2) - this.f9300A2egSU.A4TApA(view))) - (this.f9300A2egSU.A5SV6n(view) + AMqCpz);
                if (ASJ6gh2 < 0) {
                    this.f9302A5SV6n -= Math.min(AaHO0E2, -ASJ6gh2);
                    return;
                }
                return;
            }
            return;
        }
        int ASJ6gh3 = (this.f9300A2egSU.ASJ6gh() - AcNBzu2) - this.f9300A2egSU.A4TApA(view);
        this.f9302A5SV6n = this.f9300A2egSU.ASJ6gh() - ASJ6gh3;
        if (ASJ6gh3 > 0) {
            int A5SV6n2 = this.f9302A5SV6n - this.f9300A2egSU.A5SV6n(view);
            int AaHO0E3 = this.f9300A2egSU.AaHO0E();
            int min = A5SV6n2 - (Math.min(this.f9300A2egSU.AMqCpz(view) - AaHO0E3, 0) + AaHO0E3);
            if (min < 0) {
                this.f9302A5SV6n = Math.min(ASJ6gh3, -min) + this.f9302A5SV6n;
            }
        }
    }

    public final void ADYaiT() {
        this.f9301A4TApA = -1;
        this.f9302A5SV6n = Integer.MIN_VALUE;
        this.f9303ADYaiT = false;
        this.AMqCpz = false;
    }

    public final String toString() {
        return "AnchorInfo{mPosition=" + this.f9301A4TApA + ", mCoordinate=" + this.f9302A5SV6n + ", mLayoutFromEnd=" + this.f9303ADYaiT + ", mValid=" + this.AMqCpz + '}';
    }
}
