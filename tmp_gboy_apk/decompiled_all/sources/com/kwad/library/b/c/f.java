package com.kwad.library.b.c;

import AZOQYO.ADYaiT;
import android.annotation.SuppressLint;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.res.Resources;
import com.kwad.sdk.utils.z;

@SuppressLint({"RestrictedApi"})
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class f extends ADYaiT implements d {
    private String aun;
    private Resources.Theme auw;
    private int aux;
    private final ADYaiT auy;

    public f(ADYaiT aDYaiT, String str) {
        super(aDYaiT, aDYaiT.getThemeResId());
        this.auy = aDYaiT;
        this.aun = str;
        try {
            Object a2 = z.a((Object) aDYaiT, "android.view.ContextThemeWrapper", "getThemeResId");
            if (a2 != null) {
                this.aux = ((Integer) a2).intValue();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final Context getApplicationContext() {
        return c.l(this.auy.getApplicationContext(), this.aun);
    }

    @Override // android.content.ContextWrapper
    public final Context getBaseContext() {
        return this.auy;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final ClassLoader getClassLoader() {
        return c.a(super.getClassLoader(), this.aun);
    }

    @Override // com.kwad.library.b.c.d
    public final Context getDelegatedContext() {
        return this.auy;
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final Resources getResources() {
        return c.a(this.auy.getResources(), this.aun);
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final Object getSystemService(String str) {
        return c.wrapSystemService(this.auy.getSystemService(str), str, this);
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
            this.auw = c.a(theme, theme2, this.aux, this.aun);
        }
        return this.auw;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.auy.registerComponentCallbacks(componentCallbacks);
    }

    @Override // AZOQYO.ADYaiT, android.content.ContextWrapper, android.content.Context
    public final void setTheme(int i) {
        this.aux = i;
        super.setTheme(i);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public final void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        this.auy.unregisterComponentCallbacks(componentCallbacks);
    }
}
