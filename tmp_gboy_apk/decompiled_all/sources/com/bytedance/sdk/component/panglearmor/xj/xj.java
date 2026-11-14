package com.bytedance.sdk.component.panglearmor.xj;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ServiceInfo;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.bytedance.sdk.component.panglearmor.xj.hf.y;
import com.bytedance.sdk.openadsdk.api.plugin.hf;
import java.io.File;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private static xj xj;
    private long hf = 0;

    private boolean hf() {
        return new SecureRandom().nextInt(10) == 1;
    }

    private boolean w() {
        SharedPreferences sharedPreferences = SoftDecTool.getSharedPreferences(SoftDecTool.SP_NAME);
        if (sharedPreferences == null) {
            return false;
        }
        this.hf = (System.currentTimeMillis() / 1000) - SoftDecTool.fr();
        int i = sharedPreferences.getInt("hit_times", 0);
        if (i < 2 && this.hf >= 172800) {
            sharedPreferences.edit().putInt("hit_times", 2).apply();
            return hf();
        }
        if (i != 0 || this.hf < 21600) {
            return false;
        }
        sharedPreferences.edit().putInt("hit_times", 1).apply();
        return hf();
    }

    public static xj xj() {
        if (xj == null) {
            synchronized (xj.class) {
                try {
                    if (xj == null) {
                        xj xjVar = new xj();
                        xj = xjVar;
                        xjVar.hf = 0L;
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    private String hf(Context context) {
        if (context == null) {
            return null;
        }
        String packageCodePath = context.getPackageCodePath();
        if (TextUtils.isEmpty(packageCodePath)) {
            return null;
        }
        File file = new File(packageCodePath);
        if (file.exists() && file.canRead()) {
            return packageCodePath;
        }
        return null;
    }

    public synchronized JSONObject xj(Context context, String str) {
        String hf;
        JSONObject jSONObject = new JSONObject();
        try {
            hf = hf(context);
        } catch (Throwable unused) {
        }
        if (!TextUtils.isEmpty(hf) && w()) {
            File file = new File(hf);
            if (file.exists()) {
                jSONObject = xj(file, context, str);
            }
            return jSONObject;
        }
        return null;
    }

    private JSONObject xj(File file, Context context, String str) {
        JSONObject xj2 = y.xj(file);
        File xj3 = hf.xj(context);
        if (xj3 != null) {
            y.xj(xj2, "files", xj(!TextUtils.isEmpty(str) ? hf.xj(context).getParent() : hf.xj(context).getPath()), false);
            File parentFile = xj3.getParentFile();
            if (parentFile != null) {
                List<String> xj4 = xj(CtFAbx.B25kr6(new StringBuilder(), !TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath(), "/shared_prefs"));
                List<String> xj5 = xj(CtFAbx.B25kr6(new StringBuilder(), !TextUtils.isEmpty(str) ? parentFile.getParent() : parentFile.getPath(), "/databases"));
                y.xj(xj2, "prefs", xj4, false);
                y.xj(xj2, "databases", xj5, false);
            }
        }
        try {
            JSONObject xj6 = xj(context);
            if (xj6 != null && xj6.length() > 0) {
                xj2.put("manifest", xj6);
            }
            xj2.put("rt", this.hf);
            xj2.put("path", str);
        } catch (JSONException unused) {
        }
        return xj2;
    }

    private List<String> xj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.exists() || !file.isDirectory()) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File file2 : listFiles) {
                if (file2.isFile() && file2.exists()) {
                    arrayList.add(file2.getName());
                }
            }
        }
        return arrayList;
    }

    private JSONObject xj(Context context) {
        if (context == null) {
            return null;
        }
        try {
            JSONObject jSONObject = new JSONObject();
            String packageName = context.getPackageName();
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(packageName, 4239);
            ApplicationInfo applicationInfo = context.getApplicationInfo();
            if (applicationInfo != null) {
                jSONObject.put("application_name", applicationInfo.name);
                jSONObject.put("label", packageManager.getApplicationLabel(applicationInfo));
            }
            if (packageInfo != null) {
                ActivityInfo[] activityInfoArr = packageInfo.activities;
                String[] strArr = packageInfo.requestedPermissions;
                ActivityInfo[] activityInfoArr2 = packageInfo.receivers;
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                ProviderInfo[] providerInfoArr = packageInfo.providers;
                if (activityInfoArr != null) {
                    JSONArray jSONArray = new JSONArray();
                    for (ActivityInfo activityInfo : activityInfoArr) {
                        jSONArray.put(activityInfo.name);
                    }
                    jSONObject.put("activities", jSONArray);
                }
                if (strArr != null) {
                    JSONArray jSONArray2 = new JSONArray();
                    for (String str : strArr) {
                        jSONArray2.put(str);
                    }
                    jSONObject.put("permissions", jSONArray2);
                }
                if (activityInfoArr2 != null) {
                    JSONArray jSONArray3 = new JSONArray();
                    for (ActivityInfo activityInfo2 : activityInfoArr2) {
                        jSONArray3.put(activityInfo2.name);
                    }
                    jSONObject.put("receivers", jSONArray3);
                }
                if (serviceInfoArr != null) {
                    JSONArray jSONArray4 = new JSONArray();
                    for (ServiceInfo serviceInfo : serviceInfoArr) {
                        jSONArray4.put(serviceInfo.name);
                    }
                    jSONObject.put("services", jSONArray4);
                }
                if (providerInfoArr != null) {
                    JSONArray jSONArray5 = new JSONArray();
                    for (ProviderInfo providerInfo : providerInfoArr) {
                        jSONArray5.put(providerInfo.name);
                    }
                    jSONObject.put("providers", jSONArray5);
                }
            }
            return jSONObject;
        } catch (Throwable unused) {
            return null;
        }
    }
}
