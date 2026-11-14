package com.bytedance.sdk.component.hf.xj;

import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.hf.xj.y;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public abstract class am {
    public pl xj;

    public static class xj {
        y.xj c;
        public Map<String, List<String>> hf;
        Object kd;
        String u;
        c w;
        com.bytedance.sdk.component.hf.xj.xj xj;
        qt y;

        public xj() {
            this.hf = new HashMap();
            this.c = new y.xj();
        }

        public xj hf(String str, String str2) {
            if (!this.hf.containsKey(str)) {
                this.hf.put(str, new ArrayList());
            }
            this.hf.get(str).add(str2);
            return this;
        }

        public xj xj(com.bytedance.sdk.component.hf.xj.xj xjVar) {
            this.xj = xjVar;
            return this;
        }

        public xj xj(Object obj) {
            this.kd = obj;
            return this;
        }

        public xj xj(String str) {
            String str2;
            if (str != null) {
                if (str.regionMatches(true, 0, "ws:", 0, 3)) {
                    str2 = "http:" + str.substring(3);
                } else if (str.regionMatches(true, 0, "wss:", 0, 4)) {
                    str2 = "https:" + str.substring(4);
                } else {
                    str2 = str;
                }
                c w = c.w(str2);
                if (w != null) {
                    return xj(w);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str2)));
            }
            throw new NullPointerException("url == null");
        }

        public xj(am amVar) {
            this.w = amVar.hf();
            this.u = amVar.w();
            this.hf = amVar.u();
            this.kd = amVar.xj();
            this.y = amVar.y();
            this.xj = amVar.kd();
        }

        public am hf() {
            return new am() { // from class: com.bytedance.sdk.component.hf.xj.am.xj.1
                @Override // com.bytedance.sdk.component.hf.xj.am
                public c hf() {
                    return xj.this.w;
                }

                @Override // com.bytedance.sdk.component.hf.xj.am
                public com.bytedance.sdk.component.hf.xj.xj kd() {
                    return xj.this.xj;
                }

                public String toString() {
                    return "";
                }

                @Override // com.bytedance.sdk.component.hf.xj.am
                public Map u() {
                    return xj.this.hf;
                }

                @Override // com.bytedance.sdk.component.hf.xj.am
                public String w() {
                    return xj.this.u;
                }

                @Override // com.bytedance.sdk.component.hf.xj.am
                public Object xj() {
                    return xj.this.kd;
                }

                @Override // com.bytedance.sdk.component.hf.xj.am
                public qt y() {
                    return xj.this.y;
                }
            };
        }

        public xj xj(c cVar) {
            this.w = cVar;
            return this;
        }

        public xj xj(String str, String str2) {
            return hf(str, str2);
        }

        public xj xj(y yVar) {
            if (yVar != null) {
                this.hf = yVar.hf();
            }
            return this;
        }

        public xj xj() {
            return xj(an.c, (qt) null);
        }

        public xj xj(String str, qt qtVar) {
            this.u = str;
            this.y = qtVar;
            return this;
        }

        public xj xj(qt qtVar) {
            return xj(an.b, qtVar);
        }
    }

    public xj c() {
        return new xj(this);
    }

    public abstract c hf();

    public abstract com.bytedance.sdk.component.hf.xj.xj kd();

    public abstract Map<String, List<String>> u();

    public abstract String w();

    public abstract Object xj();

    public void xj(pl plVar) {
        this.xj = plVar;
    }

    public qt y() {
        return null;
    }
}
