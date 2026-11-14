package com.qq.e.comm;

import android.content.Context;
import android.content.Intent;
import com.kuaishou.weapon.p0.g;
import com.qq.e.comm.constants.CustomPkgConstants;
import com.qq.e.comm.util.GDTLogger;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class a {
    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A2egSU(Context context, Class... clsArr) {
        for (int i = 0; i < clsArr.length; i++) {
            try {
                Intent intent = new Intent();
                intent.setClass(context, clsArr[i]);
                if (context.getPackageManager().resolveActivity(intent, 65536) == null) {
                    GDTLogger.e("Activity[" + clsArr[i].getName() + "]需要在AndroidManifest.xml中声明");
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查Activity时发生异常", th);
                return false;
            }
        }
        return true;
    }

    public static boolean A4TApA(Context context) {
        String[] strArr = {g.f12282a, g.b};
        for (int i = 0; i < 2; i++) {
            try {
                String str = strArr[i];
                if (context.checkCallingOrSelfPermission(str) == -1) {
                    GDTLogger.e("Permission[" + str + "]需要在AndroidManifest.xml中声明");
                    return false;
                }
            } catch (Throwable th) {
                GDTLogger.e("检查权限时发生异常", th);
                return false;
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static boolean A5SV6n(Context context, Class... clsArr) {
        try {
            for (Class cls : clsArr) {
                Intent intent = new Intent();
                intent.setClass(context, cls);
                if (context.getPackageManager().resolveService(intent, 65536) == null) {
                    GDTLogger.e("Service[" + cls.getName() + "]需要在AndroidManifest.xml中声明");
                    return false;
                }
            }
            return true;
        } catch (Throwable th) {
            GDTLogger.e("检查Service时发生异常", th);
            return false;
        }
    }

    public static boolean a(Context context) {
        try {
            if (A4TApA(context) && A2egSU(context, Class.forName(CustomPkgConstants.getADActivityName())) && A2egSU(context, Class.forName(CustomPkgConstants.getPortraitADActivityName())) && A2egSU(context, Class.forName(CustomPkgConstants.getLandscapeADActivityName()))) {
                if (A5SV6n(context, Class.forName(CustomPkgConstants.getDownLoadServiceName()))) {
                    return true;
                }
            }
            return false;
        } catch (Throwable th) {
            GDTLogger.e("检查AndroidManifest.xml时发生异常", th);
            return false;
        }
    }
}
