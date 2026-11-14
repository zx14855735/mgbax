package androidx.core.app;

import android.content.ComponentName;
import android.content.Intent;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class BI9f7h {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final ComponentName f8499A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public boolean f8500A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public int f8501A5SV6n;

    public BI9f7h(ComponentName componentName) {
        this.f8499A2egSU = componentName;
    }

    public abstract void A2egSU(Intent intent);

    public final void A4TApA(int i) {
        if (!this.f8500A4TApA) {
            this.f8500A4TApA = true;
            this.f8501A5SV6n = i;
        } else {
            if (this.f8501A5SV6n == i) {
                return;
            }
            StringBuilder B9tovu2 = J3FDQU.A2egSU.B9tovu(i, "Given job ID ", " is different than previous ");
            B9tovu2.append(this.f8501A5SV6n);
            throw new IllegalArgumentException(B9tovu2.toString());
        }
    }

    public void A5SV6n() {
    }

    public void ADYaiT() {
    }

    public void AMqCpz() {
    }
}
