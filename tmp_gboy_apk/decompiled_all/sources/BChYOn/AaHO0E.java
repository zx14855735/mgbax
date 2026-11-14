package BChYOn;

import BI9f7h.AzWtSf;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class AaHO0E extends ARc23Z {

    /* renamed from: DuwtYk, reason: collision with root package name */
    public ARc23Z[] f1262DuwtYk = new ARc23Z[4];

    /* renamed from: DvK7DB, reason: collision with root package name */
    public int f1263DvK7DB = 0;

    public final void CkXcdM(int i, AzWtSf azWtSf, ArrayList arrayList) {
        for (int i2 = 0; i2 < this.f1263DvK7DB; i2++) {
            ARc23Z aRc23Z = this.f1262DuwtYk[i2];
            ArrayList arrayList2 = azWtSf.f1313A2egSU;
            if (!arrayList2.contains(aRc23Z)) {
                arrayList2.add(aRc23Z);
            }
        }
        for (int i3 = 0; i3 < this.f1263DvK7DB; i3++) {
            BI9f7h.AZOQYO.A2egSU(this.f1262DuwtYk[i3], i, arrayList, azWtSf);
        }
    }

    public void CmUvjW() {
    }
}
