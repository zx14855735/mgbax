package P8ccfD;

import android.content.res.ColorStateList;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.search.SearchBar;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class A4TApA extends AppBarLayout.A5SV6n {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final /* synthetic */ SearchBar f6961A2egSU;

    public A4TApA(SearchBar searchBar) {
        this.f6961A2egSU = searchBar;
    }

    @Override // com.google.android.material.appbar.AppBarLayout.A5SV6n
    public final void A2egSU(float f) {
        SearchBar searchBar = this.f6961A2egSU;
        ColorStateList colorStateList = searchBar.f11741DaOi9o;
        if (colorStateList != null) {
            searchBar.f11752EH1KK8.B3GDIM(ColorStateList.valueOf(OLy1FW.AYUAbz.AaHO0E(f, searchBar.f11740DXnQ0V, colorStateList.getDefaultColor())));
        }
    }
}
