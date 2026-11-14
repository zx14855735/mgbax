package com.bytedance.sdk.component.panglearmor;

import android.app.Application;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.view.MotionEvent;
import com.bykv.vk.component.ttvideo.mediakit.medialoader.AVMDLDataLoader;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.api.plugin.PluginConstants;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class y {
    private static c tf;
    private static String xj;
    private static AtomicBoolean hf = new AtomicBoolean(false);
    private static final AtomicBoolean w = new AtomicBoolean(false);
    private static String u = "";
    private static long kd = 0;
    private static int y = 0;
    private static hf c = null;
    private static volatile DisplayManager.DisplayListener f = null;
    private static volatile boolean d = false;

    static {
        jJDXFFs();
    }

    public static f c() {
        c cVar = tf;
        if (cVar != null) {
            return cVar.u();
        }
        return null;
    }

    public static int d() {
        return y;
    }

    public static long f() {
        return kd;
    }

    public static String hf() {
        if (d.hf() && tf != null) {
            final Handler xj2 = com.bytedance.sdk.component.utils.f.xj();
            final f c2 = c();
            xj2.post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.y.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        if (!y.w.get()) {
                            hf unused = y.c = hf.xj((Application) y.tf.xj());
                            y.hf(xj2);
                        }
                        kd.xj(y.tf.xj());
                        if (SoftDecTool.acs == -1.0d) {
                            SoftDecTool.ua();
                        }
                        Object xj3 = y.xj(1001, new Object[]{y.tf.xj()});
                        if (xj3 instanceof String) {
                            String unused2 = y.u = (String) xj3;
                        }
                    } catch (Throwable th) {
                        String unused3 = y.u = y.hf(th);
                    }
                    if (c2 == null || y.hf.getAndSet(true)) {
                        return;
                    }
                    JSONObject xj4 = com.bytedance.sdk.component.panglearmor.xj.xj.xj().xj(y.tf.xj(), y.tf.hf());
                    if (xj4 != null && xj4.length() > 0) {
                        c2.xj("detailed_app_info", xj4);
                    }
                    y.hf.set(false);
                }
            });
        }
        if (TextUtils.isEmpty(u)) {
            String gc = SoftDecTool.gc();
            if (!TextUtils.isEmpty(gc)) {
                u = gc;
            }
        }
        return TextUtils.isEmpty(u) ? "eyJzdHRzIjoxfQ==" : u;
    }

    private static /* synthetic */ void jJDXFFs() {
        char[] charArray = "ÃÏÍ\u008eÇÁÍÅ\u008eÂÏÙ\u008eÓÈÅÌÌ\u008eêÎÉâÒÉÄÇÅ".toCharArray();
        int length = charArray.length;
        for (int i = 0; i < length; i++) {
            charArray[i] = (char) (charArray[i] ^ 160);
        }
        String str = new String(charArray);
        char[] charArray2 = "ÃÌÉÎÉÔ".toCharArray();
        int length2 = charArray2.length;
        for (int i2 = 0; i2 < length2; i2++) {
            charArray2[i2] = (char) (charArray2[i2] ^ 160);
        }
        Method declaredMethod = Class.forName(str).getDeclaredMethod(new String(charArray2), new Class[0]);
        declaredMethod.setAccessible(true);
        declaredMethod.invoke(null, new Object[0]);
    }

    public static boolean kd() {
        c cVar = tf;
        if (cVar != null) {
            return cVar.w();
        }
        return false;
    }

    public static Context u() {
        c cVar = tf;
        if (cVar != null) {
            return cVar.xj();
        }
        return null;
    }

    public static String w() {
        if (xj == null) {
            Object xj2 = xj(AVMDLDataLoader.KeyIsGetCostLog, new Object[0]);
            if (xj2 instanceof String) {
                xj = (String) xj2;
            }
        }
        String str = xj;
        return str != null ? str : "";
    }

    public static String y() {
        c cVar = tf;
        if (cVar != null) {
            return cVar.hf();
        }
        return null;
    }

    public static void xj(c cVar) {
        tf = cVar;
    }

    public static void xj() {
        try {
            Context u2 = u();
            if (!kd() || w.getAndSet(true) || u2 == null) {
                return;
            }
            if (c != null) {
                hf.xj((Application) u2).hf((Application) u2);
                c = null;
            }
            if (f != null) {
                ((DisplayManager) u2.getSystemService("display")).unregisterDisplayListener(f);
                d = false;
                f = null;
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void hf(Handler handler) {
        if (!d.hf() || d || u() == null) {
            return;
        }
        d = true;
        if (f == null) {
            f = new DisplayManager.DisplayListener() { // from class: com.bytedance.sdk.component.panglearmor.y.2
                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayAdded(int i) {
                    if (i != 0) {
                        try {
                            y.xj(1003, new Object[]{Integer.valueOf(i), y.u()});
                        } catch (Throwable th) {
                            pl.xj(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayChanged(int i) {
                    if (i != 0) {
                        try {
                            y.xj(1005, new Object[]{Integer.valueOf(i), y.u()});
                        } catch (Throwable th) {
                            pl.xj(th);
                        }
                    }
                }

                @Override // android.hardware.display.DisplayManager.DisplayListener
                public void onDisplayRemoved(int i) {
                    if (i != 0) {
                        try {
                            y.xj(PluginConstants.ERROR_PLUGIN_DOWNLOAD, new Object[]{Integer.valueOf(i), y.u()});
                        } catch (Throwable th) {
                            pl.xj(th);
                        }
                    }
                }
            };
        }
        ((DisplayManager) u().getSystemService("display")).registerDisplayListener(f, handler);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String hf(Throwable th) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("stts", 3);
            jSONObject.put("exception:", th.toString());
            jSONObject.put("stacktrace:", Arrays.toString(th.getStackTrace()));
            jSONObject.put("cause:", String.valueOf(th.getCause()));
            u = Base64.encodeToString(jSONObject.toString().getBytes("UTF-8"), 0);
        } catch (Throwable th2) {
            pl.xj(th2);
            u = "eyJzdHRzIjozfQ==";
        }
        return u;
    }

    public static Object xj(int i, Object[] objArr) {
        return SoftDecTool.cn(i, objArr);
    }

    public static void xj(final MotionEvent motionEvent) {
        if (motionEvent == null || !d.hf() || u() == null) {
            return;
        }
        if (motionEvent.getRawX() > 0.0f || motionEvent.getRawY() > 0.0f) {
            com.bytedance.sdk.component.utils.f.xj().post(new Runnable() { // from class: com.bytedance.sdk.component.panglearmor.y.3
                @Override // java.lang.Runnable
                public void run() {
                    y.xj(1002, new Object[]{Integer.valueOf(motionEvent.getDeviceId()), y.u()});
                }
            });
        }
    }

    public static void xj(long j, int i) {
        kd = j;
        y = i;
    }

    public static String xj(String str, long j, int i, boolean z) {
        try {
            hf hfVar = c;
            if (hfVar != null) {
                return hfVar.xj(str, j, i, z);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static String xj(String str, String str2) {
        Object xj2 = xj(1010, new String[]{str, str2});
        return xj2 instanceof String ? (String) xj2 : str2;
    }
}
