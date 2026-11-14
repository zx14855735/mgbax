package AZkASS;

import android.R;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class A2egSU implements BniPrB.A2egSU {

    /* renamed from: AcNBzu, reason: collision with root package name */
    public CharSequence f416AcNBzu;

    /* renamed from: AlLFFp, reason: collision with root package name */
    public CharSequence f417AlLFFp;

    /* renamed from: AmA8tU, reason: collision with root package name */
    public Intent f418AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public char f419AzWtSf;

    /* renamed from: B25kr6, reason: collision with root package name */
    public int f420B25kr6;

    /* renamed from: B2KMhB, reason: collision with root package name */
    public char f421B2KMhB;

    /* renamed from: B3GDIM, reason: collision with root package name */
    public int f422B3GDIM;

    /* renamed from: B4ZgIw, reason: collision with root package name */
    public Drawable f423B4ZgIw;

    /* renamed from: B7CMnp, reason: collision with root package name */
    public Context f424B7CMnp;

    /* renamed from: B9tovu, reason: collision with root package name */
    public CharSequence f425B9tovu;

    /* renamed from: BChYOn, reason: collision with root package name */
    public CharSequence f426BChYOn;

    /* renamed from: BI9f7h, reason: collision with root package name */
    public ColorStateList f427BI9f7h;

    /* renamed from: BIYEnU, reason: collision with root package name */
    public PorterDuff.Mode f428BIYEnU;

    /* renamed from: BJ7GGh, reason: collision with root package name */
    public boolean f429BJ7GGh;

    /* renamed from: BNL6CD, reason: collision with root package name */
    public boolean f430BNL6CD;

    /* renamed from: BPw6Q8, reason: collision with root package name */
    public int f431BPw6Q8;

    @Override // BniPrB.A2egSU
    public final BniPrB.A2egSU A2egSU(COJEAR.A5SV6n a5SV6n) {
        throw new UnsupportedOperationException();
    }

    @Override // BniPrB.A2egSU
    public final COJEAR.A5SV6n A4TApA() {
        return null;
    }

    public final void A5SV6n() {
        Drawable drawable = this.f423B4ZgIw;
        if (drawable != null) {
            if (this.f429BJ7GGh || this.f430BNL6CD) {
                Drawable DvK7DB2 = com.bumptech.glide.A5SV6n.DvK7DB(drawable);
                this.f423B4ZgIw = DvK7DB2;
                Drawable mutate = DvK7DB2.mutate();
                this.f423B4ZgIw = mutate;
                if (this.f429BJ7GGh) {
                    BmvVmW.A2egSU.AYUAbz(mutate, this.f427BI9f7h);
                }
                if (this.f430BNL6CD) {
                    BmvVmW.A2egSU.AZOQYO(this.f423B4ZgIw, this.f428BIYEnU);
                }
            }
        }
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return false;
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        return null;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f422B3GDIM;
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f421B2KMhB;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f425B9tovu;
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f423B4ZgIw;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f427BI9f7h;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f428BIYEnU;
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f418AmA8tU;
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return R.id.home;
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return null;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f420B25kr6;
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f419AzWtSf;
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return 0;
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return null;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f416AcNBzu;
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        CharSequence charSequence = this.f417AlLFFp;
        return charSequence != null ? charSequence : this.f416AcNBzu;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f426BChYOn;
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return false;
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return (this.f431BPw6Q8 & 1) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return (this.f431BPw6Q8 & 2) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return (this.f431BPw6Q8 & 16) != 0;
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return (this.f431BPw6Q8 & 8) == 0;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.f421B2KMhB = Character.toLowerCase(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.f431BPw6Q8 = (z ? 1 : 0) | (this.f431BPw6Q8 & (-2));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.f431BPw6Q8 = (z ? 2 : 0) | (this.f431BPw6Q8 & (-3));
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final BniPrB.A2egSU setContentDescription(CharSequence charSequence) {
        this.f425B9tovu = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.f431BPw6Q8 = (z ? 16 : 0) | (this.f431BPw6Q8 & (-17));
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f423B4ZgIw = drawable;
        A5SV6n();
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f427BI9f7h = colorStateList;
        this.f429BJ7GGh = true;
        A5SV6n();
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f428BIYEnU = mode;
        this.f430BNL6CD = true;
        A5SV6n();
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f418AmA8tU = intent;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.f419AzWtSf = c;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        throw new UnsupportedOperationException();
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.f419AzWtSf = c;
        this.f421B2KMhB = Character.toLowerCase(c2);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f416AcNBzu = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f417AlLFFp = charSequence;
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final BniPrB.A2egSU setTooltipText(CharSequence charSequence) {
        this.f426BChYOn = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        this.f431BPw6Q8 = (this.f431BPw6Q8 & 8) | (z ? 0 : 8);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        throw new UnsupportedOperationException();
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.f421B2KMhB = Character.toLowerCase(c);
        this.f422B3GDIM = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f425B9tovu = charSequence;
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        this.f419AzWtSf = c;
        this.f420B25kr6 = KeyEvent.normalizeMetaState(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.f416AcNBzu = this.f424B7CMnp.getResources().getString(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f426BChYOn = charSequence;
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f423B4ZgIw = BPw6Q8.A2egSU.A4TApA(this.f424B7CMnp, i);
        A5SV6n();
        return this;
    }

    @Override // BniPrB.A2egSU, android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f419AzWtSf = c;
        this.f420B25kr6 = KeyEvent.normalizeMetaState(i);
        this.f421B2KMhB = Character.toLowerCase(c2);
        this.f422B3GDIM = KeyEvent.normalizeMetaState(i2);
        return this;
    }
}
