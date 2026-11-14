package MOpbMP;

import android.widget.Toast;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CcAIMM implements LlW7FF.AMqCpz {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ CmUvjW f5116AcNBzu;

    public /* synthetic */ CcAIMM(CmUvjW cmUvjW) {
        this.f5116AcNBzu = cmUvjW;
    }

    @Override // LlW7FF.AMqCpz
    public void ARc23Z(String str) {
    }

    @Override // LlW7FF.AMqCpz
    public void onSuccess(Object obj) {
        MTKlkd.AZkASS aZkASS = (MTKlkd.AZkASS) obj;
        CmUvjW cmUvjW = this.f5116AcNBzu;
        if (!cmUvjW.isAdded() || cmUvjW.isDetached()) {
            return;
        }
        if (aZkASS.AYUAbz()) {
            ARc23Z.B2KMhB(aZkASS, cmUvjW.f5123AcNBzu);
            cmUvjW.f5136BJ7GGh.setText(aZkASS.ASJ6gh());
            cmUvjW.f5137BNL6CD.setText(CmUvjW.AZkASS(aZkASS.ADYaiT()));
            L2suez.AZOQYO.A4TApA(cmUvjW.requireActivity(), aZkASS.A2egSU(), cmUvjW.f5134BI9f7h);
            L2suez.AZOQYO.A4TApA(cmUvjW.requireActivity(), aZkASS.A4TApA() == null ? aZkASS.A2egSU() : aZkASS.A4TApA(), cmUvjW.f5135BIYEnU);
            return;
        }
        cmUvjW.f5136BJ7GGh.setText(cmUvjW.getString(2131886640));
        cmUvjW.f5137BNL6CD.setText(CmUvjW.AZkASS(cmUvjW.getString(2131886640)));
        L2suez.AZOQYO.A4TApA(cmUvjW.requireActivity(), null, cmUvjW.f5134BI9f7h);
        L2suez.AZOQYO.A4TApA(cmUvjW.requireActivity(), null, cmUvjW.f5135BIYEnU);
        ARc23Z.AlLFFp(cmUvjW.f5123AcNBzu);
        Toast.makeText(cmUvjW.getContext(), aZkASS.AMqCpz(), 0).show();
    }
}
