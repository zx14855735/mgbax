package com.bytedance.sdk.component.xj;

import ADYaiT.CtFAbx;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.component.sdk.annotation.AnyThread;
import com.bytedance.component.sdk.annotation.MainThread;
import com.bytedance.sdk.component.xj.c;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class xj {
    c c;
    protected g hf;
    protected String kd;
    protected f w;
    protected Context xj;
    protected Handler u = new Handler(Looper.getMainLooper());
    protected volatile boolean y = false;
    private final Map<String, c> f = new HashMap();

    public abstract Context getContext(tf tfVar);

    public void hf() {
        this.c.xj();
        Iterator<c> it = this.f.values().iterator();
        while (it.hasNext()) {
            it.next().xj();
        }
        this.u.removeCallbacksAndMessages(null);
        this.y = true;
    }

    public void invokeMethod(final String str) {
        if (this.y) {
            return;
        }
        d.xj("Received call: ".concat(String.valueOf(str)));
        this.u.post(new Runnable() { // from class: com.bytedance.sdk.component.xj.xj.1
            @Override // java.lang.Runnable
            public void run() {
                zg zgVar;
                if (xj.this.y) {
                    return;
                }
                try {
                    zgVar = xj.this.xj(new JSONObject(str));
                } catch (Exception e) {
                    d.hf("Exception thrown while parsing function.", e);
                    zgVar = null;
                }
                if (!zg.xj(zgVar)) {
                    xj.this.xj(zgVar);
                    return;
                }
                d.xj("By pass invalid call: ".concat(String.valueOf(zgVar)));
                if (zgVar != null) {
                    xj.this.hf(dk.xj(new yo(zgVar.xj, "Failed to parse invocation.")), zgVar);
                }
            }
        });
    }

    public abstract String xj();

    public abstract void xj(tf tfVar);

    @AnyThread
    public abstract void xj(String str);

    public void xj(String str, zg zgVar) {
        xj(str);
    }

    @MainThread
    public final void xj(zg zgVar) {
        String xj;
        if (this.y || (xj = xj()) == null) {
            return;
        }
        c hf = hf(zgVar.c);
        if (hf == null) {
            d.hf("Received call with unknown namespace, ".concat(String.valueOf(zgVar)));
            if (this.hf != null) {
                xj();
            }
            hf(dk.xj(new yo(-4, CtFAbx.B25kr6(new StringBuilder("Namespace "), zgVar.c, " unknown."))), zgVar);
            return;
        }
        y yVar = new y();
        yVar.hf = xj;
        yVar.xj = this.xj;
        yVar.w = hf;
        try {
            c.xj xj2 = hf.xj(zgVar, yVar);
            if (xj2 == null) {
                d.hf("Received call but not registered, ".concat(String.valueOf(zgVar)));
                if (this.hf != null) {
                    xj();
                }
                hf(dk.xj(new yo(-2, "Function " + zgVar.u + " is not registered.")), zgVar);
                return;
            }
            if (xj2.xj) {
                hf(xj2.hf, zgVar);
            }
            if (this.hf != null) {
                xj();
            }
        } catch (Exception e) {
            d.xj("call finished with error, ".concat(String.valueOf(zgVar)), e);
            hf(dk.xj(e), zgVar);
        }
    }

    public final void hf(String str, zg zgVar) {
        JSONObject jSONObject;
        if (this.y) {
            return;
        }
        if (TextUtils.isEmpty(zgVar.y)) {
            d.xj("By passing js callback due to empty callback: ".concat(String.valueOf(str)));
            return;
        }
        if (!str.startsWith("{") || !str.endsWith("}")) {
            d.xj(new IllegalArgumentException("Illegal callback data: ".concat(str)));
        }
        d.xj("Invoking js callback: " + zgVar.y);
        try {
            jSONObject = new JSONObject(str);
        } catch (Exception unused) {
            jSONObject = new JSONObject();
        }
        xj(qt.xj().xj("__msg_type", "callback").xj("__callback_id", zgVar.y).xj("__params", jSONObject).hf(), zgVar);
    }

    private c hf(String str) {
        if (!TextUtils.equals(str, this.kd) && !TextUtils.isEmpty(str)) {
            return this.f.get(str);
        }
        return this.c;
    }

    public final void xj(tf tfVar, pz pzVar) {
        this.xj = getContext(tfVar);
        this.w = tfVar.u;
        this.hf = tfVar.d;
        this.c = new c(tfVar, this, pzVar);
        this.kd = tfVar.p;
        xj(tfVar);
    }

    public final <T> void xj(String str, T t) {
        if (this.y) {
            return;
        }
        String xj = this.w.xj((f) t);
        d.xj("Sending js event: ".concat(String.valueOf(str)));
        xj("{\"__msg_type\":\"event\",\"__event_id\":\"" + str + "\",\"__params\":" + xj + "}");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public zg xj(JSONObject jSONObject) {
        String optString;
        Object opt;
        if (this.y) {
            return null;
        }
        String optString2 = jSONObject.optString("__callback_id");
        String optString3 = jSONObject.optString("func");
        if (xj() == null) {
            return null;
        }
        try {
            String string = jSONObject.getString("__msg_type");
            String str = "";
            try {
                opt = jSONObject.opt("params");
            } catch (Throwable unused) {
                optString = jSONObject.optString("params");
            }
            if (opt != null) {
                if (opt instanceof JSONObject) {
                    optString = String.valueOf((JSONObject) opt);
                    String string2 = jSONObject.getString("JSSDK");
                    String optString4 = jSONObject.optString("namespace");
                    return zg.xj().xj(string2).hf(string).w(optString3).u(optString).kd(optString2).y(optString4).c(jSONObject.optString("__iframe_url")).xj();
                }
                if (opt instanceof String) {
                    str = (String) opt;
                } else {
                    str = String.valueOf(opt);
                }
            }
            optString = str;
            String string22 = jSONObject.getString("JSSDK");
            String optString42 = jSONObject.optString("namespace");
            return zg.xj().xj(string22).hf(string).w(optString3).u(optString).kd(optString2).y(optString42).c(jSONObject.optString("__iframe_url")).xj();
        } catch (JSONException e) {
            d.hf("Failed to create call.", e);
            return zg.xj(optString2, -1);
        }
    }
}
