package MOpbMP;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import java.util.ArrayList;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AYUAbz implements DialogInterface.OnShowListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final /* synthetic */ AZOQYO f5016AcNBzu;

    public AYUAbz(AZOQYO azoqyo) {
        this.f5016AcNBzu = azoqyo;
    }

    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.ADYaiT) dialogInterface).findViewById(2131296576);
        if (frameLayout != null) {
            BottomSheetBehavior AaHO0E2 = BottomSheetBehavior.AaHO0E(frameLayout);
            AZOQYO azoqyo = this.f5016AcNBzu;
            azoqyo.f5019AmA8tU = AaHO0E2;
            AaHO0E2.setHideable(false);
            BottomSheetBehavior bottomSheetBehavior = azoqyo.f5019AmA8tU;
            bottomSheetBehavior.f11423CrfGsy = true;
            bottomSheetBehavior.f11424CtFAbx = true;
            frameLayout.post(new A2egSU(this, 8, frameLayout));
            BottomSheetBehavior bottomSheetBehavior2 = azoqyo.f5019AmA8tU;
            ASJ6gh aSJ6gh = new ASJ6gh(this);
            ArrayList arrayList = bottomSheetBehavior2.f11439DcUJf1;
            if (arrayList.contains(aSJ6gh)) {
                return;
            }
            arrayList.add(aSJ6gh);
        }
    }
}
