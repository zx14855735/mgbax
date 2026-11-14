package com.bytedance.embedapplog;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
class wa extends n {
    private final Context kd;
    private final wn y;

    public wa(Context context, wn wnVar) {
        super(false, false);
        this.kd = context;
        this.y = wnVar;
    }

    @Override // com.bytedance.embedapplog.n
    public boolean xj(JSONObject jSONObject) {
        int i;
        ApplicationInfo applicationInfo;
        int i2;
        String packageName = this.kd.getPackageName();
        PackageInfo packageInfo = null;
        if (TextUtils.isEmpty(this.y.vm())) {
            jSONObject.put("package", packageName);
        } else {
            if (cu.hf) {
                cu.xj("has zijie pkg", null);
            }
            jSONObject.put("package", this.y.vm());
            jSONObject.put("real_package_name", packageName);
        }
        try {
            packageInfo = this.kd.getPackageManager().getPackageInfo(packageName, 0);
        } catch (Throwable unused) {
        }
        if (packageInfo != null) {
            try {
                i = packageInfo.versionCode;
            } catch (Throwable th) {
                cu.hf(th);
                return false;
            }
        } else {
            i = 0;
        }
        if (TextUtils.isEmpty(this.y.l())) {
            jSONObject.put(com.sigmob.sdk.base.n.r, packageInfo != null ? packageInfo.versionName : "");
        } else {
            jSONObject.put(com.sigmob.sdk.base.n.r, this.y.l());
        }
        if (TextUtils.isEmpty(this.y.b())) {
            jSONObject.put("app_version_minor", "");
        } else {
            jSONObject.put("app_version_minor", this.y.b());
        }
        if (this.y.z() != 0) {
            jSONObject.put("version_code", this.y.z());
        } else {
            jSONObject.put("version_code", i);
        }
        if (this.y.j() != 0) {
            jSONObject.put("update_version_code", this.y.j());
        } else {
            jSONObject.put("update_version_code", i);
        }
        if (this.y.en() != 0) {
            jSONObject.put("manifest_version_code", this.y.en());
        } else {
            jSONObject.put("manifest_version_code", i);
        }
        if (!TextUtils.isEmpty(this.y.q())) {
            jSONObject.put("app_name", this.y.q());
        }
        if (!TextUtils.isEmpty(this.y.ff())) {
            jSONObject.put("tweaked_channel", this.y.ff());
        }
        if (packageInfo == null || (applicationInfo = packageInfo.applicationInfo) == null || (i2 = applicationInfo.labelRes) <= 0) {
            return true;
        }
        jSONObject.put("display_name", this.kd.getString(i2));
        return true;
    }
}
