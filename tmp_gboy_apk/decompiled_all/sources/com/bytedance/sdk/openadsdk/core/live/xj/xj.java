package com.bytedance.sdk.openadsdk.core.live.xj;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.SparseArray;
import com.bytedance.sdk.component.utils.pl;
import com.bytedance.sdk.openadsdk.core.a.b;
import com.bytedance.sdk.openadsdk.core.a.wo;
import com.bytedance.sdk.openadsdk.core.ht.am;
import com.bytedance.sdk.openadsdk.core.pz;
import com.bytedance.sdk.openadsdk.core.ra.ht;
import com.bytedance.sdk.openadsdk.core.ra.ws;
import com.bytedance.sdk.openadsdk.core.ra.zg;
import java.util.Iterator;
import java.util.Map;
import java.util.function.Function;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public abstract class xj implements u {
    protected volatile String hf;
    protected JSONObject w;
    protected volatile Function<SparseArray<Object>, Object> xj = null;

    public void a_(String str) {
    }

    public long hf(ws wsVar) {
        if (wsVar == null) {
            return 0L;
        }
        String wr = wsVar.wr();
        if (TextUtils.isEmpty(wr)) {
            wr = xj(wsVar.yt());
        }
        try {
            return Long.parseLong(wr);
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void u(ws wsVar) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public long w() {
        return -1L;
    }

    public abstract boolean x_();

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj() {
    }

    public boolean a_(ws wsVar) {
        if (wsVar == null) {
            return false;
        }
        return xj(wsVar.wr(), wsVar.vu());
    }

    public int w(ws wsVar) {
        zg yt;
        if (1 != com.bytedance.sdk.openadsdk.core.live.hf.xj().kd()) {
            return 2;
        }
        if (!com.bytedance.sdk.openadsdk.core.live.kd.xj.xj(wsVar)) {
            return 3;
        }
        if (wsVar != null && wo.hf(pz.getContext()) && (yt = wsVar.yt()) != null) {
            String hf = yt.hf();
            if (!TextUtils.isEmpty(hf)) {
                Uri parse = Uri.parse(hf);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(parse);
                return wo.hf(pz.getContext(), intent, true) ? 0 : 4;
            }
        }
        return 0;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(String str, ws wsVar, long j) {
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public void xj(Function<SparseArray<Object>, Object> function) {
        if (function == null) {
            return;
        }
        this.xj = function;
    }

    @Override // com.bytedance.sdk.openadsdk.core.live.xj.u
    public boolean xj(String str, int i) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            if (Long.parseLong(str) <= 0) {
                return false;
            }
            switch (i) {
            }
            return false;
        }
    }

    public String xj(zg zgVar) {
        Map<String, String> xj;
        if (zgVar == null) {
            return null;
        }
        String hf = zgVar.hf();
        if (TextUtils.isEmpty(hf)) {
            return null;
        }
        if ((hf.startsWith("snssdk2329") || hf.startsWith("snssdk1128")) && (xj = b.xj(hf)) != null) {
            return xj.get("room_id");
        }
        return null;
    }

    public String xj(ws wsVar, String str, Map map) {
        if (map != null) {
            try {
                String str2 = (String) map.get("dpa_tag");
                if (!TextUtils.isEmpty(str2)) {
                    String kd = ht.kd(wsVar, str2);
                    if (!TextUtils.isEmpty(kd)) {
                        JSONObject jSONObject = new JSONObject(str);
                        JSONObject jSONObject2 = new JSONObject(kd);
                        Iterator<String> keys = jSONObject2.keys();
                        while (keys.hasNext()) {
                            String next = keys.next();
                            jSONObject.putOpt(next, jSONObject2.opt(next));
                        }
                        return jSONObject.toString();
                    }
                }
            } catch (Exception e) {
                pl.hf("TTLiveSDkBridge", e);
                am.xj().xj("getEcomLiveParams", e);
                return str;
            }
        }
        return str;
    }

    public void xj(ws wsVar, String str, int i, int i2, int i3) {
        com.bytedance.sdk.openadsdk.core.am.u.xj(wsVar, str, i, i2, i3, x_());
    }

    public boolean xj(ws wsVar, int i) {
        return wsVar.vu() == 7 || i == 103;
    }
}
