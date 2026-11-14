package androidx.fragment.app;

import android.view.View;
import java.util.LinkedHashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AZkASS {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final DyaChj f8741A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final C2rE4F.AMqCpz f8742A4TApA;

    public AZkASS(DyaChj dyaChj, C2rE4F.AMqCpz aMqCpz) {
        this.f8741A2egSU = dyaChj;
        this.f8742A4TApA = aMqCpz;
    }

    public final void A2egSU() {
        DyaChj dyaChj = this.f8741A2egSU;
        C2rE4F.AMqCpz aMqCpz = this.f8742A4TApA;
        LinkedHashSet linkedHashSet = dyaChj.AMqCpz;
        if (linkedHashSet.remove(aMqCpz) && linkedHashSet.isEmpty()) {
            dyaChj.A4TApA();
        }
    }

    public final boolean A4TApA() {
        DyaChj dyaChj = this.f8741A2egSU;
        View view = dyaChj.f8955A5SV6n.mView;
        RXb0Sz.ARc23Z.ADYaiT(view, "operation.fragment.mView");
        int i = 4;
        if (view.getAlpha() != 0.0f || view.getVisibility() != 0) {
            int visibility = view.getVisibility();
            if (visibility == 0) {
                i = 2;
            } else if (visibility != 4) {
                if (visibility != 8) {
                    throw new IllegalArgumentException(ADYaiT.CtFAbx.ARc23Z(visibility, "Unknown visibility "));
                }
                i = 3;
            }
        }
        int i2 = dyaChj.f8953A2egSU;
        if (i != i2) {
            return (i == 2 || i2 == 2) ? false : true;
        }
        return true;
    }
}
