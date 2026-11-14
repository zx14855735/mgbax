package androidx.recyclerview.widget;

import com.qq.e.comm.adevent.AdEventType;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class EmJGcg {

    /* renamed from: A2egSU, reason: collision with root package name */
    public int f9396A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public int f9397A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f9398A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f9399ADYaiT;
    public int AMqCpz;

    public final boolean A2egSU() {
        int i = this.f9396A2egSU;
        int i2 = 2;
        if ((i & 7) != 0) {
            int i3 = this.f9399ADYaiT;
            int i4 = this.f9397A4TApA;
            if (((i3 > i4 ? 1 : i3 == i4 ? 2 : 4) & i) == 0) {
                return false;
            }
        }
        if ((i & AdEventType.AD_TICK) != 0) {
            int i5 = this.f9399ADYaiT;
            int i6 = this.f9398A5SV6n;
            if ((((i5 > i6 ? 1 : i5 == i6 ? 2 : 4) << 4) & i) == 0) {
                return false;
            }
        }
        if ((i & 1792) != 0) {
            int i7 = this.AMqCpz;
            int i8 = this.f9397A4TApA;
            if ((((i7 > i8 ? 1 : i7 == i8 ? 2 : 4) << 8) & i) == 0) {
                return false;
            }
        }
        if ((i & 28672) != 0) {
            int i9 = this.AMqCpz;
            int i10 = this.f9398A5SV6n;
            if (i9 > i10) {
                i2 = 1;
            } else if (i9 != i10) {
                i2 = 4;
            }
            if ((i & (i2 << 12)) == 0) {
                return false;
            }
        }
        return true;
    }
}
