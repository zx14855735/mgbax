package androidx.recyclerview.widget;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EsrwYR {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ErKPGd f9400A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final EmJGcg f9401A4TApA;

    public EsrwYR(ErKPGd erKPGd) {
        this.f9400A2egSU = erKPGd;
        EmJGcg emJGcg = new EmJGcg();
        emJGcg.f9396A2egSU = 0;
        this.f9401A4TApA = emJGcg;
    }

    public final View A2egSU(int i, int i2, int i3, int i4) {
        ErKPGd erKPGd = this.f9400A2egSU;
        int A4TApA2 = erKPGd.A4TApA();
        int A5SV6n2 = erKPGd.A5SV6n();
        int i5 = i2 > i ? 1 : -1;
        View view = null;
        while (i != i2) {
            View ADYaiT2 = erKPGd.ADYaiT(i);
            int A2egSU2 = erKPGd.A2egSU(ADYaiT2);
            int AMqCpz = erKPGd.AMqCpz(ADYaiT2);
            EmJGcg emJGcg = this.f9401A4TApA;
            emJGcg.f9397A4TApA = A4TApA2;
            emJGcg.f9398A5SV6n = A5SV6n2;
            emJGcg.f9399ADYaiT = A2egSU2;
            emJGcg.AMqCpz = AMqCpz;
            if (i3 != 0) {
                emJGcg.f9396A2egSU = i3;
                if (emJGcg.A2egSU()) {
                    return ADYaiT2;
                }
            }
            if (i4 != 0) {
                emJGcg.f9396A2egSU = i4;
                if (emJGcg.A2egSU()) {
                    view = ADYaiT2;
                }
            }
            i += i5;
        }
        return view;
    }

    public final boolean A4TApA(View view) {
        ErKPGd erKPGd = this.f9400A2egSU;
        int A4TApA2 = erKPGd.A4TApA();
        int A5SV6n2 = erKPGd.A5SV6n();
        int A2egSU2 = erKPGd.A2egSU(view);
        int AMqCpz = erKPGd.AMqCpz(view);
        EmJGcg emJGcg = this.f9401A4TApA;
        emJGcg.f9397A4TApA = A4TApA2;
        emJGcg.f9398A5SV6n = A5SV6n2;
        emJGcg.f9399ADYaiT = A2egSU2;
        emJGcg.AMqCpz = AMqCpz;
        emJGcg.f9396A2egSU = 24579;
        return emJGcg.A2egSU();
    }
}
