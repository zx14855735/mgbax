package com.bytedance.sdk.openadsdk.x;

import android.content.Context;
import android.os.Build;
import android.telephony.ServiceState;
import android.telephony.SubscriptionManager;
import android.telephony.TelephonyManager;
import com.bytedance.sdk.component.utils.qt;
import com.kuaishou.weapon.p0.g;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements qt {
    private static boolean hf(Context context, TelephonyManager telephonyManager) {
        int checkSelfPermission;
        ServiceState serviceState;
        if (context != null && Build.VERSION.SDK_INT >= 29) {
            checkSelfPermission = context.checkSelfPermission(g.c);
            if (checkSelfPermission == 0) {
                try {
                    int xj = xj();
                    if (xj == -1) {
                        serviceState = telephonyManager.getServiceState();
                    } else {
                        Method declaredMethod = TelephonyManager.class.getDeclaredMethod("getServiceStateForSubscriber", Integer.TYPE);
                        declaredMethod.setAccessible(true);
                        serviceState = (ServiceState) declaredMethod.invoke(telephonyManager, Integer.valueOf(xj));
                    }
                    return xj(serviceState);
                } catch (Exception unused) {
                }
            }
        }
        return false;
    }

    @Override // com.bytedance.sdk.component.utils.qt
    public boolean xj(Context context, TelephonyManager telephonyManager) {
        return hf(context, telephonyManager);
    }

    private static int xj() {
        int defaultDataSubscriptionId;
        if (Build.VERSION.SDK_INT < 24) {
            return -1;
        }
        defaultDataSubscriptionId = SubscriptionManager.getDefaultDataSubscriptionId();
        return defaultDataSubscriptionId;
    }

    private static boolean xj(ServiceState serviceState) {
        try {
            Method method = serviceState.getClass().getMethod("getNrState", new Class[0]);
            if (method != null) {
                method.setAccessible(true);
                int intValue = ((Integer) method.invoke(serviceState, new Object[0])).intValue();
                return intValue == 3 || intValue == 2;
            }
        } catch (Exception unused) {
        }
        return false;
    }
}
