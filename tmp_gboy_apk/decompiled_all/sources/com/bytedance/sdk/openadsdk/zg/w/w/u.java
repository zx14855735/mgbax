package com.bytedance.sdk.openadsdk.zg.w.w;

import IzHBwY.AYUAbz;
import J3FDQU.A2egSU;
import android.util.SparseArray;
import com.bykv.vk.openvk.api.proto.PluginValueSet;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes2.dex */
public class u {
    public final PluginValueSet hf;

    public static class xj {
        private final AYUAbz xj = AYUAbz.A4TApA();

        public xj c(boolean z) {
            this.xj.AYUAbz(262111, z);
            return this;
        }

        public xj hf(boolean z) {
            this.xj.AYUAbz(262103, z);
            return this;
        }

        public xj kd(boolean z) {
            this.xj.AYUAbz(262108, z);
            return this;
        }

        public xj u(boolean z) {
            this.xj.AYUAbz(262106, z);
            return this;
        }

        public xj w(boolean z) {
            this.xj.AYUAbz(262104, z);
            return this;
        }

        public xj xj(boolean z) {
            this.xj.AYUAbz(262101, z);
            return this;
        }

        public xj y(boolean z) {
            this.xj.AYUAbz(262110, z);
            return this;
        }

        public xj hf(String str) {
            this.xj.ASJ6gh(262107, str);
            return this;
        }

        public xj u(String str) {
            this.xj.ASJ6gh(262112, str);
            return this;
        }

        public xj w(String str) {
            this.xj.ASJ6gh(262109, str);
            return this;
        }

        public xj xj(w wVar) {
            this.xj.ARc23Z(262102, wVar);
            return this;
        }

        public xj xj(String str) {
            this.xj.ASJ6gh(262105, str);
            return this;
        }

        public u xj() {
            return new u(this.xj.A2egSU().sparseArray());
        }
    }

    public u(SparseArray<Object> sparseArray) {
        this.hf = A2egSU.ADYaiT(sparseArray);
    }

    public String am() {
        return (String) this.hf.objectValue(262112, String.class);
    }

    public boolean c() {
        return this.hf.booleanValue(262111);
    }

    public w d() {
        SparseArray sparseArray = (SparseArray) this.hf.objectValue(262102, SparseArray.class);
        if (sparseArray != null) {
            return new w(sparseArray);
        }
        return null;
    }

    public boolean f() {
        return this.hf.booleanValue(262120);
    }

    public boolean g() {
        return this.hf.booleanValue(262121);
    }

    public boolean hf() {
        return this.hf.booleanValue(262103);
    }

    public boolean kd() {
        return this.hf.booleanValue(262108);
    }

    public String p() {
        return (String) this.hf.objectValue(262107, String.class);
    }

    public String pl() {
        return (String) this.hf.objectValue(262109, String.class);
    }

    public Map<String, Object> qt() {
        return (Map) this.hf.objectValue(262119, Map.class);
    }

    public String tf() {
        return (String) this.hf.objectValue(262105, String.class);
    }

    public boolean u() {
        return this.hf.booleanValue(262106);
    }

    public boolean w() {
        return this.hf.booleanValue(262104);
    }

    public boolean xj() {
        return this.hf.booleanValue(262101);
    }

    public boolean y() {
        return this.hf.booleanValue(262110);
    }

    public com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf zg() {
        SparseArray sparseArray = (SparseArray) this.hf.objectValue(262113, SparseArray.class);
        if (sparseArray != null) {
            return new com.bytedance.sdk.openadsdk.mediation.init.xj.hf.xj.hf(sparseArray);
        }
        return null;
    }
}
