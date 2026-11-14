package com.bytedance.sdk.openadsdk.downloadnew;

import ADYaiT.BpkvW3;
import IzHBwY.ADYaiT;
import IzHBwY.ARc23Z;
import JMFfuZ.A2egSU;
import P8ccfD.AaHO0E;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.util.Pair;
import android.util.SparseArray;
import android.widget.RemoteViews;
import androidx.core.app.BV3sI0;
import androidx.core.app.C2rE4F;
import androidx.core.content.FileProvider;
import com.bytedance.sdk.openadsdk.api.y;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public final class w implements Function<SparseArray<Object>, Object> {
    private static volatile w xj;
    private final Context hf;
    private Function<SparseArray<Object>, Object> w;

    private w(Context context) {
        this.hf = context;
    }

    private Map<String, Object> hf(Map<String, Object> map) {
        String concat;
        String str;
        String str2;
        Icon createWithBitmap;
        String str3;
        if (map == null) {
            return null;
        }
        HashMap hashMap = new HashMap();
        String str4 = (String) map.get("install_app_name");
        Bitmap bitmap = (Bitmap) map.get("install_icon_bitmap");
        String str5 = (String) map.get("install_action_type");
        Object obj = map.get("install_click_type");
        String str6 = (String) map.get("install_package_name");
        String str7 = (String) map.get("install_tag");
        String str8 = (String) map.get("install_value");
        String str9 = (String) map.get("install_log_extra");
        int intValue = obj != null ? ((Integer) obj).intValue() : -1;
        Object obj2 = map.get("install_download_id");
        int intValue2 = obj2 != null ? ((Integer) obj2).intValue() : -1;
        Object obj3 = map.get("install_enable_target_34");
        boolean booleanValue = obj3 != null ? ((Boolean) obj3).booleanValue() : false;
        RemoteViews remoteViews = new RemoteViews(this.hf.getPackageName(), this.hf.getResources().getIdentifier("tt_install_notification_layout", "layout", this.hf.getPackageName()));
        int g = xj.g();
        int pl2 = xj.pl();
        int am = xj.am();
        int i = intValue2;
        int qt = xj.qt();
        int zg = xj.zg();
        if (intValue == 1) {
            concat = "打开".concat(String.valueOf(str4));
            str = "应用已安装完成";
            str2 = "去打开";
        } else {
            concat = "安装".concat(String.valueOf(str4));
            str = "应用已下载完成";
            str2 = "去安装";
        }
        String str10 = str;
        String str11 = concat;
        String str12 = str2;
        remoteViews.setTextViewText(pl2, str10);
        remoteViews.setTextViewText(am, str11);
        remoteViews.setTextViewText(qt, str12);
        int et = xj.et();
        if (et == 0) {
            et = xj.dk();
        }
        int i2 = et;
        createWithBitmap = Icon.createWithBitmap(bitmap);
        remoteViews.setImageViewIcon(g, createWithBitmap);
        PendingIntent xj2 = xj(str5, intValue, i, booleanValue, str6, str7, str8, str9);
        remoteViews.setOnClickPendingIntent(zg, xj2);
        remoteViews.setOnClickPendingIntent(qt, xj2);
        String str13 = "csj_" + this.hf.getPackageName();
        try {
            if (Build.VERSION.SDK_INT >= 26) {
                A2egSU.AaHO0E();
                NotificationChannel AMqCpz = A2egSU.AMqCpz(str13);
                AMqCpz.setShowBadge(true);
                AMqCpz.setBypassDnd(true);
                str3 = "notification";
                try {
                    ((NotificationManager) this.hf.getSystemService(str3)).createNotificationChannel(AMqCpz);
                } catch (Throwable th) {
                    th = th;
                    y.xj(th);
                    BV3sI0 xj3 = xj(str13);
                    xj3.ASJ6gh(new C2rE4F());
                    xj3.f8516ASJ6gh = xj2;
                    xj3.f8551CikNvS.icon = i2;
                    xj3.AMqCpz = BV3sI0.A4TApA(str10);
                    xj3.f8515ARc23Z = BV3sI0.A4TApA(str11);
                    xj3.f8522AlLFFp = 1;
                    xj3.ADYaiT(-1);
                    xj3.f8540BniPrB = 1;
                    xj3.A5SV6n(true);
                    Notification A2egSU2 = xj3.A2egSU();
                    A2egSU2.contentView = remoteViews;
                    hashMap.put(str3, A2egSU2);
                    return hashMap;
                }
            } else {
                str3 = "notification";
            }
        } catch (Throwable th2) {
            th = th2;
            str3 = "notification";
        }
        BV3sI0 xj32 = xj(str13);
        xj32.ASJ6gh(new C2rE4F());
        xj32.f8516ASJ6gh = xj2;
        xj32.f8551CikNvS.icon = i2;
        xj32.AMqCpz = BV3sI0.A4TApA(str10);
        xj32.f8515ARc23Z = BV3sI0.A4TApA(str11);
        xj32.f8522AlLFFp = 1;
        xj32.ADYaiT(-1);
        xj32.f8540BniPrB = 1;
        xj32.A5SV6n(true);
        Notification A2egSU22 = xj32.A2egSU();
        A2egSU22.contentView = remoteViews;
        hashMap.put(str3, A2egSU22);
        return hashMap;
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x04e7  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x04f4  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x04ea  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0251  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private java.util.Map<java.lang.String, java.lang.Object> w(java.util.Map<java.lang.String, java.lang.Object> r27) {
        /*
            Method dump skipped, instructions count: 1355
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.w.w(java.util.Map):java.util.Map");
    }

    @Override // java.util.function.Function
    /* renamed from: xj, reason: merged with bridge method [inline-methods] */
    public Object apply(SparseArray<Object> sparseArray) {
        if (sparseArray == null) {
            return null;
        }
        ADYaiT AMqCpz = com.bykv.vk.component.ttvideo.player.A2egSU.AMqCpz(sparseArray);
        int intValue = AMqCpz.intValue(-99999987, 0);
        Class cls = (Class) AMqCpz.objectValue(-99999985, Class.class);
        if (intValue != -99999986) {
            return xj(cls, intValue, AMqCpz.objectValue(0, Map.class) != null ? (Map) AMqCpz.objectValue(0, Map.class) : new HashMap<>());
        }
        ARc23Z A4TApA2 = ARc23Z.A4TApA();
        A4TApA2.ADYaiT(10000, 3);
        return A4TApA2.A2egSU().sparseArray();
    }

    public static w xj() {
        return xj;
    }

    public static w xj(Context context) {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        xj = new w(context);
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public <T> T xj(Class<T> cls, int i, Map<String, Object> map) {
        Object apply;
        y.hf("xgc_dl", "api:".concat(String.valueOf(i)));
        if (i == 0) {
            if (this.w != null) {
                SparseArray sparseArray = new SparseArray();
                sparseArray.put(-99999987, 0);
                sparseArray.put(0, map);
                apply = this.w.apply(sparseArray);
                return (T) apply;
            }
            return (T) Boolean.FALSE;
        }
        if (i != 159) {
            if (i == 161) {
                return (T) hf(map);
            }
            if (i == 155) {
                return (T) xj((String) map.get("custom_authority"), (String) map.get("custom_file_path"));
            }
            if (i == 156) {
                return (T) xj(map);
            }
        } else if (map != null) {
            Object obj = map.get("n");
            if (BpkvW3.BmvVmW(obj)) {
                this.w = AaHO0E.AYUAbz(obj);
            }
        }
        return null;
    }

    public void xj(Map<String, Object> map, int i) {
        SparseArray sparseArray = new SparseArray();
        sparseArray.put(-99999987, Integer.valueOf(i));
        sparseArray.put(0, map);
        Function<SparseArray<Object>, Object> function = this.w;
        if (function != null) {
            function.apply(sparseArray);
        }
    }

    private BV3sI0 xj(String str) {
        if (Build.VERSION.SDK_INT < 26) {
            return new BV3sI0(this.hf, null);
        }
        try {
            return new BV3sI0(this.hf, str);
        } catch (NoSuchMethodError unused) {
            return new BV3sI0(this.hf, null);
        }
    }

    private Map<String, Object> xj(Map<String, Object> map) {
        Map<String, Object> map2;
        if (map == null || (map2 = (Map) map.get("params")) == null) {
            return null;
        }
        Map<String, Object> w = w(map2);
        Object obj = w.get("remote_views");
        Object obj2 = w.get("builder_content_type");
        int intValue = ((Integer) map2.get("notification_type")).intValue();
        String str = (String) map2.get("channel_id");
        int intValue2 = ((Integer) map2.get("download_status")).intValue();
        BV3sI0 xj2 = xj(str);
        xj2.f8551CikNvS.when = ((Long) map2.get("first_time")).longValue();
        Object obj3 = map2.get("notification_group");
        if (obj3 != null && (obj3 instanceof String)) {
            xj2.f8531BChYOn = (String) obj3;
            xj2.f8532BI9f7h = false;
        }
        xj2.ASJ6gh(new C2rE4F());
        Notification notification = xj2.f8551CikNvS;
        if (intValue == 1 || intValue == 4 || intValue == 2) {
            xj2.f8516ASJ6gh = (PendingIntent) w.get("apa_click_content_intent");
            xj2.A5SV6n(false);
        } else if (intValue == 3) {
            xj2.A5SV6n(true);
            if (intValue2 == -3) {
                Object obj4 = map2.get("auto_cancel");
                if ((obj4 instanceof Boolean) && ((Boolean) obj4).booleanValue()) {
                    xj2.A5SV6n(false);
                }
            }
            xj2.f8516ASJ6gh = (PendingIntent) w.get("complete_click_content_intent");
            notification.deleteIntent = (PendingIntent) w.get("hide_click_content_intent");
        }
        if (intValue == 3 && intValue2 == -3 && (obj2 instanceof String)) {
            xj2.f8515ARc23Z = BV3sI0.A4TApA((String) obj2);
        }
        Object obj5 = w.get("builder_small_icon");
        if (obj5 instanceof Integer) {
            notification.icon = ((Integer) obj5).intValue();
        }
        Notification A2egSU2 = xj2.A2egSU();
        A2egSU2.contentView = (RemoteViews) obj;
        w.put("notification", A2egSU2);
        return w;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0030, code lost:
    
        if (r4 == null) goto L17;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean hf(android.content.Context r4) {
        /*
            r0 = 0
            if (r4 != 0) goto L4
            return r0
        L4:
            java.lang.String r1 = "#7f0b0198"
            int r1 = android.graphics.Color.parseColor(r1)     // Catch: java.lang.Throwable -> L2f
            int r2 = com.bytedance.sdk.openadsdk.downloadnew.xj.xj()     // Catch: java.lang.Throwable -> L2f
            int r3 = com.bytedance.sdk.openadsdk.downloadnew.xj.hf()     // Catch: java.lang.Throwable -> L2f
            int[] r2 = new int[]{r2, r3}     // Catch: java.lang.Throwable -> L2f
            int r3 = com.bytedance.sdk.openadsdk.downloadnew.xj.w()     // Catch: java.lang.Throwable -> L2f
            android.content.res.TypedArray r4 = r4.obtainStyledAttributes(r3, r2)     // Catch: java.lang.Throwable -> L2f
            int r2 = r4.getColor(r0, r0)     // Catch: java.lang.Throwable -> L2d
            if (r1 != r2) goto L29
            r4.recycle()     // Catch: java.lang.Throwable -> L27
        L27:
            r4 = 1
            return r4
        L29:
            r4.recycle()     // Catch: java.lang.Throwable -> L33
            goto L33
        L2d:
            goto L30
        L2f:
            r4 = 0
        L30:
            if (r4 == 0) goto L33
            goto L29
        L33:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.openadsdk.downloadnew.w.hf(android.content.Context):boolean");
    }

    private boolean hf(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() >= 2;
    }

    private Pair<Intent, Boolean> xj(Context context, long j, boolean z) {
        if (z) {
            return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandleNotificationActivity.class), Boolean.TRUE);
        }
        return new Pair<>(new Intent(context, (Class<?>) ApiDownloadHandlerService.class), Boolean.FALSE);
    }

    private PendingIntent xj(String str, int i, int i2, boolean z, String str2) {
        Pair<Intent, Boolean> xj2 = xj(this.hf, i2, z);
        Intent intent = (Intent) xj2.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        return xj(this.hf, xj2, i2);
    }

    private PendingIntent xj(String str, int i, int i2, boolean z, String str2, String str3, String str4, String str5) {
        Pair<Intent, Boolean> xj2 = xj(this.hf, i2, z);
        Intent intent = (Intent) xj2.first;
        intent.setAction(str);
        intent.putExtra("extra_click_download_ids", i2);
        intent.putExtra("extra_click_download_type", i);
        intent.putExtra("extra_from_notification", true);
        intent.putExtra("extra_package_name", str2);
        intent.putExtra("extra_tag", str3);
        intent.putExtra("extra_value", str4);
        intent.putExtra("extra_log_extra", str5);
        return xj(this.hf, xj2, i2);
    }

    private PendingIntent xj(Context context, Pair<Intent, Boolean> pair, int i) {
        if (((Boolean) pair.second).booleanValue()) {
            return PendingIntent.getActivity(context, i, (Intent) pair.first, 201326592);
        }
        return PendingIntent.getService(context, i, (Intent) pair.first, 201326592);
    }

    private boolean xj(Object obj) {
        return (obj instanceof Integer) && ((Integer) obj).intValue() > 0;
    }

    private int xj(int i, boolean z) {
        if (z) {
            return xj.dk();
        }
        if (i == 1 || i == 4) {
            return xj.ht();
        }
        if (i == 2) {
            return xj.ra();
        }
        if (i == 3) {
            return xj.dk();
        }
        return 0;
    }

    public Uri xj(String str, String str2) {
        if (Build.VERSION.SDK_INT >= 24 && !TextUtils.isEmpty(str)) {
            return FileProvider.getUriForFile(this.hf, str, new File(str2));
        }
        return Uri.fromFile(new File(str2));
    }
}
