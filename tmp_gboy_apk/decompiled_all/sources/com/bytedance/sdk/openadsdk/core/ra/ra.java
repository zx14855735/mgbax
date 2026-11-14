package com.bytedance.sdk.openadsdk.core.ra;

import android.util.SparseArray;
import com.bytedance.sdk.openadsdk.core.hf.u;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class ra implements com.bytedance.sdk.component.adexpress.w {
    public final String am;
    public final int c;
    public final int d;
    public String e;
    public final int f;
    public final String g;
    public final float hf;
    public final long kd;
    public final String p;

    /* renamed from: pl, reason: collision with root package name */
    public final String f10412pl;
    public final boolean qt;
    public final int tf;
    public final float u;
    private JSONObject v;
    public final float w;
    public final float xj;
    public final long y;
    public int yo;
    public SparseArray<u.xj> zg;

    public static class xj {
        private String am;
        private float c;
        private int d;
        private JSONObject e;
        private int f;
        private String g;
        private long hf;
        private float kd;
        private int p;

        /* renamed from: pl, reason: collision with root package name */
        private String f10413pl;
        private String qt;
        private int tf;
        private float u;
        private long w;
        private float y;
        private String yo;
        private boolean zg;
        protected SparseArray<u.xj> xj = new SparseArray<>();
        private int v = -1;

        public xj hf(long j) {
            this.w = j;
            return this;
        }

        public xj kd(String str) {
            this.yo = str;
            return this;
        }

        public xj u(float f) {
            this.c = f;
            return this;
        }

        public xj w(float f) {
            this.y = f;
            return this;
        }

        public xj xj(boolean z) {
            this.zg = z;
            return this;
        }

        public xj hf(float f) {
            this.kd = f;
            return this;
        }

        public xj kd(int i) {
            this.v = i;
            return this;
        }

        public xj u(int i) {
            this.p = i;
            return this;
        }

        public xj w(int i) {
            this.tf = i;
            return this;
        }

        public xj xj(long j) {
            this.hf = j;
            return this;
        }

        public xj hf(int i) {
            this.d = i;
            return this;
        }

        public xj u(String str) {
            this.qt = str;
            return this;
        }

        public xj w(String str) {
            this.am = str;
            return this;
        }

        public xj xj(float f) {
            this.u = f;
            return this;
        }

        public xj hf(String str) {
            this.g = str;
            return this;
        }

        public xj xj(int i) {
            this.f = i;
            return this;
        }

        public xj xj(String str) {
            this.f10413pl = str;
            return this;
        }

        public xj xj(SparseArray<u.xj> sparseArray) {
            this.xj = sparseArray;
            return this;
        }

        public xj xj(JSONObject jSONObject) {
            this.e = jSONObject;
            return this;
        }

        public ra xj() {
            return new ra(this);
        }
    }

    public JSONObject xj() {
        if (this.v == null) {
            this.v = new JSONObject();
        }
        return this.v;
    }

    private ra(xj xjVar) {
        this.yo = -1;
        this.xj = xjVar.c;
        this.hf = xjVar.y;
        this.w = xjVar.kd;
        this.u = xjVar.u;
        this.kd = xjVar.w;
        this.y = xjVar.hf;
        this.c = xjVar.f;
        this.f = xjVar.d;
        this.d = xjVar.tf;
        this.tf = xjVar.p;
        this.p = xjVar.f10413pl;
        this.zg = xjVar.xj;
        this.qt = xjVar.zg;
        this.v = xjVar.e;
        this.f10412pl = xjVar.g;
        this.g = xjVar.am;
        this.am = xjVar.qt;
        this.e = xjVar.yo;
        this.yo = xjVar.v;
    }
}
