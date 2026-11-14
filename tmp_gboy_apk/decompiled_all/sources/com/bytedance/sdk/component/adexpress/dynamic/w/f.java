package com.bytedance.sdk.component.adexpress.dynamic.w;

import android.text.TextUtils;
import com.bykv.vk.component.ttvideo.ILivePlayer;
import com.sigmob.sdk.base.mta.PointType;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class f {
    private boolean am;
    private float c;
    private kd d;
    private float f;
    private String g;
    private float hf;
    private float kd;
    private f p;

    /* renamed from: pl, reason: collision with root package name */
    private List<List<f>> f10180pl;
    private List<f> tf;
    private float u;
    private float w;
    private String xj;
    private float y;
    private Map<String, String> qt = new HashMap();
    private Map<Integer, String> zg = new HashMap();

    public int am() {
        y kd = this.d.kd();
        return kd.hl() + kd.yy();
    }

    public float c() {
        return this.w;
    }

    public float d() {
        return this.c;
    }

    public boolean dk() {
        return this.d.kd().ne() < 0 || this.d.kd().se() < 0 || this.d.kd().vl() < 0 || this.d.kd().h() < 0;
    }

    public List<List<f>> e() {
        return this.f10180pl;
    }

    public float f() {
        return this.y;
    }

    public int g() {
        y kd = this.d.kd();
        return kd.dc() + kd.vm();
    }

    public Map<Integer, String> hf() {
        return this.zg;
    }

    public boolean ht() {
        return TextUtils.equals(this.d.kd().ai(), "flex");
    }

    public Map<String, String> jk() {
        return this.qt;
    }

    public float kd() {
        return this.kd;
    }

    public List<f> p() {
        return this.tf;
    }

    public f pl() {
        return this.p;
    }

    public void pz() {
        List<List<f>> list = this.f10180pl;
        if (list == null || list.size() <= 0) {
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (List<f> list2 : this.f10180pl) {
            if (list2 != null && list2.size() > 0) {
                arrayList.add(list2);
            }
        }
        this.f10180pl = arrayList;
    }

    public float qt() {
        y kd = this.d.kd();
        return (kd.pl() * 2.0f) + kd.zg() + kd.qt() + g();
    }

    public String ra() {
        return this.d.kd().ra();
    }

    public kd tf() {
        return this.d;
    }

    public String toString() {
        return "DynamicLayoutUnit{id='" + this.xj + "', x=" + this.hf + ", y=" + this.w + ", width=" + this.y + ", height=" + this.c + ", remainWidth=" + this.f + ", rootBrick=" + this.d + ", childrenBrickUnits=" + this.tf + '}';
    }

    public float u() {
        return this.u;
    }

    public boolean v() {
        return this.am;
    }

    public String w() {
        return this.xj;
    }

    public String xj() {
        return this.g;
    }

    public float y() {
        return this.hf;
    }

    public boolean yo() {
        List<f> list = this.tf;
        return list == null || list.size() <= 0;
    }

    public float zg() {
        y kd = this.d.kd();
        return (kd.pl() * 2.0f) + kd.am() + kd.e() + am();
    }

    public void c(float f) {
        this.f = f;
    }

    public void hf(String str) {
        this.xj = str;
    }

    public void kd(float f) {
        this.y = f;
    }

    public void u(float f) {
        this.w = f;
    }

    public void w(float f) {
        this.hf = f;
    }

    public void xj(String str) {
        this.g = str;
    }

    public void y(float f) {
        this.c = f;
    }

    public void hf(float f) {
        this.kd = f;
    }

    public void w(String str) {
        this.d.kd().y(str);
    }

    public void xj(JSONArray jSONArray) {
        if (jSONArray != null) {
            try {
                if (jSONArray.length() == 0) {
                    return;
                }
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    this.zg.put(Integer.valueOf(optJSONObject.optInt(com.sigmob.sdk.downloader.core.breakpoint.f.f13353a)), optJSONObject.optString("value"));
                }
            } catch (Throwable unused) {
            }
        }
    }

    public void hf(List<List<f>> list) {
        this.f10180pl = list;
    }

    public void xj(float f) {
        this.u = f;
    }

    public void xj(kd kdVar) {
        this.d = kdVar;
    }

    public void xj(List<f> list) {
        this.tf = list;
    }

    public void xj(f fVar) {
        this.p = fVar;
    }

    public void xj(boolean z) {
        this.am = z;
    }

    public void xj(String str, String str2) {
        this.qt.put(str, str2);
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public String xj(int i) {
        char c;
        int i2;
        StringBuilder sb = new StringBuilder();
        sb.append(this.d.getType());
        sb.append(":");
        sb.append(this.xj);
        if (this.d.kd() != null) {
            sb.append(":");
            sb.append(this.d.kd().qi());
        }
        sb.append(":");
        sb.append(i);
        if (this.d.kd() != null) {
            sb.append(":");
            String wo = this.d.kd().wo();
            wo.getClass();
            switch (wo.hashCode()) {
                case ILivePlayer.LIVE_PLAYER_OPTION_PLAY_URL /* 57 */:
                    if (wo.equals("9")) {
                        c = 0;
                        break;
                    }
                    c = 65535;
                    break;
                case 1573:
                    if (wo.equals("16")) {
                        c = 1;
                        break;
                    }
                    c = 65535;
                    break;
                case 1607:
                    if (wo.equals("29")) {
                        c = 2;
                        break;
                    }
                    c = 65535;
                    break;
                default:
                    c = 65535;
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                case 2:
                    i2 = 1;
                    break;
                default:
                    i2 = 0;
                    break;
            }
            String wo2 = this.d.kd().wo();
            wo2.getClass();
            if (wo2.equals(PointType.LOAD_READY) || wo2.equals("18")) {
                i2 = (i2 * 10) + 2;
            }
            String wo3 = this.d.kd().wo();
            wo3.getClass();
            switch (wo3) {
                case "0":
                case "5":
                case "10":
                case "12":
                case "13":
                case "20":
                case "22":
                case "24":
                case "29":
                    i2 = (i2 * 10) + 3;
                    break;
            }
            sb.append(i2);
        }
        return sb.toString();
    }
}
