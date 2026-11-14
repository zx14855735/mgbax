package Oay4Bh;

import android.view.SubMenu;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class AcNBzu extends AZkASS.AmA8tU {
    @Override // AZkASS.AmA8tU, android.view.Menu
    public final SubMenu addSubMenu(int i, int i2, int i3, CharSequence charSequence) {
        AZkASS.B25kr6 A2egSU2 = A2egSU(i, i2, i3, charSequence);
        BIYEnU bIYEnU = new BIYEnU(getContext(), this, A2egSU2, 0);
        A2egSU2.f534BNL6CD = bIYEnU;
        bIYEnU.setHeaderTitle(A2egSU2.f524B25kr6);
        return bIYEnU;
    }
}
