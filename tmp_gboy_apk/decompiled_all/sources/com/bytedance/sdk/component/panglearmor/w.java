package com.bytedance.sdk.component.panglearmor;

import android.app.Activity;
import android.app.Application;
import android.util.ArrayMap;
import com.bytedance.android.live.base.api.push.model.PushUIConfig;
import com.bytedance.pangle.annotations.ForbidWrapParam;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class w {
    private static volatile w xj;
    private final ArrayList<String> hf = new ArrayList<>();
    private final AtomicBoolean w = new AtomicBoolean(false);
    private long u = System.currentTimeMillis();
    private long kd = 0;
    private long y = 0;
    private String c = "";
    private String f = "";
    private String d = "";
    private boolean tf = false;
    private boolean p = false;

    public static w xj(Application application) {
        if (xj == null) {
            synchronized (w.class) {
                try {
                    if (xj == null) {
                        w wVar = new w();
                        xj = wVar;
                        wVar.tf = tf.xj(application);
                        xj.p = tf.xj(application.getApplicationContext(), "android.permission.SYSTEM_ALERT_WINDOW") == 0;
                        xj.xj();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public void hf(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.hf.contains(localClassName)) {
            this.hf.remove(localClassName);
        }
        if (this.hf.size() == 0) {
            this.u = System.currentTimeMillis();
            this.w.set(true);
            this.f = localClassName;
        }
    }

    public void xj(@ForbidWrapParam Activity activity) {
        String localClassName = activity.getLocalClassName();
        if (this.hf.size() == 0) {
            this.c = localClassName;
            this.kd = System.currentTimeMillis();
            this.y = System.currentTimeMillis() - this.u;
            this.w.set(false);
        }
        if (!this.hf.contains(localClassName)) {
            this.hf.add(localClassName);
        }
        this.d = localClassName;
    }

    private void xj() {
        int size;
        boolean z = true;
        try {
            Class<?> cls = Class.forName("android.app.ActivityThread");
            Method declaredMethod = cls.getDeclaredMethod("currentActivityThread", new Class[0]);
            declaredMethod.setAccessible(true);
            Object invoke = declaredMethod.invoke(null, new Object[0]);
            Field declaredField = cls.getDeclaredField("mActivities");
            declaredField.setAccessible(true);
            ArrayMap arrayMap = (ArrayMap) declaredField.get(invoke);
            if (arrayMap != null && (size = arrayMap.size()) > 0) {
                Class<?> cls2 = Class.forName("android.app.ActivityThread$ActivityClientRecord");
                Field declaredField2 = cls2.getDeclaredField("stopped");
                declaredField2.setAccessible(true);
                Field declaredField3 = cls2.getDeclaredField(TTDownloadField.TT_ACTIVITY);
                declaredField3.setAccessible(true);
                for (int i = 0; i < size; i++) {
                    Object valueAt = arrayMap.valueAt(i);
                    if (!((Boolean) declaredField2.get(valueAt)).booleanValue()) {
                        String localClassName = ((Activity) declaredField3.get(valueAt)).getLocalClassName();
                        if (!this.hf.contains(localClassName)) {
                            this.hf.add(localClassName);
                        }
                    }
                }
                AtomicBoolean atomicBoolean = this.w;
                if (this.hf.size() > 0) {
                    z = false;
                }
                atomicBoolean.set(z);
            }
        } catch (Exception unused) {
        }
    }

    public String xj(String str, long j, int i, boolean z) {
        String str2;
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = currentTimeMillis - this.kd;
        long j3 = currentTimeMillis - j;
        int i2 = j3 < 500 ? 1 : 0;
        if (this.w.get() && this.p) {
            i2 |= 2;
        }
        if (!this.w.get() && this.y >= PushUIConfig.dismissTime && j2 < 1000) {
            i2 = this.f.equals(this.d) ? i2 | 4 : i2 | 8;
        }
        try {
            str2 = new JSONObject().put("rst", i2).put("bakdur", this.y).put("popt", j2).put("uct", j3).put("isbak", this.w).put("alert", this.p).put("rit", i).put("tag", str).put("sys", this.tf).put("size", this.hf.size()).put("mutipro", z).toString();
        } catch (JSONException unused) {
            str2 = "";
        }
        this.c = "";
        this.y = 0L;
        this.kd = 0L;
        this.u = System.currentTimeMillis();
        return str2;
    }
}
