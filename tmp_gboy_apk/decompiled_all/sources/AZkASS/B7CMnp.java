package AZkASS;

import android.view.MenuItem;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B7CMnp implements MenuItem.OnMenuItemClickListener {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public final MenuItem.OnMenuItemClickListener f554AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public final /* synthetic */ B9tovu f555AlLFFp;

    public B7CMnp(B9tovu b9tovu, MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f555AlLFFp = b9tovu;
        this.f554AcNBzu = onMenuItemClickListener;
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public final boolean onMenuItemClick(MenuItem menuItem) {
        return this.f554AcNBzu.onMenuItemClick(this.f555AlLFFp.ASJ6gh(menuItem));
    }
}
