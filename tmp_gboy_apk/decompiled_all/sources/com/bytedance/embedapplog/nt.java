package com.bytedance.embedapplog;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Pair;
import com.bytedance.embedapplog.kr;
import com.bytedance.embedapplog.m;
import com.bytedance.embedapplog.tf;
import java.lang.reflect.Method;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
final class nt implements m {
    private static final xv<Boolean> hf = new xv<Boolean>() { // from class: com.bytedance.embedapplog.nt.1
        @Override // com.bytedance.embedapplog.xv
        /* renamed from: w, reason: merged with bridge method [inline-methods] */
        public Boolean xj(Object... objArr) {
            return Boolean.valueOf(ey.xj((Context) objArr[0]));
        }
    };
    private String xj;

    public static class xj extends m.xj {
        long xj = 0;
    }

    static {
        DJuof();
    }

    private static /* synthetic */ void DJuof() {
        char[] charArray = ";75v?95=v:7!v+0=44v\u001261\u001a*1<?=".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 'X');
        }
        String str = new String(charArray);
        char[] charArray2 = ";4161,".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 'X');
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    private boolean kd(Context context) {
        PackageManager packageManager;
        if (context == null) {
            return false;
        }
        try {
            packageManager = context.getPackageManager();
        } catch (PackageManager.NameNotFoundException | Exception unused) {
        }
        if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
            this.xj = "com.huawei.hwid";
            return true;
        }
        if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) != null) {
            this.xj = "com.huawei.hwid.tv";
            return true;
        }
        this.xj = "com.huawei.hms";
        return packageManager.getPackageInfo("com.huawei.hms", 0) != null;
    }

    public static boolean w(Context context) {
        if (context == null) {
            return false;
        }
        return hf.hf(context).booleanValue();
    }

    private Pair<String, Boolean> y(Context context) {
        if (TextUtils.isEmpty(this.xj)) {
            return null;
        }
        return (Pair) new tf(context, new Intent("com.uodis.opendevice.OPENIDS_SERVICE").setPackage(this.xj), new tf.hf<kr, Pair<String, Boolean>>() { // from class: com.bytedance.embedapplog.nt.2
            @Override // com.bytedance.embedapplog.tf.hf
            /* renamed from: hf, reason: merged with bridge method [inline-methods] */
            public kr xj(IBinder iBinder) {
                return kr.xj.xj(iBinder);
            }

            @Override // com.bytedance.embedapplog.tf.hf
            public Pair<String, Boolean> xj(kr krVar) {
                if (krVar == null) {
                    return null;
                }
                return new Pair<>(krVar.xj(), Boolean.valueOf(krVar.hf()));
            }
        }).xj();
    }

    @Override // com.bytedance.embedapplog.m
    /* renamed from: u, reason: merged with bridge method [inline-methods] */
    public xj hf(Context context) {
        xj xjVar = new xj();
        if (Build.VERSION.SDK_INT >= 24) {
            try {
                String string = Settings.Global.getString(context.getContentResolver(), "pps_oaid");
                String string2 = Settings.Global.getString(context.getContentResolver(), "pps_track_limit");
                if (!TextUtils.isEmpty(string)) {
                    xjVar.hf = string;
                    xjVar.w = Boolean.parseBoolean(string2);
                    xjVar.xj = 202003021704L;
                    return xjVar;
                }
            } catch (Throwable th) {
                cu.xj(th);
            }
        }
        Pair<String, Boolean> y = y(context);
        if (y != null) {
            xjVar.hf = (String) y.first;
            xjVar.w = ((Boolean) y.second).booleanValue();
            xjVar.xj = xj(context, this.xj);
        }
        return xjVar;
    }

    @Override // com.bytedance.embedapplog.m
    public boolean xj(Context context) {
        return kd(context);
    }

    private static int xj(Context context, String str) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
        } catch (PackageManager.NameNotFoundException e) {
            cu.xj(e);
        }
        return 0;
    }
}
