package AZkASS;

import android.view.MenuItem;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B4ZgIw implements MenuItem.OnActionExpandListener {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final MenuItem.OnActionExpandListener f552A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final /* synthetic */ B9tovu f553A4TApA;

    public B4ZgIw(B9tovu b9tovu, MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f553A4TApA = b9tovu;
        this.f552A2egSU = onActionExpandListener;
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionCollapse(MenuItem menuItem) {
        return this.f552A2egSU.onMenuItemActionCollapse(this.f553A4TApA.ASJ6gh(menuItem));
    }

    @Override // android.view.MenuItem.OnActionExpandListener
    public final boolean onMenuItemActionExpand(MenuItem menuItem) {
        return this.f552A2egSU.onMenuItemActionExpand(this.f553A4TApA.ASJ6gh(menuItem));
    }
}
