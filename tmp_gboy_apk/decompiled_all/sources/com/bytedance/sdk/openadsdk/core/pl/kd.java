package com.bytedance.sdk.openadsdk.core.pl;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build;
import android.text.TextUtils;
import com.baidu.mobads.sdk.internal.cb;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.component.y.dk;
import com.bytedance.sdk.component.y.zg;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.pz;
import com.sigmob.sdk.base.mta.PointParamKey;
import com.ss.android.download.api.constant.BaseConstants;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class kd implements u {
    private w xj;

    public kd(w wVar) {
        this.xj = wVar;
    }

    private String hf(String str, String str2, String str3, int i, String str4, String str5, int i2, String str6, String str7) {
        ApplicationInfo applicationInfo;
        if (!this.xj.xj()) {
            return "enable_install_notification";
        }
        com.bytedance.sdk.openadsdk.zg.w.w.u e = com.bytedance.sdk.openadsdk.core.f.zg().e();
        if (e != null && !e.f()) {
            return "isCanUseMessage";
        }
        if (i2 == 0) {
            return "enable_notification=0";
        }
        Context context = pz.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.bytedance.sdk.openadsdk.core.io.kd.xj().hf(pz.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (xj(1440L, this.xj.y(), this.xj.kd() * 1000)) {
            return null;
        }
        return "max_times_limit";
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u
    public boolean xj(final String str, final String str2, final String str3, final int i, final String str4, String str5, int i2, final String str6, final String str7) {
        String hf = hf(str, str2, str3, i, str4, str5, i2, str6, str7);
        if (TextUtils.isEmpty(hf)) {
            com.bytedance.sdk.component.utils.f.xj().postDelayed(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.kd.1
                @Override // java.lang.Runnable
                public void run() {
                    kd.this.xj(str, str2, str3, i, str4, str6, str7, "startUnInstallNotification");
                }
            }, this.xj.u() * 1000);
            return true;
        }
        xj("notification", str7, str4, "install", str3, "othershow", hf, "failure");
        return false;
    }

    @Override // com.bytedance.sdk.openadsdk.core.pl.u
    public boolean xj(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        String hf = hf(str, str2, str3, str4, i, str5, str6);
        if (TextUtils.isEmpty(hf)) {
            xj(str, str2, str3, str3.hashCode(), str4, str5, str6, "pushUnActiveFromMarketMessage");
            return true;
        }
        xj("notification", str6, str4, "open", str3, "othershow", hf, "failure");
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void xj(final String str, final String str2, final String str3, final int i, final String str4, final String str5, final String str6, final String str7) {
        com.bytedance.sdk.openadsdk.f.hf.xj(str2).config(Bitmap.Config.ARGB_4444).type(2).to(new dk<Bitmap>() { // from class: com.bytedance.sdk.openadsdk.core.pl.kd.2
            @Override // com.bytedance.sdk.component.y.dk
            public void onFailed(int i2, String str8, Throwable th) {
            }

            @Override // com.bytedance.sdk.component.y.dk
            public void onSuccess(zg<Bitmap> zgVar) {
                if (zgVar != null) {
                    Bitmap result = zgVar.getResult();
                    final Bitmap xj = kd.xj(result, 10.0f);
                    if (result != null) {
                        final boolean w = wo.w(pz.getContext(), str3);
                        String str8 = str6;
                        String str9 = str4;
                        String str10 = w ? "open" : "install";
                        kd.xj("notification", str8, str9, str10, str3, "othershow", str7 + "_" + str3, cb.o);
                        com.bytedance.sdk.openadsdk.x.c.xj(new Runnable() { // from class: com.bytedance.sdk.openadsdk.core.pl.kd.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                AnonymousClass2 anonymousClass2 = AnonymousClass2.this;
                                com.bytedance.sdk.openadsdk.core.pl.w.hf.hf.xj(str, str2, str4, "com.csj.install", i, w ? 1 : 2, xj, str3, str5, str6);
                            }
                        });
                    }
                }
            }
        }, 4);
    }

    public static void xj(String str, String str2, String str3, final String str4, final String str5, String str6, final String str7, final String str8) {
        com.bytedance.sdk.openadsdk.core.am.u.xj(str, str6, str2, str3, new com.bytedance.sdk.openadsdk.y.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.pl.kd.3
            @Override // com.bytedance.sdk.openadsdk.y.xj.xj
            public void xj(JSONObject jSONObject) {
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put(PointParamKey.TYPE, str4);
                jSONObject2.put("installer_package_name", str5);
                if (!TextUtils.isEmpty(str7)) {
                    jSONObject2.put("detail_info", str7);
                }
                if (!TextUtils.isEmpty(str8)) {
                    jSONObject2.put("status", str8);
                }
                if (jSONObject != null) {
                    jSONObject.put(BaseConstants.EVENT_LABEL_AD_EXTRA_DATA, jSONObject2);
                }
            }
        });
    }

    private String hf(String str, String str2, String str3, String str4, int i, String str5, String str6) {
        ApplicationInfo applicationInfo;
        if (!this.xj.hf()) {
            return "enable_action_notification=0";
        }
        if (i == 0) {
            return "enable_notification=0";
        }
        Context context = pz.getContext();
        if (context != null && (applicationInfo = context.getApplicationInfo()) != null && applicationInfo.targetSdkVersion >= 33 && Build.VERSION.SDK_INT >= 33 && !com.bytedance.sdk.openadsdk.core.io.kd.xj().hf(pz.getContext(), "android.permission.POST_NOTIFICATIONS")) {
            return "post_notifications_deny";
        }
        if (xj(1440L, this.xj.y(), this.xj.kd() * 1000)) {
            return null;
        }
        return "max_times_limit";
    }

    public static Bitmap xj(Bitmap bitmap, float f) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(-12434878);
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    public boolean xj(long j, int i, long j2) {
        int i2;
        try {
            Long l = -1L;
            try {
                l = Long.valueOf(60000 * j);
                i2 = i;
            } catch (Exception e) {
                pl.hf("xgc_notification", "error", e.getMessage());
                i2 = -1;
            }
            if (l.longValue() >= 0 && i2 >= 0 && l.longValue() != 0 && i2 != 0) {
                String xj = xj();
                StringBuilder sb = new StringBuilder();
                long currentTimeMillis = System.currentTimeMillis();
                if (TextUtils.isEmpty(xj)) {
                    sb.append(currentTimeMillis);
                    xj(sb.toString());
                    return true;
                }
                String[] split = xj.split("_");
                int length = split.length;
                if (length < i2) {
                    if (currentTimeMillis - Long.parseLong(split[length - 1]) <= j2) {
                        return false;
                    }
                    for (String str : split) {
                        sb.append(str);
                        sb.append("_");
                    }
                    sb.append(currentTimeMillis);
                    xj(sb.toString());
                    return true;
                }
                int i3 = length - i2;
                long parseLong = Long.parseLong(split[i3]);
                if (currentTimeMillis - Long.parseLong(split[length - 1]) > j2 && currentTimeMillis - parseLong > l.longValue()) {
                    for (int i4 = i3; i4 < length; i4++) {
                        String str2 = split[i4];
                        if (i4 != i3 && !TextUtils.isEmpty(str2)) {
                            sb.append(str2);
                            sb.append("_");
                        }
                    }
                    sb.append(currentTimeMillis);
                    xj(sb.toString());
                    return true;
                }
            }
            return false;
        } catch (Exception e2) {
            pl.xj(e2);
            pl.hf("xgc_notification", "exception:" + e2.getMessage());
            return false;
        }
    }

    public static String xj() {
        return com.bytedance.sdk.openadsdk.core.hf.xj().get("notification_a", "");
    }

    public static void xj(String str) {
        com.bytedance.sdk.openadsdk.core.hf.xj().put("notification_a", str);
    }
}
