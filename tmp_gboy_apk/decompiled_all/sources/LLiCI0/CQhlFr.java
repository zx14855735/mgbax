package LLiCI0;

import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CQhlFr implements View.OnClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ int f4775AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ CSDoyG f4776AlLFFp;

    public /* synthetic */ CQhlFr(CSDoyG cSDoyG, int i) {
        this.f4775AcNBzu = i;
        this.f4776AlLFFp = cSDoyG;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        switch (this.f4775AcNBzu) {
            case 0:
                CSDoyG cSDoyG = this.f4776AlLFFp;
                cSDoyG.getClass();
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - cSDoyG.f4783B3GDIM > 500) {
                    cSDoyG.f4783B3GDIM = currentTimeMillis;
                    MTKlkd.ARc23Z aRc23Z = (MTKlkd.ARc23Z) view.getTag();
                    COJEAR cojear = cSDoyG.f4782B2KMhB;
                    if (cojear != null && aRc23Z != null && aRc23Z.getType() != null && !aRc23Z.getType().isEmpty()) {
                        cojear.A4TApA(aRc23Z);
                        break;
                    }
                }
                break;
            default:
                CSDoyG cSDoyG2 = this.f4776AlLFFp;
                cSDoyG2.getClass();
                long currentTimeMillis2 = System.currentTimeMillis();
                if (currentTimeMillis2 - cSDoyG2.f4783B3GDIM > 500) {
                    cSDoyG2.f4783B3GDIM = currentTimeMillis2;
                    MTKlkd.ARc23Z aRc23Z2 = (MTKlkd.ARc23Z) view.getTag();
                    COJEAR cojear2 = cSDoyG2.f4782B2KMhB;
                    if (cojear2 != null && aRc23Z2 != null) {
                        cojear2.A5SV6n(aRc23Z2);
                        break;
                    }
                }
                break;
        }
    }
}
