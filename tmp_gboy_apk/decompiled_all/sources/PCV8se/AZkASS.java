package PCV8se;

import com.google.android.material.button.MaterialButton;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AZkASS extends com.bumptech.glide.AMqCpz {

    /* renamed from: ARc23Z, reason: collision with root package name */
    public final int f7038ARc23Z;

    public AZkASS(int i) {
        this.f7038ARc23Z = i;
    }

    @Override // com.bumptech.glide.AMqCpz
    public final float BniPrB(Object obj) {
        float[] fArr = ((AaHO0E) obj).f7068CTkVKb;
        if (fArr != null) {
            return fArr[this.f7038ARc23Z];
        }
        return 0.0f;
    }

    @Override // com.bumptech.glide.AMqCpz
    public final void Cd8JRx(Object obj, float f) {
        AaHO0E aaHO0E = (AaHO0E) obj;
        float[] fArr = aaHO0E.f7068CTkVKb;
        if (fArr != null) {
            int i = this.f7038ARc23Z;
            if (fArr[i] != f) {
                fArr[i] = f;
                Cd8JRx.ADYaiT aDYaiT = aaHO0E.f7070Cd8JRx;
                if (aDYaiT != null) {
                    int AZOQYO2 = (int) (aaHO0E.AZOQYO() * 0.11f);
                    MaterialButton materialButton = (MaterialButton) aDYaiT.f1779AlLFFp;
                    if (materialButton.f11479CASmeH != AZOQYO2) {
                        materialButton.f11479CASmeH = AZOQYO2;
                        materialButton.AZkASS();
                        materialButton.invalidate();
                    }
                }
                aaHO0E.invalidateSelf();
            }
        }
    }
}
