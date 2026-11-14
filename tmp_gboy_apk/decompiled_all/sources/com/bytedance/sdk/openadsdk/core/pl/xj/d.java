package com.bytedance.sdk.openadsdk.core.pl.xj;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.downloadnew.core.ITTPermissionCallback;
import com.kuaishou.weapon.p0.g;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class d {
    public static boolean hasPermission(Context context, String str) {
        com.bytedance.sdk.openadsdk.zg.w.w.u e;
        if (g.j.equalsIgnoreCase(str) && (e = com.bytedance.sdk.openadsdk.core.f.zg().e()) != null && !e.kd()) {
            return false;
        }
        if (context == null) {
            context = pz.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(context, str);
    }

    public static void requestPermission(Activity activity, final String[] strArr, final ITTPermissionCallback iTTPermissionCallback) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (g.j.equalsIgnoreCase(strArr[i])) {
                    com.bytedance.sdk.openadsdk.zg.w.w.u v = com.bytedance.sdk.openadsdk.core.f.zg().v();
                    if (v != null && iTTPermissionCallback != null && !v.kd()) {
                        iTTPermissionCallback.onDenied(g.j);
                        return;
                    }
                } else {
                    i++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.bytedance.sdk.openadsdk.core.f.xj.w(activity) < 23) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (iTTPermissionCallback != null) {
                iTTPermissionCallback.onGranted();
                return;
            }
            return;
        }
        long hashCode = activity.hashCode();
        for (String str : strArr) {
            hashCode += str.hashCode();
        }
        if (activity.getApplicationInfo().targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && strArr.length == 1) {
            String str2 = strArr[0];
            if (TextUtils.equals(str2, g.i) || TextUtils.equals(str2, g.j)) {
                if (iTTPermissionCallback != null) {
                    iTTPermissionCallback.onDenied(str2);
                }
                am.xj().xj(false, new String[]{str2});
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.a.c.xj(String.valueOf(hashCode), strArr, new c.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.xj.d.1
            @Override // com.bytedance.sdk.openadsdk.core.a.c.xj
            public void onDenied(String str3) {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onDenied(str3);
                }
                am.xj().xj(false, new String[]{str3});
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.c.xj
            public void onGranted() {
                ITTPermissionCallback iTTPermissionCallback2 = iTTPermissionCallback;
                if (iTTPermissionCallback2 != null) {
                    iTTPermissionCallback2.onGranted();
                }
                am.xj().xj(true, strArr);
            }
        });
    }
}
