package AZOQYO;

import AZkASS.BV3sI0;
import android.content.Context;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class ASJ6gh extends ActionMode {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final Context f367A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final A4TApA f368A4TApA;

    public ASJ6gh(Context context, A4TApA a4TApA) {
        this.f367A2egSU = context;
        this.f368A4TApA = a4TApA;
    }

    @Override // android.view.ActionMode
    public final void finish() {
        this.f368A4TApA.A2egSU();
    }

    @Override // android.view.ActionMode
    public final View getCustomView() {
        return this.f368A4TApA.A4TApA();
    }

    @Override // android.view.ActionMode
    public final Menu getMenu() {
        return new BV3sI0(this.f367A2egSU, this.f368A4TApA.A5SV6n());
    }

    @Override // android.view.ActionMode
    public final MenuInflater getMenuInflater() {
        return this.f368A4TApA.ADYaiT();
    }

    @Override // android.view.ActionMode
    public final CharSequence getSubtitle() {
        return this.f368A4TApA.AMqCpz();
    }

    @Override // android.view.ActionMode
    public final Object getTag() {
        return this.f368A4TApA.f351AcNBzu;
    }

    @Override // android.view.ActionMode
    public final CharSequence getTitle() {
        return this.f368A4TApA.ARc23Z();
    }

    @Override // android.view.ActionMode
    public final boolean getTitleOptionalHint() {
        return this.f368A4TApA.f352AlLFFp;
    }

    @Override // android.view.ActionMode
    public final void invalidate() {
        this.f368A4TApA.ASJ6gh();
    }

    @Override // android.view.ActionMode
    public final boolean isTitleOptional() {
        return this.f368A4TApA.AYUAbz();
    }

    @Override // android.view.ActionMode
    public final void setCustomView(View view) {
        this.f368A4TApA.AZOQYO(view);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(CharSequence charSequence) {
        this.f368A4TApA.AlLFFp(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTag(Object obj) {
        this.f368A4TApA.f351AcNBzu = obj;
    }

    @Override // android.view.ActionMode
    public final void setTitle(CharSequence charSequence) {
        this.f368A4TApA.AzWtSf(charSequence);
    }

    @Override // android.view.ActionMode
    public final void setTitleOptionalHint(boolean z) {
        this.f368A4TApA.B25kr6(z);
    }

    @Override // android.view.ActionMode
    public final void setSubtitle(int i) {
        this.f368A4TApA.AaHO0E(i);
    }

    @Override // android.view.ActionMode
    public final void setTitle(int i) {
        this.f368A4TApA.AmA8tU(i);
    }
}
