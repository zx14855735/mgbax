package AZkASS;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class BpkvW3 extends AmA8tU implements SubMenu {

    /* renamed from: CQhlFr, reason: collision with root package name */
    public final AmA8tU f591CQhlFr;

    /* renamed from: CSDoyG, reason: collision with root package name */
    public final B25kr6 f592CSDoyG;

    public BpkvW3(Context context, AmA8tU amA8tU, B25kr6 b25kr6) {
        super(context);
        this.f591CQhlFr = amA8tU;
        this.f592CSDoyG = b25kr6;
    }

    @Override // AZkASS.AmA8tU
    public final boolean ADYaiT(B25kr6 b25kr6) {
        return this.f591CQhlFr.ADYaiT(b25kr6);
    }

    @Override // AZkASS.AmA8tU
    public final boolean AMqCpz(AmA8tU amA8tU, MenuItem menuItem) {
        return super.AMqCpz(amA8tU, menuItem) || this.f591CQhlFr.AMqCpz(amA8tU, menuItem);
    }

    @Override // AZkASS.AmA8tU
    public final boolean ARc23Z(B25kr6 b25kr6) {
        return this.f591CQhlFr.ARc23Z(b25kr6);
    }

    @Override // AZkASS.AmA8tU
    public final String AZkASS() {
        B25kr6 b25kr6 = this.f592CSDoyG;
        int i = b25kr6 != null ? b25kr6.f520AcNBzu : 0;
        if (i == 0) {
            return null;
        }
        return CtFAbx.ARc23Z(i, "android:menu:actionviewstates:");
    }

    @Override // AZkASS.AmA8tU
    public final AmA8tU AaHO0E() {
        return this.f591CQhlFr.AaHO0E();
    }

    @Override // AZkASS.AmA8tU
    public final boolean AlLFFp() {
        return this.f591CQhlFr.AlLFFp();
    }

    @Override // AZkASS.AmA8tU
    public final boolean AmA8tU() {
        return this.f591CQhlFr.AmA8tU();
    }

    @Override // AZkASS.AmA8tU
    public final boolean AzWtSf() {
        return this.f591CQhlFr.AzWtSf();
    }

    @Override // android.view.SubMenu
    public final MenuItem getItem() {
        return this.f592CSDoyG;
    }

    @Override // AZkASS.AmA8tU, android.view.Menu
    public final void setGroupDividerEnabled(boolean z) {
        this.f591CQhlFr.setGroupDividerEnabled(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(Drawable drawable) {
        BI9f7h(0, null, 0, drawable, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(CharSequence charSequence) {
        BI9f7h(0, charSequence, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderView(View view) {
        BI9f7h(0, null, 0, null, view);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(Drawable drawable) {
        this.f592CSDoyG.setIcon(drawable);
        return this;
    }

    @Override // AZkASS.AmA8tU, android.view.Menu
    public final void setQwertyMode(boolean z) {
        this.f591CQhlFr.setQwertyMode(z);
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderIcon(int i) {
        BI9f7h(0, null, i, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setHeaderTitle(int i) {
        BI9f7h(i, null, 0, null, null);
        return this;
    }

    @Override // android.view.SubMenu
    public final SubMenu setIcon(int i) {
        this.f592CSDoyG.setIcon(i);
        return this;
    }
}
