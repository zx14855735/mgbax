package com.bytedance.pangle;

import A5SV6n.A2egSU;
import AZOQYO.ADYaiT;
import android.content.ComponentCallbacks;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.ApplicationInfo;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.wrapper.PluginApplicationWrapper;

@A2egSU
/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class PluginContext extends c {
    private LayoutInflater mInflater;
    public boolean mIsHostApplicationContext;
    public Context mOriginContext;
    private Configuration mOverrideConfiguration;
    public Plugin mPlugin;

    public PluginContext() {
    }

    public static Context getContextWithoutTheme(Context context) {
        return context instanceof ContextThemeWrapper ? getContextWithoutTheme(((ContextThemeWrapper) context).getBaseContext()) : context instanceof ADYaiT ? getContextWithoutTheme(((ADYaiT) context).getBaseContext()) : context;
    }

    private Resources getResourcesInternal() {
        return this.mPlugin.mResources;
    }

    public static int getThemeResourceId(Context context) {
        if (context instanceof ContextThemeWrapper) {
            try {
                return ((Integer) FieldUtils.readField(context, "mThemeResource")).intValue();
            } catch (IllegalAccessException e) {
                com.bytedance.sdk.openadsdk.api.y.xj(e);
            }
        }
        if (context instanceof ADYaiT) {
            return ((ADYaiT) context).getThemeResId();
        }
        return 0;
    }

    @Override // android.view.ContextThemeWrapper
    public void applyOverrideConfiguration(Configuration configuration) {
        if (this.mPlugin.mResources != null) {
            throw new IllegalStateException("getResources() or getAssets() has already been called");
        }
        if (this.mOverrideConfiguration != null) {
            throw new IllegalStateException("Override configuration has already been set");
        }
        this.mOverrideConfiguration = new Configuration(configuration);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        Context createConfigurationContext = super.createConfigurationContext(configuration);
        try {
            try {
                FieldUtils.writeField(createConfigurationContext, "mResources", this.mPlugin.mResources);
                return createConfigurationContext;
            } catch (Throwable th) {
                com.bytedance.sdk.openadsdk.api.y.xj(th);
                return createConfigurationContext;
            }
        } catch (Throwable unused) {
            com.bytedance.pangle.hf.hf.xj.xj(createConfigurationContext.getClass(), "mResources").set(createConfigurationContext, this.mPlugin.mResources);
            return createConfigurationContext;
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public Context getApplicationContext() {
        Context context = this.mOriginContext;
        return context instanceof PluginApplicationWrapper ? context : ZeusTransformUtils.wrapperContext(context.getApplicationContext(), this.mPlugin.mPkgName);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return this.mPlugin.mHostApplicationInfoHookSomeField;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public AssetManager getAssets() {
        return this.mPlugin.mResources.getAssets();
    }

    @Override // android.content.ContextWrapper
    public Context getBaseContext() {
        Context baseContext = super.getBaseContext();
        return baseContext instanceof ContextWrapper ? ((ContextWrapper) baseContext).getBaseContext() : baseContext;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mPlugin.mClassLoader;
    }

    public Configuration getOverrideConfiguration() {
        return this.mOverrideConfiguration;
    }

    public String getPluginPackageName() {
        return this.mPlugin.mPkgName;
    }

    @Override // com.bytedance.pangle.c
    public String getPluginPkg() {
        return this.mPlugin.mPkgName;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Resources getResources() {
        return this.mPlugin.mResources;
    }

    @Override // android.view.ContextThemeWrapper, android.content.ContextWrapper, android.content.Context
    public Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            Context context = this.mOriginContext;
            return context != null ? context.getSystemService(str) : getBaseContext().getSystemService(str);
        }
        if (this.mInflater == null) {
            LayoutInflater cloneInContext = LayoutInflater.from(getBaseContext()).cloneInContext(this);
            this.mInflater = cloneInContext;
            com.bytedance.pangle.res.hf.xj(cloneInContext);
        }
        return this.mInflater;
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void registerComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.registerComponentCallbacks(componentCallbacks);
        } else {
            super.registerComponentCallbacks(componentCallbacks);
        }
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public void unregisterComponentCallbacks(ComponentCallbacks componentCallbacks) {
        if (this.mIsHostApplicationContext) {
            this.mOriginContext.unregisterComponentCallbacks(componentCallbacks);
        } else {
            super.unregisterComponentCallbacks(componentCallbacks);
        }
    }

    public PluginContext(Context context, Plugin plugin, boolean z) {
        super(getContextWithoutTheme(context), getThemeResourceId(context));
        this.mPlugin = plugin;
        this.mOriginContext = context;
        this.mIsHostApplicationContext = z;
    }
}
