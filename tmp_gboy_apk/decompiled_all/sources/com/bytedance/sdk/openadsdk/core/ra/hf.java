package com.bytedance.sdk.openadsdk.core.ra;

import java.util.ArrayList;
import java.util.Collection;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class hf {
    private int c;
    private long d;
    private long f;
    public int hf;
    public ArrayList<Integer> kd;
    private long p;

    /* renamed from: pl, reason: collision with root package name */
    private JSONObject f10407pl;
    private long tf;
    public String u;
    public int w = 1;
    public String xj;
    public com.bytedance.sdk.openadsdk.zg.w.w.hf y;

    public com.bytedance.sdk.openadsdk.zg.w.w.hf c() {
        return this.y;
    }

    public long d() {
        return this.f;
    }

    public ArrayList<Integer> f() {
        return this.kd;
    }

    public int hf() {
        return this.hf;
    }

    public JSONObject kd() {
        return this.f10407pl;
    }

    public long p() {
        return this.tf;
    }

    public long pl() {
        return this.p;
    }

    public long tf() {
        return this.d;
    }

    public String u() {
        return this.u;
    }

    public int w() {
        return this.c;
    }

    public String xj() {
        return this.xj;
    }

    public int y() {
        return this.w;
    }

    public void hf(int i) {
        this.c = i;
    }

    public void u(long j) {
        this.p = j;
    }

    public void w(int i) {
        this.w = i;
    }

    public void xj(String str) {
        this.xj = str;
    }

    public void hf(String str) {
        this.u = str;
    }

    public void w(long j) {
        this.tf = j;
    }

    public void xj(int i) {
        this.hf = i;
    }

    public void hf(long j) {
        this.d = j;
    }

    public void xj(JSONObject jSONObject) {
        this.f10407pl = jSONObject;
    }

    public void xj(com.bytedance.sdk.openadsdk.zg.w.w.hf hfVar) {
        this.y = hfVar;
    }

    public void xj(ArrayList<Integer> arrayList) {
        this.kd = arrayList;
    }

    public static void xj(hf hfVar) {
        int hf;
        if (hfVar == null || hfVar.c() == null || (hf = hfVar.hf()) >= 0 || hf == -8) {
            return;
        }
        com.bytedance.sdk.openadsdk.core.ht.am.xj().hf(new com.bytedance.sdk.openadsdk.p.xj.xj() { // from class: com.bytedance.sdk.openadsdk.core.ra.hf.1
            @Override // com.bytedance.sdk.openadsdk.p.xj.xj
            public com.bytedance.sdk.openadsdk.core.ht.xj.xj xj() {
                JSONObject kd = hf.this.kd();
                if (kd == null) {
                    kd = new JSONObject();
                }
                kd.put("from", hf.this.y());
                kd.put("err_code", hf.this.hf());
                kd.put("err_msg", hf.this.u());
                kd.put("server_res_str", hf.this.xj());
                if (hf.this.f() != null && hf.this.f().size() > 0) {
                    kd.put("mate_unavailable_code_list", new JSONArray((Collection) hf.this.f()).toString());
                }
                com.bytedance.sdk.component.utils.pl.xj("AdLogInfoModel", "rd_client_custom_error = ", kd);
                return com.bytedance.sdk.openadsdk.core.ht.xj.hf.hf().xj("rd_client_custom_error").xj(hf.this.c().jk()).hf(kd.toString());
            }
        }, "rd_client_custom_error");
    }

    public void xj(long j) {
        this.f = j;
    }
}
