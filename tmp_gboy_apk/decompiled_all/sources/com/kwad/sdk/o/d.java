package com.kwad.sdk.o;

import AZOQYO.ADYaiT;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
final class d extends ADYaiT implements b {
    private Resources.Theme auw;
    private int aux;
    private final ADYaiT biP;
    private LayoutInflater mInflater;

    public d(ADYaiT aDYaiT) {
        super(aDYaiT, aDYaiT.getThemeResId());
        this.biP = aDYaiT;
        this.aux = m.getThemeResId(aDYaiT);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return j.wrapContextIfNeed(this.biP.getApplicationContext());
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return super.getBaseContext();
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return j.replaceExternalClassLoader(super.getClassLoader());
    }

    @Override // com.kwad.sdk.o.b
    public final Context getDelegatedContext() {
        return this.biP;
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return f.UK().getResources();
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return this.biP.getSystemService(str);
        }
        if (this.mInflater == null) {
            this.mInflater = m.a(this.biP, this);
        }
        return this.mInflater;
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final Resources.Theme getTheme() {
        Resources.Theme theme;
        try {
            theme = super.getTheme();
        } catch (Exception e) {
            e.printStackTrace();
            theme = null;
        }
        Resources.Theme theme2 = this.auw;
        if (theme2 == null || theme2 == theme) {
            this.auw = j.replaceTheme(theme, theme2, this.aux);
        }
        return this.auw;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.biP.registerComponentCallbacks(componentCallbacks);
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aux = i;
        super.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.biP.unregisterComponentCallbacks(componentCallbacks);
    }
}
