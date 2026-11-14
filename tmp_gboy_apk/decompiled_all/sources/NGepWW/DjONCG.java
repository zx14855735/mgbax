package NGepWW;

import java.lang.ref.WeakReference;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class DjONCG extends BNL6CD {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final WeakReference f5751A2egSU;

    public DjONCG(DuwtYk duwtYk) {
        this.f5751A2egSU = new WeakReference(duwtYk);
    }

    @Override // NGepWW.BNL6CD, NGepWW.BTvldC
    public final void AZOQYO(CASmeH cASmeH) {
        DuwtYk duwtYk = (DuwtYk) this.f5751A2egSU.get();
        if (duwtYk == null) {
            return;
        }
        Ddcejp ddcejp = new Ddcejp(duwtYk, duwtYk, cASmeH);
        DG07BK.A2egSU a2egSU = duwtYk.f5753AcNBzu.f5815AlLFFp;
        a2egSU.sendMessage(a2egSU.obtainMessage(1, ddcejp));
    }
}
