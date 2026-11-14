package com.bytedance.sdk.openadsdk.core.pl.u;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.bytedance.sdk.openadsdk.core.a.c;
import com.bytedance.sdk.openadsdk.core.pz;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class pl {
    public static void xj(Activity activity, final String[] strArr, final y yVar) {
        if (strArr != null && strArr.length > 0) {
            int length = strArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (com.kuaishou.weapon.p0.g.j.equalsIgnoreCase(strArr[i])) {
                    com.bytedance.sdk.openadsdk.zg.w.w.u v = com.bytedance.sdk.openadsdk.core.f.zg().v();
                    if (v != null && yVar != null && !v.kd()) {
                        yVar.xj(com.kuaishou.weapon.p0.g.j);
                        return;
                    }
                } else {
                    i++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23 && com.bytedance.sdk.openadsdk.core.f.xj.w(activity) < 23) {
            if (yVar != null) {
                yVar.xj();
                return;
            }
            return;
        }
        if (strArr == null || strArr.length <= 0) {
            if (yVar != null) {
                yVar.xj();
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
            if (TextUtils.equals(str2, com.kuaishou.weapon.p0.g.i) || TextUtils.equals(str2, com.kuaishou.weapon.p0.g.j)) {
                if (yVar != null) {
                    yVar.xj(str2);
                }
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(false, new String[]{str2});
                return;
            }
        }
        com.bytedance.sdk.openadsdk.core.a.c.xj(String.valueOf(hashCode), strArr, new c.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.u.pl.1
            @Override // com.bytedance.sdk.openadsdk.core.a.c.xj
            public void onDenied(String str3) {
                y yVar2 = y.this;
                if (yVar2 != null) {
                    yVar2.xj(str3);
                }
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(false, new String[]{str3});
            }

            @Override // com.bytedance.sdk.openadsdk.core.a.c.xj
            public void onGranted() {
                y yVar2 = y.this;
                if (yVar2 != null) {
                    yVar2.xj();
                }
                com.bytedance.sdk.openadsdk.core.ht.am.xj().xj(true, strArr);
            }
        });
    }

    public static boolean xj(Context context, String str) {
        com.bytedance.sdk.openadsdk.zg.w.w.u e;
        if (com.kuaishou.weapon.p0.g.j.equalsIgnoreCase(str) && (e = com.bytedance.sdk.openadsdk.core.f.zg().e()) != null && !e.kd()) {
            return false;
        }
        if (context == null) {
            context = pz.getContext();
        }
        return com.bytedance.sdk.openadsdk.core.io.kd.xj().xj(context, str);
    }
}
