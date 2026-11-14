package com.bytedance.sdk.component.panglearmor.hf;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.bytedance.sdk.component.panglearmor.SoftDecTool;
import com.kuaishou.weapon.p0.bi;
import com.kwad.components.core.s.t;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class hf {
    private static volatile hf xj;
    private SharedPreferences hf;
    private LinkedList<JSONObject> kd;
    private LinkedList<JSONObject> u;
    private LinkedList<JSONObject> w;
    private long y;

    public hf() {
        this.hf = null;
        this.w = null;
        this.u = null;
        this.kd = null;
        this.y = 0L;
        this.hf = SoftDecTool.getSharedPreferences("pithar");
        this.w = w("sp_angle");
        this.u = w("sp_screen");
        this.kd = w("sp_net");
        this.y = kd.xj().w() / kd.xj().u();
    }

    private LinkedList<JSONObject> w(String str) {
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        SharedPreferences sharedPreferences = this.hf;
        if (sharedPreferences != null) {
            String string = sharedPreferences.getString(str, "");
            if (!TextUtils.isEmpty(string)) {
                for (String str2 : string.split("\\|")) {
                    if (!TextUtils.isEmpty(str2)) {
                        try {
                            linkedList.add(new JSONObject(str2));
                        } catch (Exception unused) {
                        }
                    }
                }
            }
        }
        return linkedList;
    }

    public static hf xj() {
        if (xj == null) {
            synchronized (hf.class) {
                try {
                    if (xj == null) {
                        xj = new hf();
                    }
                } finally {
                }
            }
        }
        return xj;
    }

    public synchronized void hf(String str) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            if ("android.intent.action.SCREEN_OFF".equals(str)) {
                LinkedList<JSONObject> xj2 = xj("sp_screen");
                int i = 1;
                if (xj2 != null && xj2.size() > 0) {
                    JSONObject last = xj2.getLast();
                    if (last.optLong(t.TAG, 0L) / bi.s == currentTimeMillis / bi.s) {
                        i = 1 + last.optInt("val", 0);
                        xj2.removeLast();
                    }
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put(t.TAG, currentTimeMillis);
                    jSONObject.put("val", i);
                    xj(jSONObject, "sp_screen");
                } catch (JSONException e) {
                    throw new RuntimeException(e);
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public LinkedList<JSONObject> xj(String str) {
        if ("sp_angle".equals(str)) {
            return this.w;
        }
        if ("sp_screen".equals(str)) {
            return this.u;
        }
        if ("sp_net".equals(str)) {
            return this.kd;
        }
        return null;
    }

    public void xj(JSONObject jSONObject, String str) {
        LinkedList<JSONObject> xj2 = xj(str);
        if (xj2 == null) {
            return;
        }
        xj2.add(jSONObject);
        if (xj2.size() > this.y) {
            xj2.removeFirst();
        }
        long currentTimeMillis = System.currentTimeMillis();
        long w = currentTimeMillis - kd.xj().w();
        Iterator<JSONObject> it = xj2.iterator();
        JSONObject jSONObject2 = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            long optLong = next.optLong(t.TAG, 0L);
            if (optLong < w) {
                it.remove();
                jSONObject2 = next;
            } else if (optLong > currentTimeMillis) {
                it.remove();
            }
        }
        if (jSONObject2 != null && xj2.size() < 2) {
            xj2.addFirst(jSONObject2);
        }
        xj(str, xj2);
    }

    public synchronized void xj(int i) {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            int i2 = i == 4 ? 1 : i > 0 ? 2 : 0;
            LinkedList<JSONObject> xj2 = xj("sp_net");
            if (xj2 != null && xj2.size() > 0) {
                JSONObject last = xj2.getLast();
                if (last.optLong(t.TAG, 0L) / bi.s == currentTimeMillis / bi.s) {
                    i2 |= last.optInt("val", 0);
                    xj2.removeLast();
                }
            }
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(t.TAG, currentTimeMillis);
                jSONObject.put("val", i2);
                xj(jSONObject, "sp_net");
            } catch (JSONException e) {
                throw new RuntimeException(e);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void xj(String str, LinkedList<JSONObject> linkedList) {
        if (linkedList == null || this.hf == null) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator<JSONObject> it = linkedList.iterator();
        while (it.hasNext()) {
            sb.append(it.next().toString());
            sb.append("\\|");
        }
        SharedPreferences.Editor edit = this.hf.edit();
        edit.putString(str, sb.toString());
        edit.apply();
    }

    public LinkedList<JSONObject> xj(long j) {
        if (j == 0) {
            return this.w;
        }
        LinkedList<JSONObject> linkedList = new LinkedList<>();
        long currentTimeMillis = System.currentTimeMillis();
        Iterator<JSONObject> it = this.w.iterator();
        JSONObject jSONObject = null;
        while (it.hasNext()) {
            JSONObject next = it.next();
            if (currentTimeMillis - next.optLong(t.TAG, 0L) < j) {
                linkedList.add(next);
            } else {
                jSONObject = next;
            }
        }
        if (jSONObject != null && linkedList.size() < 2) {
            linkedList.addFirst(jSONObject);
        }
        return linkedList;
    }
}
