package com.bytedance.sdk.openadsdk.core.io;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.sdk.component.utils.pl;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        if (Build.VERSION.SDK_INT >= 23) {
            activity.requestPermissions(strArr, i);
        }
    }

    public static int xj(Context context, String str) {
        if (str == null) {
            throw new IllegalArgumentException("permission is null");
        }
        try {
            return context.checkPermission(str, Process.myPid(), Process.myUid());
        } catch (Throwable th) {
            pl.xj(th);
            return Build.VERSION.SDK_INT >= 23 ? -1 : 0;
        }
    }
}
