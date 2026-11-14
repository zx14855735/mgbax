package com.bytedance.sdk.openadsdk.ats.xj;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import com.bytedance.sdk.component.u.p;
import com.bytedance.sdk.component.utils.pl;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class xj implements p {
    @SuppressLint({"[ByDesign12.1]UsingRuntimeExec"})
    private String xj(String str) {
        BufferedReader bufferedReader;
        Throwable th;
        Process process;
        try {
            process = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(process.getInputStream()), 1024);
                try {
                    String readLine = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                    } catch (IOException e) {
                        pl.w("SystemPropAdb", "Exception while closing InputStream", e);
                    }
                    try {
                        process.destroy();
                    } catch (Throwable unused) {
                    }
                    return readLine;
                } catch (Throwable th2) {
                    th = th2;
                    try {
                        pl.w("SystemPropAdb", "Unable to read sysprop ".concat(String.valueOf(str)), th);
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (IOException e2) {
                                pl.w("SystemPropAdb", "Exception while closing InputStream", e2);
                            }
                        }
                        if (process == null) {
                            return "";
                        }
                        try {
                            process.destroy();
                            return "";
                        } catch (Throwable unused2) {
                            return "";
                        }
                    } finally {
                    }
                }
            } catch (Throwable th3) {
                bufferedReader = null;
                th = th3;
            }
        } catch (Throwable th4) {
            bufferedReader = null;
            th = th4;
            process = null;
        }
    }

    @Override // com.bytedance.sdk.component.u.p
    public String get(String str) {
        return xj(str);
    }

    @Override // com.bytedance.sdk.component.u.p
    public boolean getBoolean(String str) {
        String xj = xj(str);
        if (TextUtils.isEmpty(xj)) {
            return false;
        }
        try {
            return Boolean.parseBoolean(xj);
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // com.bytedance.sdk.component.u.p
    public int getInt(String str) {
        String xj = xj(str);
        if (TextUtils.isEmpty(xj)) {
            return 0;
        }
        try {
            return Integer.parseInt(xj);
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // com.bytedance.sdk.component.u.p
    public long getLong(String str) {
        String xj = xj(str);
        if (TextUtils.isEmpty(xj)) {
            return 0L;
        }
        try {
            return Long.parseLong(xj);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.component.u.p
    public void set(String str, String str2) {
    }
}
