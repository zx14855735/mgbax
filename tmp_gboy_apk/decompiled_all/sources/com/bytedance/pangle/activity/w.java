package com.bytedance.pangle.activity;

import ADYaiT.D07BeM;
import android.R;
import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.pangle.ComponentManager;
import com.bytedance.pangle.Zeus;
import com.bytedance.pangle.log.ZeusLogger;
import com.bytedance.pangle.plugin.Plugin;
import com.bytedance.pangle.plugin.PluginManager;
import com.bytedance.pangle.transform.ZeusTransformUtils;
import com.bytedance.pangle.util.FieldUtils;
import com.bytedance.pangle.util.MethodUtils;
import com.bytedance.sdk.openadsdk.api.y;
import java.util.List;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class w {
    /* JADX WARN: Multi-variable type inference failed */
    public static void xj(hf hfVar, Bundle bundle) {
        List<String> list;
        if (!Zeus.hasInit()) {
            y.kd(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. AppApplication == null.");
            hfVar.zeusSuperOnCreate(null);
            hfVar.finish();
            return;
        }
        Intent intent = hfVar.getIntent();
        String pluginPkgName = hfVar.getPluginPkgName();
        Plugin plugin = hfVar.getPlugin();
        if (plugin == null) {
            y.kd(ZeusLogger.TAG_INIT, "ProxyActivityUtils.onCreate finish. plugin == null");
            hfVar.zeusSuperOnCreate(null);
            hfVar.finish();
            return;
        }
        intent.setExtrasClassLoader(plugin.mClassLoader);
        IntentUtils.xj(intent);
        String stringExtra = intent.getStringExtra("targetPlugin");
        if (TextUtils.isEmpty(stringExtra) && (list = ComponentManager.stubActivity2TargetActivities.get(hfVar.getClass().getName())) != null && list.size() == 1) {
            stringExtra = list.get(0);
            intent.putExtra("targetPlugin", stringExtra);
        }
        if (!plugin.isLoaded() || TextUtils.isEmpty(stringExtra)) {
            try {
                hfVar.zeusSuperOnCreate(null);
                ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Cant start pluginActivity, plugin load failed! pluginPkgName: " + pluginPkgName + " targetActivity: " + stringExtra);
                hfVar.finish();
                return;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
        ActivityInfo activityInfo = plugin.pluginActivities.get(stringExtra);
        if (activityInfo == null) {
            ZeusLogger.w(ZeusLogger.TAG_ACTIVITY, "Have you declared " + stringExtra + " in plugin's AndroidManifest.xml!");
            hfVar.zeusSuperOnCreate(null);
            hfVar.finish();
        }
        int i = -1;
        try {
            IPluginActivity iPluginActivity = (IPluginActivity) plugin.mClassLoader.loadClass(stringExtra).newInstance();
            FieldUtils.writeField(iPluginActivity, "mApplication", hfVar.getApplication());
            hfVar.setTargetActivity(iPluginActivity);
            iPluginActivity.setPluginProxyActivity(hfVar, plugin);
            i = activityInfo.theme;
            hfVar.zeusSuperSetTheme(i);
            TypedArray obtainStyledAttributes = ((Activity) hfVar).getTheme().obtainStyledAttributes(new int[]{R.attr.windowIsTranslucent});
            if (obtainStyledAttributes.getBoolean(obtainStyledAttributes.getIndex(0), false)) {
                xj((Activity) hfVar);
            }
            obtainStyledAttributes.recycle();
            iPluginActivity.attachBaseContext(hfVar.getBaseContext());
            try {
                int requestedOrientation = ((Activity) hfVar).getRequestedOrientation();
                int i2 = activityInfo.screenOrientation;
                if (requestedOrientation != i2) {
                    ((Activity) hfVar).setRequestedOrientation(i2);
                }
            } catch (IllegalStateException unused) {
            }
            iPluginActivity.onCreate(bundle);
        } catch (Exception e2) {
            throw new RuntimeException(e2 instanceof IllegalStateException ? "activityTheme:".concat(String.valueOf(i)) : "", e2);
        }
    }

    public static void xj(hf hfVar, Context context) {
        if (!Zeus.hasInit()) {
            y.kd(ZeusLogger.TAG_INIT, "ProxyActivityUtils.attachBaseContext. AppApplication == null.");
            hfVar.zeusSuperAttachBaseContext(context);
            return;
        }
        String pluginPkgName = hfVar.getPluginPkgName();
        boolean loadPlugin = PluginManager.getInstance().loadPlugin(pluginPkgName);
        try {
            hfVar.setPlugin(PluginManager.getInstance().getPlugin(pluginPkgName));
            if (loadPlugin) {
                hfVar.zeusSuperAttachBaseContext(ZeusTransformUtils.wrapperContext(context, pluginPkgName));
                FieldUtils.writeField(hfVar, "mResources", (Object) null);
            } else {
                hfVar.zeusSuperAttachBaseContext(context);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void xj(Activity activity, View view) {
        Object readField;
        if (view == null) {
            return;
        }
        try {
            Object readField2 = FieldUtils.readField(view, "mListenerInfo");
            if (readField2 != null && (readField = FieldUtils.readField(readField2, "mOnClickListener")) != null) {
                String name = readField.getClass().getName();
                if (!name.startsWith(D07BeM.class.getName())) {
                    if (name.startsWith(View.class.getName())) {
                    }
                }
                view.setOnClickListener(new xj(activity, view.getId(), (String) FieldUtils.readField(readField, "mMethodName")));
            }
        } catch (Exception e) {
            ZeusLogger.errReport(ZeusLogger.TAG_ACTIVITY, "checkOnClickListener failed!".concat(String.valueOf(view)));
            y.xj(e);
        }
        if (!(view instanceof ViewGroup)) {
            return;
        }
        int i = 0;
        while (true) {
            ViewGroup viewGroup = (ViewGroup) view;
            if (i >= viewGroup.getChildCount()) {
                return;
            }
            xj(activity, viewGroup.getChildAt(i));
            i++;
        }
    }

    private static Class xj() {
        Class<?> cls = null;
        for (Class<?> cls2 : Activity.class.getDeclaredClasses()) {
            if (cls2.getSimpleName().contains("TranslucentConversionListener")) {
                cls = cls2;
            }
        }
        return cls;
    }

    private static void xj(Activity activity) {
        try {
            MethodUtils.getAccessibleMethod(Activity.class, "convertToTranslucent", xj(), ActivityOptions.class).invoke(activity, null, MethodUtils.getAccessibleMethod(Activity.class, "getActivityOptions", new Class[0]).invoke(activity, new Object[0]));
        } catch (Throwable unused) {
        }
    }
}
