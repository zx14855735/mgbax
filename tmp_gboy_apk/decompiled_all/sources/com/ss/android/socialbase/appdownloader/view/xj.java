package com.ss.android.socialbase.appdownloader.view;

import android.app.Fragment;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.ss.android.socialbase.appdownloader.kd.u;
import com.ss.android.socialbase.downloader.constants.kd;
import com.ss.android.socialbase.downloader.downloader.w;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class xj extends Fragment {
    private Context kd() {
        Context tj = w.tj();
        return (tj != null || getActivity() == null || getActivity().isFinishing()) ? tj : getActivity().getApplicationContext();
    }

    public static Intent u() {
        return new Intent("android.settings.APPLICATION_SETTINGS");
    }

    private Intent y() {
        Context kd = kd();
        if (kd == null) {
            return null;
        }
        Intent intent = new Intent("android.settings.APP_NOTIFICATION_SETTINGS");
        String packageName = kd.getPackageName();
        intent.putExtra("package", packageName);
        intent.putExtra("android.provider.extra.APP_PACKAGE", packageName);
        intent.putExtra("app_package", packageName);
        int i = kd.getApplicationInfo().uid;
        intent.putExtra("uid", i);
        intent.putExtra("app_uid", i);
        return intent;
    }

    public Intent hf() {
        Context kd = kd();
        if (kd == null) {
            return null;
        }
        String packageName = kd.getPackageName();
        String str = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(str)) {
            String lowerCase = str.toLowerCase();
            if (lowerCase.contains(kd.w)) {
                Intent intent = new Intent();
                intent.putExtra("packageName", packageName);
                intent.setComponent(new ComponentName("com.color.safecenter", "com.color.safecenter.permission.PermissionManagerActivity"));
                return intent;
            }
            if (lowerCase.contains("vivo")) {
                Intent intent2 = new Intent();
                intent2.putExtra("packagename", packageName);
                if (Build.VERSION.SDK_INT >= 25) {
                    intent2.setComponent(new ComponentName("com.vivo.permissionmanager", "com.vivo.permissionmanager.activity.SoftPermissionDetailActivity"));
                    return intent2;
                }
                intent2.setComponent(new ComponentName("com.iqoo.secure", "com.iqoo.secure.safeguard.SoftPermissionDetailActivity"));
                return intent2;
            }
            if (lowerCase.contains("meizu") && Build.VERSION.SDK_INT < 25) {
                Intent intent3 = new Intent("com.meizu.safe.security.SHOW_APPSEC");
                intent3.putExtra("packageName", packageName);
                intent3.setComponent(new ComponentName("com.meizu.safe", "com.meizu.safe.security.AppSecActivity"));
                return intent3;
            }
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + kd.getPackageName()));
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (u.xj()) {
            u.xj(true);
        } else {
            u.xj(false);
        }
    }

    public Intent w() {
        Context kd = kd();
        if (kd == null) {
            return null;
        }
        return new Intent("android.settings.APPLICATION_DETAILS_SETTINGS", Uri.parse("package:" + kd.getPackageName()));
    }

    public void xj() {
        try {
            try {
                try {
                    startActivityForResult(y(), 1000);
                } catch (Throwable unused) {
                    startActivityForResult(w(), 1000);
                }
            } catch (Throwable unused2) {
                startActivityForResult(u(), 1000);
            }
        } catch (Throwable unused3) {
            startActivityForResult(hf(), 1000);
        }
    }
}
