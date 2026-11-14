package com.bytedance.pangle;

import A5SV6n.A2egSU;
import android.app.Application;
import android.content.Context;
import com.bytedance.pangle.plugin.Plugin;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class ZeusApplication extends PluginContext {
    Application mHostApplication;

    public void attach(Plugin plugin, Application application) {
        this.mPlugin = plugin;
        this.mHostApplication = application;
        attachBaseContext(application);
        onCreate();
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper
    public void attachBaseContext(Context context) {
        super.attachBaseContext(context);
    }

    public void onCreate() {
    }
}
