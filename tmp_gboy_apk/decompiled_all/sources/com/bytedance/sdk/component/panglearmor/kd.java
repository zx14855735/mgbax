package com.bytedance.sdk.component.panglearmor;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class kd {
    private static volatile boolean xj;

    private static void hf(Context context) {
        boolean z;
        Intent registerReceiver;
        double d = -0.1d;
        try {
            registerReceiver = context.registerReceiver(null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        } catch (Throwable unused) {
        }
        if (registerReceiver != null) {
            z = registerReceiver.getBooleanExtra("present", false);
            try {
                d = registerReceiver.getIntExtra("temperature", -1) / 10.0d;
            } catch (Throwable unused2) {
            }
            y.xj(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, new Object[]{Boolean.valueOf(z), Double.valueOf(d)});
        }
        z = true;
        y.xj(PluginConstants.ERROR_PLUGIN_SIGN_VERIFY, new Object[]{Boolean.valueOf(z), Double.valueOf(d)});
    }

    private static void kd(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
        y.xj(1009, new Object[]{Integer.valueOf(telephonyManager != null ? telephonyManager.getSimState() : -1)});
    }

    private static void u(Context context) {
        int i;
        Configuration configuration = context.getResources().getConfiguration();
        y.xj(1008, new Object[]{Boolean.valueOf(configuration == null || !((i = configuration.touchscreen) == 1 || i == 0))});
    }

    private static void w(Context context) {
        int i;
        int i2;
        CameraManager cameraManager = (CameraManager) context.getSystemService("camera");
        if (cameraManager != null) {
            try {
                i = 0;
                i2 = 0;
                for (String str : cameraManager.getCameraIdList()) {
                    int intValue = ((Integer) cameraManager.getCameraCharacteristics(str).get(CameraCharacteristics.LENS_FACING)).intValue();
                    if (intValue == 0) {
                        i++;
                    } else if (intValue == 1) {
                        i2++;
                    }
                }
            } catch (Throwable unused) {
                i = -1;
                i2 = -1;
            }
        } else {
            i = -2;
            i2 = -2;
        }
        y.xj(PluginConstants.ERROR_PLUGIN_FETCH, new Object[]{Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(i), Integer.valueOf(i2)});
    }

    public static void xj(Context context) {
        if (xj || context == null) {
            return;
        }
        hf(context);
        w(context);
        u(context);
        kd(context);
        xj = true;
    }
}
