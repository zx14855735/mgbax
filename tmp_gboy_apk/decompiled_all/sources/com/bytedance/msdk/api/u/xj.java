package com.bytedance.msdk.api.u;

import com.bykv.vk.openvk.api.proto.PluginValueSet;
import com.bytedance.msdk.api.u.f;
import com.bytedance.msdk.api.u.pl;
import com.bytedance.msdk.api.u.u;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public class xj {
    private PluginValueSet am;
    private f c;
    private y d;
    private u f;
    private Map<String, Object> g;
    private String hf;
    private boolean kd;
    private boolean p;

    /* renamed from: pl, reason: collision with root package name */
    private JSONObject f10112pl;
    private boolean qt;
    private Map<String, Object> tf;
    private String u;
    private boolean w;
    private String xj;
    private pl y;

    /* renamed from: com.bytedance.msdk.api.u.xj$xj, reason: collision with other inner class name */
    public static class C0051xj {
        private PluginValueSet am;
        private f c;
        private y d;
        private u f;
        private Map<String, Object> g;
        private String hf;

        /* renamed from: pl, reason: collision with root package name */
        private JSONObject f10117pl;
        private boolean qt;
        private Map<String, Object> tf;
        private String xj;
        private pl y;
        private boolean w = false;
        private String u = "";
        private boolean kd = false;
        private boolean p = false;

        public C0051xj hf(String str) {
            this.hf = str;
            return this;
        }

        public C0051xj u(boolean z) {
            this.qt = z;
            return this;
        }

        public C0051xj w(String str) {
            this.u = str;
            return this;
        }

        public C0051xj xj(String str) {
            this.xj = str;
            return this;
        }

        public C0051xj hf(boolean z) {
            this.kd = z;
            return this;
        }

        public C0051xj w(boolean z) {
            this.p = z;
            return this;
        }

        public C0051xj xj(boolean z) {
            this.w = z;
            return this;
        }

        public C0051xj xj(pl plVar) {
            this.y = plVar;
            return this;
        }

        public C0051xj xj(f fVar) {
            this.c = fVar;
            return this;
        }

        public C0051xj xj(y yVar) {
            this.d = yVar;
            return this;
        }

        public C0051xj xj(Map<String, Object> map) {
            if (map != null && !map.isEmpty()) {
                if (this.tf == null) {
                    this.tf = new HashMap();
                }
                this.tf.putAll(map);
            }
            return this;
        }

        public C0051xj xj(JSONObject jSONObject) {
            this.f10117pl = jSONObject;
            return this;
        }

        public C0051xj xj(PluginValueSet pluginValueSet) {
            this.am = pluginValueSet;
            return this;
        }

        public xj xj() {
            return new xj(this);
        }
    }

    public PluginValueSet am() {
        return this.am;
    }

    public f c() {
        return this.c;
    }

    public y d() {
        return this.d;
    }

    public u f() {
        return this.f;
    }

    public Map<String, Object> g() {
        return this.g;
    }

    public String hf() {
        return this.hf;
    }

    public boolean kd() {
        return this.kd;
    }

    public boolean p() {
        return this.p;
    }

    public JSONObject pl() {
        return this.f10112pl;
    }

    public boolean qt() {
        return this.qt;
    }

    public Map<String, Object> tf() {
        return this.tf;
    }

    public String u() {
        return this.u;
    }

    public boolean w() {
        return this.w;
    }

    public String xj() {
        return this.xj;
    }

    public pl y() {
        return this.y;
    }

    private xj(C0051xj c0051xj) {
        this.xj = c0051xj.xj;
        this.hf = c0051xj.hf;
        this.w = c0051xj.w;
        this.u = c0051xj.u;
        this.kd = c0051xj.kd;
        if (c0051xj.y != null) {
            this.y = c0051xj.y;
        } else {
            this.y = new pl.xj().xj();
        }
        if (c0051xj.c != null) {
            this.c = c0051xj.c;
        } else {
            this.c = new f.xj().xj();
        }
        if (c0051xj.f != null) {
            this.f = c0051xj.f;
        } else {
            this.f = new u.xj().xj();
        }
        if (c0051xj.d != null) {
            this.d = c0051xj.d;
        } else {
            this.d = new y();
        }
        this.tf = c0051xj.tf;
        this.p = c0051xj.p;
        this.f10112pl = c0051xj.f10117pl;
        this.g = c0051xj.g;
        this.am = c0051xj.am;
        this.qt = c0051xj.qt;
    }
}
