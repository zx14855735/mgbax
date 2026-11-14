package com.ss.android.downloadlib.addownload.compliance;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.mobads.sdk.internal.an;
import com.qq.e.ads.nativ.NativeUnifiedADAppInfoImpl;
import com.sigmob.sdk.base.n;
import com.ss.android.download.api.config.v;
import com.ss.android.download.api.download.DownloadModel;
import com.ss.android.downloadlib.activity.TTDelegateActivity;
import com.ss.android.downloadlib.addownload.pl;
import com.ss.android.downloadlib.c.g;
import com.ss.android.downloadlib.c.w;
import java.lang.ref.SoftReference;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes3.dex */
public class hf {
    private SoftReference<Activity> xj;

    public static class xj {
        private static hf xj = new hf();

        static {
            LrXr();
        }

        private static /* synthetic */ void LrXr() {
            char[] charArray = "\u0004\b\nI\u0000\u0006\n\u0002I\u0005\b\u001eI\u0014\u000f\u0002\u000b\u000bI-\t\u000e%\u0015\u000e\u0003\u0000\u0002".toCharArray();
            int length = charArray.length;
            for (int i = 0; i < length; i++) {
                charArray[i] = (char) (charArray[i] ^ 'g');
            }
            String str = new String(charArray);
            char[] charArray2 = "\u0004\u000b\u000e\t\u000e\u0013".toCharArray();
            int length2 = charArray2.length;
            for (int i2 = 0; i2 < length2; i2++) {
                charArray2[i2] = (char) (charArray2[i2] ^ 'g');
            }
            Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(null, new Object[0]);
        }
    }

    public void hf(long j) {
        com.ss.android.downloadlib.addownload.kd xj2 = com.ss.android.downloadlib.f.xj().xj(com.ss.android.downloadlib.addownload.hf.y.xj().kd(j).hf.getDownloadUrl());
        if (xj2 != null) {
            xj2.xj(true, true);
        } else {
            c.xj(11, j);
            com.ss.android.downloadlib.kd.w.xj().hf("startDownload handler null");
        }
    }

    private hf() {
    }

    public static hf xj() {
        return xj.xj;
    }

    public void xj(long j) {
        TTDelegateActivity.xj(j);
    }

    public boolean xj(DownloadModel downloadModel) {
        if (!downloadModel.isAd() || pl.d().optInt("ad_lp_show_app_dialog") == 0) {
            return false;
        }
        String webUrl = downloadModel.getDeepLink() == null ? null : downloadModel.getDeepLink().getWebUrl();
        return (TextUtils.isEmpty(webUrl) || Pattern.compile(pl.d().optString("ad_allow_web_url_regex", ".+(www.chengzijianzhan.com|www.toutiaopage.com/tetris/page|ad.toutiao.com/tetris/page).+")).matcher(webUrl).matches()) ? false : true;
    }

    public Activity hf() {
        Activity activity = this.xj.get();
        this.xj = null;
        return activity;
    }

    public boolean xj(com.ss.android.downloadlib.addownload.hf.kd kdVar) {
        long j;
        final long j2;
        if (!TextUtils.isEmpty(kdVar.hf.getLogExtra())) {
            try {
                j = g.xj(new JSONObject(kdVar.hf.getLogExtra()), "convert_id");
            } catch (Exception e) {
                com.bytedance.sdk.component.utils.pl.xj(e);
                j = 0;
            }
            if (j <= 0) {
                c.xj(3, kdVar);
            }
            j2 = j;
        } else {
            c.xj(9, kdVar);
            com.ss.android.downloadlib.kd.w.xj().xj("requestAppInfo getLogExtra null");
            j2 = 0;
        }
        final long j3 = kdVar.xj;
        com.ss.android.downloadlib.addownload.hf.hf xj2 = w.xj().xj(j2, j3);
        if (xj2 != null) {
            u.xj().xj(xj2.xj(), j3, xj2.u);
            xj(xj2.xj());
            c.xj("lp_app_dialog_try_show", kdVar);
            return true;
        }
        StringBuilder sb = new StringBuilder();
        if (j2 > 0) {
            sb.append("convert_id=");
            sb.append(j2);
        }
        if (!TextUtils.isEmpty(kdVar.hf.getPackageName())) {
            if (sb.length() > 0) {
                sb.append("&");
            }
            sb.append("package_name=");
            sb.append(kdVar.hf.getPackageName());
        }
        if (sb.length() <= 0) {
            c.xj(6, kdVar);
            return false;
        }
        com.ss.android.downloadlib.c.w.xj((w.xj<String, R>) new w.xj<String, Boolean>() { // from class: com.ss.android.downloadlib.addownload.compliance.hf.2
            @Override // com.ss.android.downloadlib.c.w.xj
            public Boolean xj(String str) {
                final boolean[] zArr = {false};
                pl.u().xj(an.c, str, new HashMap(), new v() { // from class: com.ss.android.downloadlib.addownload.compliance.hf.2.1
                    @Override // com.ss.android.download.api.config.v
                    public void xj(String str2) {
                        boolean[] zArr2 = zArr;
                        AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                        zArr2[0] = hf.this.xj(j2, j3, str2);
                    }

                    @Override // com.ss.android.download.api.config.v
                    public void xj(Throwable th) {
                        c.xj(2, j3);
                        zArr[0] = false;
                    }
                });
                return Boolean.valueOf(zArr[0]);
            }
        }, "https://apps.oceanengine.com/customer/api/app/pkg_info?" + sb.toString()).xj(new w.xj<Boolean, Object>() { // from class: com.ss.android.downloadlib.addownload.compliance.hf.1
            @Override // com.ss.android.downloadlib.c.w.xj
            public Object xj(Boolean bool) {
                if (!bool.booleanValue()) {
                    hf.this.hf(j3);
                    return null;
                }
                hf.this.xj(com.ss.android.downloadlib.addownload.hf.hf.xj(j2, j3));
                c.hf("lp_app_dialog_try_show", j3);
                return null;
            }
        }).xj();
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean xj(long j, long j2, String str) {
        long j3;
        Exception exc;
        JSONObject optJSONObject;
        try {
            optJSONObject = new JSONObject(str).optJSONObject("package");
        } catch (Exception e) {
            e = e;
            j3 = j2;
        }
        try {
            if (optJSONObject != null && optJSONObject.length() != 0) {
                com.ss.android.downloadlib.addownload.hf.hf hfVar = new com.ss.android.downloadlib.addownload.hf.hf();
                hfVar.xj = j;
                hfVar.hf = j2;
                hfVar.u = optJSONObject.optString("icon_url");
                hfVar.kd = optJSONObject.optString("app_name");
                hfVar.w = optJSONObject.optString(n.p);
                hfVar.y = optJSONObject.optString(NativeUnifiedADAppInfoImpl.Keys.VERSION_NAME);
                hfVar.c = optJSONObject.optString("developer_name");
                hfVar.d = optJSONObject.optString("policy_url");
                JSONArray optJSONArray = optJSONObject.optJSONArray("permissions");
                if (optJSONArray != null) {
                    for (int i = 0; i < optJSONArray.length(); i++) {
                        try {
                            JSONObject jSONObject = (JSONObject) optJSONArray.get(i);
                            hfVar.f.add(new Pair<>(jSONObject.optString("permission_name"), jSONObject.optString("permission_desc")));
                        } catch (Exception e2) {
                            exc = e2;
                            j3 = j2;
                            com.ss.android.downloadlib.kd.w.xj().xj(exc, "AdLpComplianceManager parseResponse");
                            c.xj(7, j3);
                            return false;
                        }
                    }
                }
                w.xj().xj(hfVar);
                u.xj().xj(hfVar.xj(), j2, hfVar.u);
                return true;
            }
            c.xj(7, j2);
            return false;
        } catch (Exception e3) {
            e = e3;
            exc = e;
            com.ss.android.downloadlib.kd.w.xj().xj(exc, "AdLpComplianceManager parseResponse");
            c.xj(7, j3);
            return false;
        }
    }

    public void xj(Activity activity) {
        this.xj = new SoftReference<>(activity);
    }
}
