package OLvDpK;

import PCV8se.BmvVmW;
import PCV8se.BniPrB;
import android.graphics.Outline;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewOutlineProvider;
import com.google.android.material.chip.Chip;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A5SV6n extends ViewOutlineProvider {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ int f6274A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ Object f6275A4TApA;

    public /* synthetic */ A5SV6n(int i, Object obj) {
        this.f6274A2egSU = i;
        this.f6275A4TApA = obj;
    }

    @Override // android.view.ViewOutlineProvider
    public final void getOutline(View view, Outline outline) {
        switch (this.f6274A2egSU) {
            case 0:
                ARc23Z aRc23Z = ((Chip) this.f6275A4TApA).f11549B25kr6;
                if (aRc23Z == null) {
                    outline.setAlpha(0.0f);
                    break;
                } else {
                    aRc23Z.getOutline(outline);
                    break;
                }
            case 1:
                BmvVmW bmvVmW = (BmvVmW) this.f6275A4TApA;
                if (bmvVmW.f7142A5SV6n != null && !bmvVmW.f7143ADYaiT.isEmpty()) {
                    RectF rectF = bmvVmW.f7143ADYaiT;
                    outline.setRoundRect((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom, bmvVmW.f7145ASJ6gh);
                    break;
                }
                break;
            default:
                Path path = ((BniPrB) this.f6275A4TApA).AMqCpz;
                if (!path.isEmpty()) {
                    outline.setPath(path);
                    break;
                }
                break;
        }
    }
}
