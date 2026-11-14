package androidx.core.app;

import AaHO0E.D8MqeW;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import java.util.Arrays;
import java.util.HashSet;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class AYUAbz extends BPw6Q8.ASJ6gh {
    public static boolean ARc23Z(FragmentActivity fragmentActivity, String str) {
        int i = Build.VERSION.SDK_INT;
        if (i < 33 && TextUtils.equals("android.permission.POST_NOTIFICATIONS", str)) {
            return false;
        }
        if (i >= 32) {
            return ADYaiT.A2egSU(fragmentActivity, str);
        }
        if (i == 31) {
            return A5SV6n.A4TApA(fragmentActivity, str);
        }
        if (i >= 23) {
            return A4TApA.A4TApA(fragmentActivity, str);
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void requestPermissions(Activity activity, String[] strArr, int i) {
        HashSet hashSet = new HashSet();
        for (int i2 = 0; i2 < strArr.length; i2++) {
            if (TextUtils.isEmpty(strArr[i2])) {
                throw new IllegalArgumentException(ADYaiT.CtFAbx.B25kr6(new StringBuilder("Permission request for permissions "), Arrays.toString(strArr), " must not contain null or empty values"));
            }
            if (Build.VERSION.SDK_INT < 33 && TextUtils.equals(strArr[i2], "android.permission.POST_NOTIFICATIONS")) {
                hashSet.add(Integer.valueOf(i2));
            }
        }
        int size = hashSet.size();
        String[] strArr2 = size > 0 ? new String[strArr.length - size] : strArr;
        if (size > 0) {
            if (size == strArr.length) {
                return;
            }
            int i3 = 0;
            for (int i4 = 0; i4 < strArr.length; i4++) {
                if (!hashSet.contains(Integer.valueOf(i4))) {
                    strArr2[i3] = strArr[i4];
                    i3++;
                }
            }
        }
        if (Build.VERSION.SDK_INT >= 23) {
            if (activity instanceof ARc23Z) {
                ((ARc23Z) activity).validateRequestPermissionsRequestCode(i);
            }
            A4TApA.requestPermissions(activity, strArr, i);
        } else if (activity instanceof AMqCpz) {
            new Handler(Looper.getMainLooper()).post(new D8MqeW(i, 7, strArr2, activity));
        }
    }

    public static void startActivityForResult(Activity activity, Intent intent, int i, Bundle bundle) {
        activity.startActivityForResult(intent, i, bundle);
    }
}
