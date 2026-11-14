package com.qq.e.comm.managers.plugin;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.io.File;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
class g {

    /* renamed from: A2egSU, reason: collision with root package name */
    public final File f12958A2egSU;

    /* renamed from: A4TApA, reason: collision with root package name */
    public final File f12959A4TApA;

    /* renamed from: A5SV6n, reason: collision with root package name */
    public String f12960A5SV6n;

    /* renamed from: ADYaiT, reason: collision with root package name */
    public int f12961ADYaiT;
    public String AMqCpz;

    public g(File file, File file2) {
        this.f12958A2egSU = file;
        this.f12959A4TApA = file2;
    }

    public final boolean A2egSU(Context context, boolean z) {
        int i;
        File file = this.f12959A4TApA;
        File file2 = this.f12958A2egSU;
        try {
            if (file.exists() && file2.exists()) {
                String A2egSU2 = h.A2egSU(file);
                this.AMqCpz = A2egSU2;
                if (!TextUtils.isEmpty(A2egSU2)) {
                    String[] split = this.AMqCpz.split("#####");
                    if (split.length == 2) {
                        String str = split[1];
                        try {
                            i = Integer.parseInt(split[0]);
                        } catch (Throwable unused) {
                            i = 0;
                        }
                        if (c.a().a(str, file2)) {
                            this.f12960A5SV6n = str;
                            this.f12961ADYaiT = i;
                            if (Build.VERSION.SDK_INT < 34 || context == null || context.getApplicationInfo() == null || context.getApplicationInfo().targetSdkVersion < 34 || !z) {
                                return true;
                            }
                            if (!file2.canWrite() && !file2.canExecute()) {
                                return file2.canRead();
                            }
                            return file2.setReadOnly();
                        }
                    }
                }
            }
        } catch (Throwable unused2) {
        }
        return false;
    }

    public String c() {
        return this.AMqCpz;
    }
}
