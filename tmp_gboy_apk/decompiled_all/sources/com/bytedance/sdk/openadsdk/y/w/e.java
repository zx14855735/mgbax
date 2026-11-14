package com.bytedance.sdk.openadsdk.y.w;

import com.bytedance.sdk.openadsdk.core.ra.ws;
import java.util.Map;
import org.json.JSONArray;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class e {
    private String hf;
    private ws kd;
    private com.bykv.vk.openvk.component.video.api.w.u u;
    private int w;
    private long xj;

    public static class xj {
        private JSONArray am;
        private int d;
        private int f;
        private int p;

        /* renamed from: pl, reason: collision with root package name */
        private int f10478pl;
        private Map<String, Object> qt;
        private int tf;
        private long xj = 0;
        private long hf = 0;
        private long w = 0;
        private boolean u = false;
        private boolean kd = false;
        private int y = 0;
        private int c = 0;
        private boolean g = false;

        public boolean am() {
            return this.u;
        }

        public int c() {
            return this.f;
        }

        public int d() {
            long j = this.w;
            if (j <= 0) {
                return 0;
            }
            return Math.min((int) ((this.xj * 100) / j), 100);
        }

        public int f() {
            return this.d;
        }

        public boolean g() {
            return this.g;
        }

        public long hf() {
            return this.xj;
        }

        public int kd() {
            return this.y;
        }

        public int p() {
            return this.p;
        }

        public int pl() {
            return this.f10478pl;
        }

        public boolean qt() {
            return this.kd;
        }

        public int tf() {
            return this.tf;
        }

        public long u() {
            return this.w;
        }

        public long w() {
            return this.hf;
        }

        public void xj(JSONArray jSONArray) {
            this.am = jSONArray;
        }

        public int y() {
            return this.c;
        }

        public Map<String, Object> zg() {
            return this.qt;
        }

        public void hf(long j) {
            this.hf = j;
        }

        public void kd(int i) {
            this.tf = i;
        }

        public void u(int i) {
            this.d = i;
        }

        public void w(long j) {
            this.w = j;
        }

        public JSONArray xj() {
            return this.am;
        }

        public void y(int i) {
            this.f10478pl = i;
        }

        public void hf(int i) {
            this.c = i;
        }

        public void w(int i) {
            this.f = i;
        }

        public void xj(long j) {
            this.xj = j;
        }

        public void hf(boolean z) {
            this.u = z;
        }

        public void w(boolean z) {
            this.kd = z;
        }

        public void xj(int i) {
            this.y = i;
        }

        public void xj(boolean z) {
            this.g = z;
        }

        public void xj(Map<String, Object> map) {
            this.qt = map;
        }
    }

    public e(long j, String str, int i, com.bykv.vk.openvk.component.video.api.w.u uVar, ws wsVar) {
        this.xj = j;
        this.hf = str;
        this.w = i;
        this.u = uVar;
        this.kd = wsVar;
    }

    public String hf() {
        return this.hf;
    }

    public ws kd() {
        return this.kd;
    }

    public com.bykv.vk.openvk.component.video.api.w.u u() {
        return this.u;
    }

    public int w() {
        return this.w;
    }

    public long xj() {
        return this.xj;
    }
}
