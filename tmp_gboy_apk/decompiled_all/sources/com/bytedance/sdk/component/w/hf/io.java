package com.bytedance.sdk.component.w.hf;

import ADYaiT.CtFAbx;
import com.baidu.mobads.sdk.internal.an;
import com.bytedance.sdk.component.w.hf.yo;
import java.net.URL;

/* loaded from: D:\mgba-android-version\tmp_gboy_apk\decoded\classes.dex */
public final class io {
    private volatile u c;
    final String hf;
    final Object kd;
    final x u;
    final yo w;
    final v xj;
    public ai y;

    public static class xj {
        String hf;
        Object kd;
        x u;
        yo.xj w;
        v xj;
        ai y;

        public xj() {
            this.hf = an.c;
            this.w = new yo.xj();
        }

        public xj delete(x xVar) {
            return xj("DELETE", xVar);
        }

        public xj hf(String str, String str2) {
            this.w.xj(str, str2);
            return this;
        }

        public xj xj(v vVar) {
            if (vVar == null) {
                throw new NullPointerException("url == null");
            }
            this.xj = vVar;
            return this;
        }

        public xj delete() {
            return delete(com.bytedance.sdk.component.w.hf.xj.w.u);
        }

        public xj hf(String str) {
            this.w.hf(str);
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
                v kd = v.kd(str2);
                if (kd != null) {
                    return xj(kd);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(str2)));
            }
            throw new NullPointerException("url == null");
        }

        public xj(io ioVar) {
            this.xj = ioVar.xj;
            this.hf = ioVar.hf;
            this.u = ioVar.u;
            this.kd = ioVar.kd;
            this.w = ioVar.w.hf();
            this.y = ioVar.y;
        }

        public xj xj(URL url) {
            if (url != null) {
                v xj = v.xj(url);
                if (xj != null) {
                    return xj(xj);
                }
                throw new IllegalArgumentException("unexpected url: ".concat(String.valueOf(url)));
            }
            throw new NullPointerException("url == null");
        }

        public xj xj(String str, String str2) {
            this.w.w(str, str2);
            return this;
        }

        public xj xj(yo yoVar) {
            this.w = yoVar.hf();
            return this;
        }

        public xj xj(u uVar) {
            String uVar2 = uVar.toString();
            return uVar2.isEmpty() ? hf("Cache-Control") : xj("Cache-Control", uVar2);
        }

        public xj xj(String str, x xVar) {
            if (str != null) {
                if (str.length() == 0) {
                    throw new IllegalArgumentException("method.length() == 0");
                }
                if (xVar != null && !com.bytedance.sdk.component.w.hf.xj.w.y.w(str)) {
                    throw new IllegalArgumentException(CtFAbx.BI9f7h("method ", str, " must not have a request body."));
                }
                if (xVar == null && com.bytedance.sdk.component.w.hf.xj.w.y.hf(str)) {
                    throw new IllegalArgumentException(CtFAbx.BI9f7h("method ", str, " must have a request body."));
                }
                this.hf = str;
                this.u = xVar;
                return this;
            }
            throw new NullPointerException("method == null");
        }

        public xj xj(Object obj) {
            this.kd = obj;
            return this;
        }

        public io xj() {
            if (this.xj != null) {
                return new io(this);
            }
            throw new IllegalStateException("url == null");
        }
    }

    public io(xj xjVar) {
        this.xj = xjVar.xj;
        this.hf = xjVar.hf;
        this.w = xjVar.w.xj();
        this.u = xjVar.u;
        Object obj = xjVar.kd;
        this.kd = obj == null ? this : obj;
        ai aiVar = xjVar.y;
        if (aiVar != null) {
            this.y = aiVar;
        } else {
            this.y = new ai();
        }
    }

    public u c() {
        u uVar = this.c;
        if (uVar != null) {
            return uVar;
        }
        u xj2 = u.xj(this.w);
        this.c = xj2;
        return xj2;
    }

    public boolean f() {
        return this.xj.u();
    }

    public String hf() {
        return this.hf;
    }

    public Object kd() {
        return this.kd;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{method=");
        sb.append(this.hf);
        sb.append(", url=");
        sb.append(this.xj);
        sb.append(", tag=");
        Object obj = this.kd;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public x u() {
        return this.u;
    }

    public yo w() {
        return this.w;
    }

    public v xj() {
        return this.xj;
    }

    public xj y() {
        return new xj(this);
    }

    public String xj(String str) {
        return this.w.xj(str);
    }
}
