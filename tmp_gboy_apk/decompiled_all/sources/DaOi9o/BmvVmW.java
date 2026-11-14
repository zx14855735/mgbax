package DaOi9o;

import ADYaiT.CtFAbx;
import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BmvVmW {

    /* renamed from: A4TApA, reason: collision with root package name */
    public final View f2282A4TApA;

    /* renamed from: A2egSU, reason: collision with root package name */
    public final HashMap f2281A2egSU = new HashMap();

    /* renamed from: A5SV6n, reason: collision with root package name */
    public final ArrayList f2283A5SV6n = new ArrayList();

    @Deprecated
    public BmvVmW() {
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BmvVmW)) {
            return false;
        }
        BmvVmW bmvVmW = (BmvVmW) obj;
        return this.f2282A4TApA == bmvVmW.f2282A4TApA && this.f2281A2egSU.equals(bmvVmW.f2281A2egSU);
    }

    public final int hashCode() {
        return this.f2281A2egSU.hashCode() + (this.f2282A4TApA.hashCode() * 31);
    }

    public final String toString() {
        StringBuilder A5SV6n2 = B4ZgIw.AYUAbz.A5SV6n("TransitionValues@" + Integer.toHexString(hashCode()) + ":\n", "    view = ");
        A5SV6n2.append(this.f2282A4TApA);
        A5SV6n2.append("\n");
        String AcNBzu2 = CtFAbx.AcNBzu(A5SV6n2.toString(), "    values:");
        HashMap hashMap = this.f2281A2egSU;
        for (String str : hashMap.keySet()) {
            AcNBzu2 = AcNBzu2 + "    " + str + ": " + hashMap.get(str) + "\n";
        }
        return AcNBzu2;
    }

    public BmvVmW(View view) {
        this.f2282A4TApA = view;
    }
}
