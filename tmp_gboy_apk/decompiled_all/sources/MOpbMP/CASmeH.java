package MOpbMP;

import android.content.DialogInterface;
import android.widget.FrameLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class CASmeH implements DialogInterface.OnShowListener {
    @Override // android.content.DialogInterface.OnShowListener
    public final void onShow(DialogInterface dialogInterface) {
        FrameLayout frameLayout = (FrameLayout) ((com.google.android.material.bottomsheet.ADYaiT) dialogInterface).findViewById(2131296576);
        if (frameLayout != null) {
            BottomSheetBehavior AaHO0E2 = BottomSheetBehavior.AaHO0E(frameLayout);
            AaHO0E2.setState(3);
            AaHO0E2.f11423CrfGsy = true;
        }
    }
}
