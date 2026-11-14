package AZkASS;

import ADYaiT.CcAIMM;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.ActionProvider;
import android.view.CollapsibleActionView;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class B9tovu extends CcAIMM implements MenuItem {

    /* renamed from: AmA8tU, reason: collision with root package name */
    public final BniPrB.A2egSU f556AmA8tU;

    /* renamed from: AzWtSf, reason: collision with root package name */
    public Method f557AzWtSf;

    public B9tovu(Context context, BniPrB.A2egSU a2egSU) {
        super(context);
        if (a2egSU == null) {
            throw new IllegalArgumentException("Wrapped Object can not be null.");
        }
        this.f556AmA8tU = a2egSU;
    }

    @Override // android.view.MenuItem
    public final boolean collapseActionView() {
        return this.f556AmA8tU.collapseActionView();
    }

    @Override // android.view.MenuItem
    public final boolean expandActionView() {
        return this.f556AmA8tU.expandActionView();
    }

    @Override // android.view.MenuItem
    public final ActionProvider getActionProvider() {
        COJEAR.A5SV6n A4TApA2 = this.f556AmA8tU.A4TApA();
        if (A4TApA2 instanceof B2KMhB) {
            return ((B2KMhB) A4TApA2).f549A5SV6n;
        }
        return null;
    }

    @Override // android.view.MenuItem
    public final View getActionView() {
        View actionView = this.f556AmA8tU.getActionView();
        return actionView instanceof B3GDIM ? (View) ((B3GDIM) actionView).f551AcNBzu : actionView;
    }

    @Override // android.view.MenuItem
    public final int getAlphabeticModifiers() {
        return this.f556AmA8tU.getAlphabeticModifiers();
    }

    @Override // android.view.MenuItem
    public final char getAlphabeticShortcut() {
        return this.f556AmA8tU.getAlphabeticShortcut();
    }

    @Override // android.view.MenuItem
    public final CharSequence getContentDescription() {
        return this.f556AmA8tU.getContentDescription();
    }

    @Override // android.view.MenuItem
    public final int getGroupId() {
        return this.f556AmA8tU.getGroupId();
    }

    @Override // android.view.MenuItem
    public final Drawable getIcon() {
        return this.f556AmA8tU.getIcon();
    }

    @Override // android.view.MenuItem
    public final ColorStateList getIconTintList() {
        return this.f556AmA8tU.getIconTintList();
    }

    @Override // android.view.MenuItem
    public final PorterDuff.Mode getIconTintMode() {
        return this.f556AmA8tU.getIconTintMode();
    }

    @Override // android.view.MenuItem
    public final Intent getIntent() {
        return this.f556AmA8tU.getIntent();
    }

    @Override // android.view.MenuItem
    public final int getItemId() {
        return this.f556AmA8tU.getItemId();
    }

    @Override // android.view.MenuItem
    public final ContextMenu.ContextMenuInfo getMenuInfo() {
        return this.f556AmA8tU.getMenuInfo();
    }

    @Override // android.view.MenuItem
    public final int getNumericModifiers() {
        return this.f556AmA8tU.getNumericModifiers();
    }

    @Override // android.view.MenuItem
    public final char getNumericShortcut() {
        return this.f556AmA8tU.getNumericShortcut();
    }

    @Override // android.view.MenuItem
    public final int getOrder() {
        return this.f556AmA8tU.getOrder();
    }

    @Override // android.view.MenuItem
    public final SubMenu getSubMenu() {
        return this.f556AmA8tU.getSubMenu();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitle() {
        return this.f556AmA8tU.getTitle();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTitleCondensed() {
        return this.f556AmA8tU.getTitleCondensed();
    }

    @Override // android.view.MenuItem
    public final CharSequence getTooltipText() {
        return this.f556AmA8tU.getTooltipText();
    }

    @Override // android.view.MenuItem
    public final boolean hasSubMenu() {
        return this.f556AmA8tU.hasSubMenu();
    }

    @Override // android.view.MenuItem
    public final boolean isActionViewExpanded() {
        return this.f556AmA8tU.isActionViewExpanded();
    }

    @Override // android.view.MenuItem
    public final boolean isCheckable() {
        return this.f556AmA8tU.isCheckable();
    }

    @Override // android.view.MenuItem
    public final boolean isChecked() {
        return this.f556AmA8tU.isChecked();
    }

    @Override // android.view.MenuItem
    public final boolean isEnabled() {
        return this.f556AmA8tU.isEnabled();
    }

    @Override // android.view.MenuItem
    public final boolean isVisible() {
        return this.f556AmA8tU.isVisible();
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionProvider(ActionProvider actionProvider) {
        B2KMhB b2KMhB = new B2KMhB(this, (Context) this.f135AcNBzu, actionProvider);
        if (actionProvider == null) {
            b2KMhB = null;
        }
        this.f556AmA8tU.A2egSU(b2KMhB);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(View view) {
        if (view instanceof CollapsibleActionView) {
            view = new B3GDIM(view);
        }
        this.f556AmA8tU.setActionView(view);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c) {
        this.f556AmA8tU.setAlphabeticShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setCheckable(boolean z) {
        this.f556AmA8tU.setCheckable(z);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setChecked(boolean z) {
        this.f556AmA8tU.setChecked(z);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setContentDescription(CharSequence charSequence) {
        this.f556AmA8tU.setContentDescription(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setEnabled(boolean z) {
        this.f556AmA8tU.setEnabled(z);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(Drawable drawable) {
        this.f556AmA8tU.setIcon(drawable);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintList(ColorStateList colorStateList) {
        this.f556AmA8tU.setIconTintList(colorStateList);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIconTintMode(PorterDuff.Mode mode) {
        this.f556AmA8tU.setIconTintMode(mode);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIntent(Intent intent) {
        this.f556AmA8tU.setIntent(intent);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c) {
        this.f556AmA8tU.setNumericShortcut(c);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnActionExpandListener(MenuItem.OnActionExpandListener onActionExpandListener) {
        this.f556AmA8tU.setOnActionExpandListener(onActionExpandListener != null ? new B4ZgIw(this, onActionExpandListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setOnMenuItemClickListener(MenuItem.OnMenuItemClickListener onMenuItemClickListener) {
        this.f556AmA8tU.setOnMenuItemClickListener(onMenuItemClickListener != null ? new B7CMnp(this, onMenuItemClickListener) : null);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2) {
        this.f556AmA8tU.setShortcut(c, c2);
        return this;
    }

    @Override // android.view.MenuItem
    public final void setShowAsAction(int i) {
        this.f556AmA8tU.setShowAsAction(i);
    }

    @Override // android.view.MenuItem
    public final MenuItem setShowAsActionFlags(int i) {
        this.f556AmA8tU.setShowAsActionFlags(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(CharSequence charSequence) {
        this.f556AmA8tU.setTitle(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitleCondensed(CharSequence charSequence) {
        this.f556AmA8tU.setTitleCondensed(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTooltipText(CharSequence charSequence) {
        this.f556AmA8tU.setTooltipText(charSequence);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setVisible(boolean z) {
        return this.f556AmA8tU.setVisible(z);
    }

    @Override // android.view.MenuItem
    public final MenuItem setAlphabeticShortcut(char c, int i) {
        this.f556AmA8tU.setAlphabeticShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setIcon(int i) {
        this.f556AmA8tU.setIcon(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setNumericShortcut(char c, int i) {
        this.f556AmA8tU.setNumericShortcut(c, i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setShortcut(char c, char c2, int i, int i2) {
        this.f556AmA8tU.setShortcut(c, c2, i, i2);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setTitle(int i) {
        this.f556AmA8tU.setTitle(i);
        return this;
    }

    @Override // android.view.MenuItem
    public final MenuItem setActionView(int i) {
        BniPrB.A2egSU a2egSU = this.f556AmA8tU;
        a2egSU.setActionView(i);
        View actionView = a2egSU.getActionView();
        if (actionView instanceof CollapsibleActionView) {
            a2egSU.setActionView(new B3GDIM(actionView));
        }
        return this;
    }
}
